/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author oulis
 */
public class OpswSecurityUtils
{

  public static Authentication OpswSecurityGetAuthentication()
  {
    Authentication authentication = null;
    Authentication vauth = SecurityContextHolder.getContext().getAuthentication();
    if (!(vauth instanceof AnonymousAuthenticationToken))
    {
      authentication = vauth;
    }
    else
    {
      authentication = null;
    }
    return authentication;
  }
}
