/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.arifacts.OpswEjbContext;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.utils.OpswStringUtils;

/**
 *
 * @author e.oulis
 */
public class OpswCookies01
{

  public static final String OPSW_COOKIE_CONNECTION_DS = "opsw_cookie_connection_ds";

  private Cookie[] cookies;

  public OpswCookies01()
  {
    super();
    this.cookies = null;
  }

  public Cookie[] getCookies()
  {
    return cookies;
  }

  public void setCookies(Cookie[] cookies)
  {
    this.cookies = cookies;
  }

  public void OpswSetConnectionByCookie()
          throws CatException
  {
    Cookie vConneCoo = null;

    if (this.cookies != null && this.cookies.length > 0)
    {
      for (Cookie c : this.cookies)
      {
        if (c.getName() != null && c.getName().equals(OPSW_COOKIE_CONNECTION_DS))
        {
          vConneCoo = c;
        }
      }
    }

    if (vConneCoo != null)
    {
      OpswEjbContext.setCurrentTenant(vConneCoo.getValue());
    }
    else
    {
      OpswEjbContext.setCurrentTenant(null);
    }
  }

  public void OpswClearConnectionByCookie()
  {
    OpswEjbContext.clear();
  }

  public static void OpswFillLoginVarsFromCookies01(HttpServletRequest request, OpswLoginVars wLoginVars)
          throws CatException
  {
    try
    {
      Cookie[] vcookies = request.getCookies();

      if (vcookies != null && vcookies.length > 0)
      {
        for (Cookie c : vcookies)
        {
          if (c.getName() != null)
          {
            if (c.getName().equals(OpswLoginVars.LOGIN_USER_CONST))
            {
              wLoginVars.setLoginUser(c.getValue());
            }

            if (c.getName().equals(OpswLoginVars.LOGIN_ETAI_CONST))
            {
              wLoginVars.setEtai(OpswStringUtils.OpswStringToShort(c.getValue()));
            }
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
