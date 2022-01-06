/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.repositories.Gram01Repository;
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

  @Override
  public List<Gram01> Gram01List01(Long gram)
  {
    return (List<Gram01>) this.Gram01Repository.gram01List01(gram);
  }

  @Override
  public Long Gram01MaxSenu(Long gram)
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
  {
    Gram01 gram01 = null;
    Gram01Key key = new Gram01Key(gram, senu);
    gram01 = (Gram01) this.Gram01Repository.findById(key).orElse(null);
    return gram01;
  }

  @Override
  public Gram01 Gram01Post01(Gram01 gram01)
  {
    if ((gram01.getSenu() != null && gram01.getSenu() < 1) || gram01.getSenu() == null)
    {
      gram01.setSenu(this.Gram01MaxSenu(gram01.getGram()) + 1);
    }
    return (Gram01) this.Gram01Repository.save(gram01);
  }

  @Override
  public Gram01 Gram01Post02(Long gram, Long senu, Gram01 gram01)
  {
    Gram01 gram01db = null;
    if (senu != null)
    {
      gram01db = this.Gram01Select01(gram, senu);
      //
      if (gram01db != null)
      {

      }
    } else
    {
      gram01db = new Gram01();
      gram01db.setGram(gram);
    }
    this.CopyGram01(gram01db, gram01);
    return (Gram01) Gram01Post01(gram01db);
  }

  private void CopyGram01(Gram01 gram01db, Gram01 gram01)
  {
    gram01db.setField_name(gram01.getField_name());
    gram01db.setField_type(gram01.getField_type());
    gram01db.setValue_num(gram01.getValue_num());
    gram01db.setValue_str(gram01.getValue_str());
  }

}
