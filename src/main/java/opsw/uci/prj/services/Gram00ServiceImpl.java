/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.ArrayList;
import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.repositories.Gram00Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class Gram00ServiceImpl implements Gram00Service
{

  @Autowired
  private Gram00Repository Gram00Repository;

  @Autowired
  private SequencesService SequencesService;

  @Autowired
  private Gram01Service Gram01Service;

  @Override
  public Gram00 Gram00Select01(Long gram)
  {
    return (Gram00) this.Gram00Repository.findById(gram).orElse(null);
  }

  @Override
  public List<Gram00> Gram00List01()
  {
    return (List<Gram00>) this.Gram00Repository.findAll();
  }

  @Override
  public Gram00 Gram00Select02(Long gram)
  {
    Gram00 gram00 = null;

    gram00 = this.Gram00Select01(gram);
    if (gram00 != null)
    {
      gram00.setGram01List(this.Gram01Service.Gram01List01(gram00.getGram()));
    }

    return gram00;
  }

  @Override
  public Gram00 Gram00Post01(Gram00 gram00)
  {
    if (gram00.getGram() == null || gram00.getGram() <= 0)
    {
      gram00.setGram(this.SequencesService.SequencesGetNextVal(Sequences.SEQ_GRAM00));
      //gram00.setGram(Long.valueOf(1998));
    }
    return (Gram00) this.Gram00Repository.save(gram00);
  }

  @Override
  public Gram00 Gram00Post02(Long gram, Gram00 gram00)
  {
    Gram00 gram00db = null;
    if (gram != null)
    {
      gram00db = this.Gram00Select02(gram);
      if (gram00db != null)
      {
        gram00db.setGram01List(this.Gram01Service.Gram01List01(gram));
      }
    } else if (gram == null)
    {
      gram00db = new Gram00();
    }
    this.CopyGram00(gram00db, gram00);
    return (Gram00) this.Gram00Post01(gram00);
  }

  private void CopyGram00(Gram00 gram00db, Gram00 gram00)
  {
    gram00db.setDescr(gram00.getDescr());
    gram00db.setDescr_sea(gram00.getDescr_sea());
    //gram00db.setDate_create(gram00.getDate_create());
    //gram00db.setUser_create(gram00.getUser_create());
    //gram00db.setDate_modify(gram00.getDate_modify());
    //gram00db.setUser_modify(gram00.getUser_modify());
    /*if (gram00db.getGram01List() == null)
    {
      gram00db.setGram01List(new ArrayList<Gram01>());
    }
    
    gram00db.getGram01List().clear();
    if (gram00.getGram01List() != null)
    {
      gram00db.getGram01List().addAll(gram00.getGram01List());
    }*/

  }
  
  @Override
  public void Gram00Delete01(Long gram)
  {
    Gram00 gram00 = this.Gram00Select02(gram);
    if(gram00 != null)
    {
      if(gram00.getGram01List() != null && !gram00.getGram01List().isEmpty())
      {
        for(Gram01 gram01 : gram00.getGram01List())
        {
          Gram01Key key = new Gram01Key(gram01.getGram(), gram01.getSenu());
          this.Gram01Service.Gram01Delete01(key);
        }
      }
      this.Gram00Repository.deleteById(gram00.getGram());
    }
  }

}
