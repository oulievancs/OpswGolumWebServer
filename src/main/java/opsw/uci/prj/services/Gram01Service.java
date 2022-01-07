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
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
public interface Gram01Service
{

  public List<Gram01> Gram01List01(Long gram);

  public Long Gram01MaxSenu(Long gram);
  
  public Gram01 Gram01Select01(Long gram, Long senu);

  public Gram01 Gram01Post01(Gram01 gram01);

  public Gram01 Gram01Post02(Long gram, Long senu, Gram01 gram01);
  
  public void Gram01Delete01(Gram01Key key);
}
