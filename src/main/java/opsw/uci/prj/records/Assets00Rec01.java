/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;

import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.logic.OpswReflection;

/**
 *
 * @author oulis
 */
public class Assets00Rec01 extends Assets00
{

  private String symb_name;
  private String symb_surename;
  private String symb_tele;

  public Assets00Rec01()
  {
    super();
    this.symb_name = null;
    this.symb_surename = null;
    this.symb_tele = null;
  }

  public String getSymb_name()
  {
    return symb_name;
  }

  public void setSymb_name(String symb_name)
  {
    this.symb_name = symb_name;
  }

  public String getSymb_surename()
  {
    return symb_surename;
  }

  public void setSymb_surename(String symb_surename)
  {
    this.symb_surename = symb_surename;
  }

  public String getSymb_tele()
  {
    return symb_tele;
  }

  public void setSymb_tele(String symb_tel)
  {
    this.symb_tele = symb_tel;
  }

  public static void CopyAssets00Rec01FromAssents00(Assets00 from, Assets00 to)
          throws CatException
  {
    OpswReflection.OpswReflectionCopyParentObject(from, to, Assets00.class);
  }
}
