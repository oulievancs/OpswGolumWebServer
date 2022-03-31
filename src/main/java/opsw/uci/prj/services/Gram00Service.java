/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaServiceBase;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.Gram00Rec02;
import opsw.uci.prj.records.cat.CatThmlfObject01;

/**
 *
 * @author oulis
 */
public interface Gram00Service extends CatEjbJpaServiceBase
{

  public Gram00 Gram00Select01(Long gram) throws CatException;

  public List<Gram00> Gram00List01() throws CatException;

  public Gram00 Gram00Select02(Long gram) throws CatException;

  public Gram00 Gram00Post01(Gram00 gram00) throws CatException;

  public Gram00 Gram00Post02(Long gram, Gram00 gram00, OpswLoginVars loginVars) throws CatException;

  public Gram00 Gram00Gram00Post03(Gram00 gram00, OpswLoginVars loginVars) throws CatException;

  public Gram00Rec02 Gram00PostED01(Long gram, Gram00Rec02 gram00, OpswLoginVars loginVars)
          throws CatException;

  public Gram00Rec02 Gram00PostED02(Long gram, Gram00Rec02 gram00, OpswLoginVars loginVars,
          List<CatThmlfObject01> wInternalKeyList) throws CatException;

  public void Gram00Delete01(Long gram) throws CatException;

  public List<Gram00Rec01> Gram00Rec01List01() throws CatException;

  public Gram00Rec02 Gram00Rec02Select01(Long gram) throws CatException;

  public Gram00Rec02 Gram00Rec02EDSelect02(Long gram, List<CatThmlfObject01> wInternalKeyList)
          throws CatException;
}
