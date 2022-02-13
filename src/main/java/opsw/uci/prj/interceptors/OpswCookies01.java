/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import opsw.uci.prj.arifacts.OpswEjbContext;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.utils.OpswStringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author e.oulis
 */
public class OpswCookies01
{

  private Cookie[] cookies;
  private HttpSession session;

  public OpswCookies01()
  {
    super();
    this.cookies = null;
    this.session = null;
  }

  public Cookie[] getCookies()
  {
    return cookies;
  }

  public void setCookies(Cookie[] cookies)
  {
    this.cookies = cookies;
  }

  public HttpSession getSession()
  {
    return session;
  }

  public void setSession(HttpSession session)
  {
    this.session = session;
  }

  public void OpswSetConnectionByCookie()
          throws CatException
  {
    try
    {
      if (this.session != null)
      {
        String vConnection = (String) this.session.getAttribute(OpswLoginVars.OPSW_LOGIN_CONNECTION_DS);

        if (vConnection != null)
        {
          OpswEjbContext.setCurrentTenant(vConnection);
        }
        else
        {
          OpswEjbContext.setCurrentTenant(null);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
//    Cookie vConneCoo = null;
//
//    if (this.cookies != null && this.cookies.length > 0)
//    {
//      for (Cookie c : this.cookies)
//      {
//        if (c.getName() != null && c.getName().equals(OpswLoginVars.OPSW_LOGIN_CONNECTION_DS))
//        {
//          vConneCoo = c;
//        }
//      }
//    }
//
//    if (vConneCoo != null)
//    {
//      OpswEjbContext.setCurrentTenant(vConneCoo.getValue());
//    }
//    else
//    {
//      OpswEjbContext.setCurrentTenant(null);
//    }

  }

  public void OpswClearConnectionByCookie()
          throws CatException
  {
    try
    {
      OpswEjbContext.clear();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public static void OpswFillLoginVarsFromCookies01(HttpServletRequest request, OpswLoginVars wLoginVars)
          throws CatException
  {
    try
    {

      HttpSession vsess = request.getSession(false);

      if (vsess != null)
      {
        //String vlogUser = (String) vsess.getAttribute(OpswLoginVars.OPSW_LOGIN_USER_CONST);
        //wLoginVars.setLoginUser(vlogUser);

        String vlogEtai = (String) vsess.getAttribute(OpswLoginVars.OPSW_LOGIN_ETAI_CONST);
        wLoginVars.setEtai(OpswStringUtils.OpswStringToShort(vlogEtai));

        String vConnectionDs = (String) vsess.getAttribute(OpswLoginVars.OPSW_LOGIN_CONNECTION_DS);
        wLoginVars.setConnectionDs(vConnectionDs);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Principal principal = null;

        if (authentication != null)
        {
          principal = (Principal) authentication.getPrincipal();
        }

        if (principal != null)
        {
          wLoginVars.setLoginUser(principal.getName());
        }
        else
        {
          wLoginVars.setLoginUser("dev");
        }

        if (authentication != null)
        {
          List<String> vroles = new ArrayList<>();

          wLoginVars.setRoles(vroles);
          boolean vauthorities = authentication.getAuthorities().stream()
                  .anyMatch(a ->
                  {
                    String vopswRole = a.getAuthority();

                    if (vopswRole != null)
                    {
                      vopswRole = vopswRole.substring(5);
                    }
                    vroles.add(vopswRole);
                    OpswLogger.LoggerLogDebug("Authority -> " + vopswRole);
                    return false;
                  });
        }
      }

//      Cookie[] vcookies = request.getCookies();
//      if (vcookies != null && vcookies.length > 0)
//      {
//        for (Cookie c : vcookies)
//        {
//          if (c.getName() != null)
//          {
//            if (c.getName().equals(OpswLoginVars.OPSW_LOGIN_USER_CONST))
//            {
//              wLoginVars.setLoginUser(c.getValue());
//            }
//
//            if (c.getName().equals(OpswLoginVars.OPSW_LOGIN_ETAI_CONST))
//            {
//              wLoginVars.setEtai(OpswStringUtils.OpswStringToShort(c.getValue()));
//            }
//
//            if (c.getName().equals(OpswLoginVars.OPSW_LOGIN_CONNECTION_DS))
//            {
//              wLoginVars.setConnectionDs(c.getValue());
//            }
//          }
//        }
//      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public static void OpswFillCookiesFromLoginVars01(HttpServletRequest request, OpswLoginVars wLoginVars)
          throws CatException
  {
    try
    {
//      Cookie cookie = new Cookie(OpswLoginVars.OPSW_LOGIN_USER_CONST, wLoginVars.getLoginUser());
//      // expires in 7 days
//      cookie.setMaxAge(7 * 24 * 60 * 60);
//      response.addCookie(cookie);
//
//      cookie = new Cookie(OpswLoginVars.OPSW_LOGIN_ETAI_CONST, OpswStringUtils.OpswShortToString(wLoginVars.getEtai()));
//      // expires in 7 days
//      cookie.setMaxAge(7 * 24 * 60 * 60);
//      response.addCookie(cookie);
//
//      cookie = new Cookie(OpswLoginVars.OPSW_LOGIN_CONNECTION_DS, wLoginVars.getConnectionDs());
//      // expires in 7 days
//      cookie.setMaxAge(7 * 24 * 60 * 60);
//      response.addCookie(cookie);

      HttpSession vsess = request.getSession(true);

      //vsess.setAttribute(OpswLoginVars.OPSW_LOGIN_USER_CONST, wLoginVars.getLoginUser());
      vsess.setAttribute(OpswLoginVars.OPSW_LOGIN_ETAI_CONST, OpswStringUtils.OpswShortToString(wLoginVars.getEtai()));
      vsess.setAttribute(OpswLoginVars.OPSW_LOGIN_CONNECTION_DS, wLoginVars.getConnectionDs());

    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
