/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import java.text.DecimalFormat;
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

  public static double OpswGetDoubleFromString(String inumber)
          throws CatException
  {
    double num = 0;
    try
    {
      if (inumber != null && inumber.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("#.##");
        num = df.parse(inumber).doubleValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return num;
  }

  public static long OpswGetLongFromString(String inumber)
          throws CatException
  {
    long num = 0;
    try
    {
      if (inumber != null && inumber.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("#");
        num = df.parse(inumber).longValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return num;
  }
}
