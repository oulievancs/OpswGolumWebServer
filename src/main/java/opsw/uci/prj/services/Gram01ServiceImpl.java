/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.Gram01Rec01;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.repositories.Gram01Repository;
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
public class Gram01ServiceImpl implements Gram01Service
{

  @Autowired
  private Gram01Repository Gram01Repository;

  @Autowired
  private OpswGlobalServices01 OpswGlobalServices01;

  @PostConstruct
  public void init00()
  {
    this.OpswGlobalServices01.setGram01Service(this);
  }

  @Override
  public List<Gram01> Gram01List01(Long gram)
          throws CatException
  {
    return (List<Gram01>) this.Gram01Repository.gram01List01(gram);
  }

  @Override
  public Long Gram01MaxSenu(Long gram)
          throws CatException
  {
    Long maxSenu = this.Gram01Repository.gram01MaxSenu(gram);
    if (maxSenu == null)
    {
      maxSenu = Long.valueOf(1);
    }
    return maxSenu;
  }

  @Override
  public Gram01 Gram01Select01(Long gram, Long senu)
          throws CatException
  {
    Gram01 gram01 = null;
    Gram01Key key = new Gram01Key(gram, senu);
    gram01 = (Gram01) this.Gram01Repository.findById(key).orElse(null);
    return gram01;
  }

  @Override
  public Gram01 Gram01Post01(Gram01 gram01)
          throws CatException
  {
    if (OpswNumberUtils.OpswGetLong(gram01.getSenu()) < 1)
    {
      gram01.setSenu(this.Gram01MaxSenu(gram01.getGram()) + 1);
    }
    return (Gram01) this.Gram01Repository.saveAndFlush(gram01);
  }

  @Override
  public Gram01 Gram01Post02(Long gram, Long senu, Gram01 gram01)
          throws CatException
  {
    Gram01 result = null;
    try
    {
      Gram01 gram01db = null;
      if (senu != null)
      {
        gram01db = this.Gram01Select01(gram, senu);
      }
      if (gram01db == null)
      {
        gram01db = new Gram01();
        gram01db.setGram(gram);
        gram01db.setSenu(senu);
      }
      this.CopyGram01(gram01db, gram01);
      result = (Gram01) Gram01Post01(gram01db);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  private void CopyGram01(Gram01 gram01db, Gram01 gram01)
          throws CatException
  {
    try
    {
      gram01db.setField_name(gram01.getField_name());
      gram01db.setField_type(gram01.getField_type());
      gram01db.setExcel_index(gram01.getExcel_index());
      gram01db.setValue_num(gram01.getValue_num());
      gram01db.setValue_str(gram01.getValue_str());
      gram01db.setDate_format(gram01.getDate_format());
      gram01db.setConcatOrder(gram01.getConcatOrder());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  public void Gram01Delete01(Long gram, Long senu)
          throws CatException
  {
    Gram01Key key = new Gram01Key(gram, senu);
    this.Gram01Delete02(key);
  }

  @Override
  public void Gram01Delete02(Gram01Key key)
          throws CatException
  {
    this.Gram01Repository.deleteById(key);
  }

  @Override
  public List<Gram01Rec01> Gram01Rec01List01(Long gram)
          throws CatException
  {
    return (List<Gram01Rec01>) this.Gram01Repository.gram01Rec01List01(gram, Opswconstsv.FIELD_TYPE);
  }

  @Override
  public List<Gram01> Gram01List02(Long gram) throws CatException
  {
    return (List<Gram01>) this.Gram01Repository.gram01List02(gram);
  }

  @Override
  public List<Gram01> Gram01Post03(Long gram, List<Gram01> gram01List) throws CatException
  {
    List<Gram01> vgram01NewList = null;
    try
    {
      long vsenu = 0;

      if (gram01List != null)
      {
        vgram01NewList = new ArrayList<>();

        for (Gram01 gram01 : gram01List)
        {
          Gram01 vgram01New = this.Gram01Post02(gram, ++vsenu, gram01);
          vgram01NewList.add(vgram01New);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vgram01NewList;
  }

}
