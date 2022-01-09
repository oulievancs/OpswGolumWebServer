/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Gram00Rec01;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
public interface Gram00Service
{

  public Gram00 Gram00Select01(Long gram);

  public List<Gram00> Gram00List01();

  public Gram00 Gram00Select02(Long gram);

  public Gram00 Gram00Post01(Gram00 gram00);

  public Gram00 Gram00Post02(Long gram, Gram00 gram00, OpswLoginVars loginVars);
  
  public Gram00 Gram00PostED01(Long gram, Gram00 gram00, OpswLoginVars loginVars);
  
  public void Gram00Delete01(Long gram);
  
  public List<Gram00Rec01> Gram00Rec01List01();
}
