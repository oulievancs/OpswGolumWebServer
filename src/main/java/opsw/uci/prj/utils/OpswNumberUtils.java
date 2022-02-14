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

  public static int OpswGetIntFromString(String inumber)
          throws CatException
  {
    int num = 0;
    try
    {
      if (inumber != null && inumber.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("#");
        num = df.parse(inumber).intValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return num;
  }

  public static byte OpswGetByteFromString(String inumber)
          throws CatException
  {
    byte num = 0;
    try
    {
      if (inumber != null && inumber.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("#");
        num = df.parse(inumber).byteValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return num;
  }

  public static short OpswGetShortFromString(String inumber)
          throws CatException
  {
    short num = 0;
    try
    {
      if (inumber != null && inumber.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("#");
        num = df.parse(inumber).shortValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return num;
  }

  public static float OpswGetFloatFromString(String inumber)
          throws CatException
  {
    float num = 0;
    try
    {
      if (inumber != null && inumber.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("#");
        num = df.parse(inumber).floatValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return num;
  }
}
