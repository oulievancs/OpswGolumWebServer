/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.OpswEntityManagerBase;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00SearchParams01;
import opsw.uci.prj.repositories.Assets00Repository;
import opsw.uci.prj.utils.OpswNumberUtils;
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

  @Override
  public List<Assets00Rec01> Assets00Rec01List01() throws CatException
  {
    List<Assets00Rec01> vlist = null;

    try
    {
      List<Assets00> vlist1 = this.Assets00List02();
      vlist = this.Assets00Rec01FromAssets00(vlist1);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vlist;
  }

  private List<Assets00Rec01> Assets00Rec01FromAssets00(List<Assets00> assets) throws CatException
  {
    List<Assets00Rec01> result = null;
    try
    {
      result = new ArrayList<>();
      if (assets != null && !assets.isEmpty())
      {
        for (Assets00 asset : assets)
        {
          Assets00Rec01 rec = new Assets00Rec01();
          result.add(rec);
          Assets00Rec01.CopyAssets00Rec01FromAssents00(asset, (Assets00) rec);
          if (OpswNumberUtils.OpswGetLong(asset.getSymb_id()) > 0)
          {
            Symb vsymb = this.SymbService.SymbSelect01(asset.getSymb_id());

            if (vsymb != null)
            {
              rec.setSymb_name(vsymb.getName());
              rec.setSymb_surename(vsymb.getSurename());
              rec.setSymb_tele(vsymb.getTele());
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  @Override
  public List<Assets00Rec01> Assets00List02(Calendar dateFrom, Calendar dateTo) throws CatException
  {
    List<Assets00Rec01> resultList = null;
    try
    {
      List<Assets00> vlist = this.Assets00Repository.Assets00FindByDate(dateFrom, dateTo);
      resultList = this.Assets00Rec01FromAssets00(vlist);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return resultList;
  }

  @Override
  public List<Assets00Rec01> Assets00List03(Assets00SearchParams01 iparams) throws CatException
  {
    List<Assets00Rec01> vlist = null;
    try
    {
      EntityManager em = (EntityManager) this.connection.getConnection();

      String vsql = "SELECT a FROM Assets00 a ";

      vsql += " WHERE a.assfile BETWEEN :dateFrom AND :dateTo ";

      if (iparams.getSymb_id() > 0)
      {
        vsql += " AND a.symb_id = :symb_id ";
      }

      Query q = em.createQuery(vsql);
      q.setParameter("dateFrom", iparams.getDateFrom());
      q.setParameter("dateTo", iparams.getDateTo());

      if (iparams.getSymb_id() > 0)
      {
        q.setParameter("symb_id", iparams.getSymb_id());
      }

      List<Assets00> vlist00 = (List<Assets00>) q.getResultList();

      vlist = this.Assets00Rec01FromAssets00(vlist00);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vlist;
  }

  @Override
  public Assets00 Assets00Select01(Long id) throws CatException
  {
    Assets00 result = null;
    try
    {
      result = (Assets00) this.Assets00Repository.findById(id).orElse(null);
    }
    catch(Exception e)
    {
      CatException.RethrowCatException(e);
      
    }
    return result;
  }

}
