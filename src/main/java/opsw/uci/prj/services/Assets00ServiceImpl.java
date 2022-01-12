/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.OpswEntityManagerBase;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.repositories.Assets00Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class Assets00ServiceImpl implements Assets00Service
{

  @Autowired
  private OpswEntityManagerBase connection;

  @Autowired
  private Assets00Repository Assets00Repository;

  @Autowired
  private SequencesService SequencesService;

  @Autowired
  private SymbService SymbService;

  @Override
  public List<Assets00> Assets00List01(Byte status)
  {
    return (List<Assets00>) this.Assets00Repository.Assets00FindByStatus(status);
  }

  @Override
  public List<Assets00> Assets00List02()
          throws CatException
  {
    List<Assets00> assets00List = null;
    EntityManager em = (EntityManager) this.connection.getConnection();
    Query qre = em.createQuery("SELECT a FROM Assets00 a WHERE 1 = 1");
    assets00List = (List<Assets00>) qre.getResultList();
    return (List<Assets00>) assets00List;//this.Assets00Repository.findAll();
  }

  @Override
  public Assets00 Assets00Insert(Assets00 assets00) throws CatException
  {
    return (Assets00) this.Assets00Repository.save(assets00);
  }

  @Override
  public Assets00 Assets00Post01(Assets00 assets00) throws CatException
  {
    Assets00 vassets00 = assets00;
    try
    {
      if (assets00.getAsset() == null || assets00.getAsset() < 1)
      {
        assets00.setAsset(this.SequencesService.SequencesGetNextVal(Sequences.SEQ_ASSETS00));
      }

      vassets00 = this.Assets00Insert(assets00);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vassets00;
  }

  @Override
  public Assets00 Assets00Post02(Assets00 assets00, boolean postSymb) throws CatException
  {
    Assets00 vassets00 = assets00;
    try
    {
      if (postSymb && vassets00.getSymb() != null)
      {
        Symb vsymb = this.SymbService.SymbPost01(vassets00.getSymb());

        vassets00.setSymb(vsymb);
      }
      vassets00 = this.Assets00Post01(assets00);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vassets00;
  }

}
