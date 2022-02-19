/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.globals;

import opsw.uci.prj.cat.CatException;

/**
 *
 * @author e.oulis
 */
public class OpswLanguage
{

  public static void OpswLanguage(OpswLoginVars wLoginVars, String ilang) throws CatException
  {
    try
    {
      if (ilang != null && ilang.equalsIgnoreCase(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EL))
      {
        wLoginVars.setLang(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EL);
      }
      else
      {
        wLoginVars.setLang(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EN);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
