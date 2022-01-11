/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import javax.servlet.http.Cookie;
import opsw.uci.prj.arifacts.OpswEjbContext;
import opsw.uci.prj.cat.CatException;

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

  public synchronized void OpswSetConnectionByCookie()
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
  }

  public void OpswClearConnectionByCookie()
  {
    OpswEjbContext.clear();
  }
}
