/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.validations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.constants.OpswWebConst;
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
                && !(vuri.indexOf(OpswWebConst.OPSW_CONTROLLER_MAIN_INIT1_POST) > 0))
        {
          String vredUri = OpswSystemWebServer01.OPSW_SERVLET_CONTEXT_PATH
                  + OpswWebConst.OPSW_CONTROLLER_MAIN_INIT1;

          if (iLoginVars.getLang() != null && !iLoginVars.getLang().isEmpty())
          {
            vredUri += "?lang=" + iLoginVars.getLang();
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
}
