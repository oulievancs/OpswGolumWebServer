/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaServiceBase;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00Rec02;
import opsw.uci.prj.records.Assets00SearchParams01;

/**
 *
 * @author oulis
 */
public interface Assets00Service extends CatEjbJpaServiceBase
{

  public List<Assets00> Assets00List01(Byte status)
          throws CatException;

  public List<Assets00> Assets00List02() throws CatException;

  public Assets00 Assets00Insert(Assets00 assets00) throws CatException;

  public Assets00 Assets00Post01(Assets00 assets00) throws CatException;

  public Assets00 Assets00Post02(Assets00 assets00, boolean postSymb)
          throws CatException;

  public Assets00Rec02 Assets00PostEd01(Long assetId, Assets00Rec02 asset, OpswLoginVars logvars) throws CatException;
  
  public List<Assets00Rec01> Assets00Rec01List01() throws CatException;

  public List<Assets00Rec01> Assets00List02(Calendar dateFrom, Calendar dateTo) throws CatException;

  public List<Assets00Rec01> Assets00List03(Assets00SearchParams01 iparams) throws CatException;
  
  public Assets00Rec01 Assets00Select01(Long id) throws CatException;

  public long Assets00Count01(Long symb_id) throws CatException;

}
