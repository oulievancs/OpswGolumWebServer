/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.system.OpswMenuDo01;
import opsw.uci.prj.validations.OpswValidations01;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author e.oulis
 */
public class OpswInterceptorServ01 implements HandlerInterceptor
{

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
          throws Exception
  {
    boolean result = true;
    Cookie[] vcookie = request.getCookies();
    HttpSession vsession = request.getSession(false);

    OpswCookies01 vopswCookies = new OpswCookies01();
    vopswCookies.setCookies(vcookie);
    vopswCookies.setSession(vsession);
    try
    {
      vopswCookies.OpswSetConnectionByCookie();
    }
    catch (Exception ex)
    {
      OpswLogger.LoggerLogException(ex);
    }
    //
    //*************VALIDATIONS*********************//
    OpswLoginVars vLoginVars = new OpswLoginVars();
    OpswCookies01.OpswFillLoginVarsFromCookies01(request, vLoginVars);
    result &= OpswValidations01.MakeLoginValidations01(vLoginVars, request, response);
    //*********************************************//

    return result;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
          throws Exception
  {
    OpswCookies01 vopswCookies01 = new OpswCookies01();
    try
    {
      vopswCookies01.OpswClearConnectionByCookie();
    }
    catch (Exception ex)
    {
      OpswLogger.LoggerLogException(ex);
    }
    //
    OpswMenuDo01.MakeMenu01(request, model);
    //
    this.SetRequestResponseHeaders(request, response);
  }

  private void SetRequestResponseHeaders(HttpServletRequest request, HttpServletResponse response)
  {
    //Για το resubmition form στο back button του browser.
    //https://stackoverflow.com/questions/19215637/navigate-back-with-php-form-submission
    response.addHeader("Cache-Control", "no cache");
  }
}
