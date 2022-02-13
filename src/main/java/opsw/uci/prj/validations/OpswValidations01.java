/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.validations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opsw.uci.prj.cat.CatException;
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
                && !(vuri.substring(vuri.length() - 6, vuri.length()).equals("/init1"))
                && !(vuri.substring(vuri.length() - 11, vuri.length()).equals("/init1/post")))
        {
          response.sendRedirect(OpswSystemWebServer01.OPSW_SERVLET_CONTEXT_PATH + "/init1");
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
