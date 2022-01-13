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
public class OpswNumberUtils
{

  public static long OpswGetLong(Long ilong)
          throws CatException
  {
    long res = 0;
    try
    {
      if (ilong != null)
      {
        res = (long) ilong;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }
}
