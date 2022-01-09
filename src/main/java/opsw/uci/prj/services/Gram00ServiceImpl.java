/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;


import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.Gram01Rec01;
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
  public Gram00 Gram00Post02(Long gram, Gram00 gram00, OpswLoginVars loginVars)
  {
    Gram00 gram00db = null;
    Calendar cal2 = Calendar.getInstance();
    if (gram != null)
    {
      gram00db = this.Gram00Select02(gram);
    }
    else if (gram00db == null)
    {
      gram00db = new Gram00();
      gram00db.setDate_create(cal2);
      gram00db.setUser_create(loginVars.getLoginUser());
    }
    gram00db.setDate_modify(cal2);
    gram00db.setUser_modify(loginVars.getLoginUser());
    this.CopyGram00(gram00db, gram00);
    return (Gram00) this.Gram00Post01(gram00db);
  }

  private void CopyGram00(Gram00 gram00db, Gram00 gram00)
  {
    gram00db.setDescr(gram00.getDescr());
    gram00db.setDescr_sea(gram00.getDescr_sea());
    gram00db.setStart_line(gram00.getStart_line());
  }

  @Override
  public void Gram00Delete01(Long gram)
  {
    Gram00 gram00 = this.Gram00Select02(gram);
    if (gram00 != null)
    {
      if (gram00.getGram01List() != null && !gram00.getGram01List().isEmpty())
      {
        for (Gram01 gram01 : gram00.getGram01List())
        {
          Gram01Key key = new Gram01Key(gram01.getGram(), gram01.getSenu());
          this.Gram01Service.Gram01Delete02(key);
        }
      }
      this.Gram00Repository.deleteById(gram00.getGram());
    }
  }

  @Override
  public Gram00 Gram00PostED01(Long gram, Gram00 gram00, OpswLoginVars loginVars)
  {
    gram00.setUser_modify(loginVars.getLoginUser());
    return this.Gram00Post02(gram, gram00, loginVars);
  }

  @Override
  public List<Gram00Rec01> Gram00Rec01List01()
  {
    return this.Gram00Repository.gram00Rec01List01();
  }

}
