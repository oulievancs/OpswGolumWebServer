/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    OpswCookies01 vopswCookies = new OpswCookies01();
    vopswCookies.setCookies(vcookie);
    vopswCookies.OpswSetConnectionByCookie();

    return result;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
          throws Exception
  {
    OpswCookies01 vopswCookies01 = new OpswCookies01();
    vopswCookies01.OpswClearConnectionByCookie();
  }
}
