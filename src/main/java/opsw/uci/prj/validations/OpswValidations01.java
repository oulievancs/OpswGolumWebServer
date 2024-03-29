/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.validations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.globals.OpswLanguage;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.system.OpswSystemWebServer01;

/**
 *
 * @author oulis
 */
public class OpswValidations01
{

  public static boolean MakeLoginValidations01(OpswLoginVars iLoginVars, HttpServletRequest request,
          HttpServletResponse response)
          throws CatException
  {
    boolean result = true;
    try
    {
      boolean vgoon = true;

      vgoon &= iLoginVars.getEtai() > 0;
      vgoon &= iLoginVars.getLoginUser() != null && iLoginVars.getLoginUser().trim().length() > 0;

      if (response != null)
      {
        String vuri = request.getRequestURI();
        if (!vgoon
                //&& !(vuri.substring(vuri.length() - 6, vuri.length()).equals("/init1"))
                //&& !(vuri.substring(vuri.length() - 11, vuri.length()).equals("/init1/post"))
                && !(vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_MAIN_INIT1) > 0)
                && !(vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_MAIN_INIT1_POST) > 0)
                && (vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_ACTIONS) > 0
                || vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_ASSETS00) > 0
                || vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_GRAM) > 0
                || vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_MAIN) > 0
                || vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_MODAL) > 0
                || vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_NOTARY) > 0))
        {
          String vredUri = OpswSystemWebServer01.OPSW_SERVLET_CONTEXT_PATH
                  + OpswWebConst.OPSW_CONTROLLER_MAIN_INIT1;

          if (iLoginVars.getLang() != null && !iLoginVars.getLang().isEmpty())
          {
            vredUri += "?" + OpswLanguage.OPSW_LANG_PARAMETER + "=" + iLoginVars.getLang();
          }
          response.sendRedirect(vredUri);
          result = false;
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static boolean MakeAccessValidations(OpswLoginVars iloginVars, String[] irolesChk,
          boolean throwExcec) throws CatException
  {
    boolean result = false;
    try
    {
      if (irolesChk != null)
      {
        for (String rl : irolesChk)
        {
          for (String rl1 : iloginVars.getRoles())
          {
            if (rl1.equals(rl))
            {
              result |= true;
            }
          }
        }
      }

      if (throwExcec && !result)
      {
        throw new CatExceptionUser(CatException.CODE_ACCESS_DENIED, "Access Denied!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return result;
  }
}
