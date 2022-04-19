/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import opsw.uci.prj.cat.CatException;

/**
 *
 * @author oulis
 */
public class OpswUrlUtils
{

  private static final char PREFIX_KEY = '@';

  public static String UrlEncoding(String iurl) throws CatException
  {
    String result = null;
    try
    {
      if (iurl != null)
      {
        result = "";
        char[] vchars = iurl.toCharArray();

        for (char c : vchars)
        {
          if (c == '?')
          {
            result = result + PREFIX_KEY + 'p';
          }
          else if (c == '&')
          {
            result = result + PREFIX_KEY + 'a';
          }
          else if (c == '=')
          {
            result = result + PREFIX_KEY + 'e';
          }
          else
          {
            result += c;
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static String UrlDecoding(String iurl) throws CatException
  {
    String result = null;
    try
    {
      if (iurl != null)
      {
        result = "";
        char[] vchars = iurl.toCharArray();

        boolean vfnd = false;
        for (char c : vchars)
        {
          if (c == PREFIX_KEY)
          {
            vfnd = true;
          }

          if (vfnd)
          {
            if (c == 'p')
            {
              result = result + '?';
              vfnd = false;
            }
            else if (c == 'a')
            {
              result = result + '&';
              vfnd = false;
            }
            else if (c == 'e')
            {
              result = result + '=';
              vfnd = false;
            }
          }
          else
          {
            result += c;
          }
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
