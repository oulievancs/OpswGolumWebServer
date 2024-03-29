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
public class OpswStringUtils
{

  public static short OpswStringToShort(String wString)
          throws CatException
  {
    return (short) OpswStringToNumber(wString).shortValue();
  }

  private static Number OpswStringToNumber(String wString)
          throws CatException
  {
    Number vNumber = 0;
    try
    {
      if (wString != null && wString.trim().length() > 0)
      {
        DecimalFormat df = new DecimalFormat("0");
        vNumber = df.parse(wString);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vNumber;
  }

  public static String OpswDoubleToString(double wDouble)
          throws CatException
  {
    String res = null;
    try
    {
      DecimalFormat df = new DecimalFormat("#.00");
      res = df.format(wDouble);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public static String OpswShortToString(short wShort)
          throws CatException
  {
    return String.valueOf(wShort);
  }

  public static String[] OpswStringSePedia(String istring)
          throws CatException
  {
    String[] res = null;
    try
    {
      if (istring != null)
      {
        res = istring.split(String.valueOf((char) 9));
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public static String OpswStringTrim(String istring)
          throws CatException
  {
    String res = null;
    try
    {
      if (istring != null)
      {
        res = istring.trim();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return res;
  }

  public static boolean OpswStringIsEmpty(String istring)
          throws CatException
  {
    boolean res = true;
    try
    {
      String vstr1 = OpswStringTrim(istring);

      if (vstr1 != null && !vstr1.isEmpty())
      {
        res = false;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public static String OpswLongToString(long wLong) throws CatException
  {
    String res = null;
    try
    {
      DecimalFormat df = new DecimalFormat("#");
      res = df.format(wLong);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public static String OpswMakeNotPathStart(String wString) throws CatException
  {
    String vstring = null;
    try
    {
      vstring = wString;

      if (wString != null)
      {
        if (wString.startsWith("/"))
        {
          vstring = wString.substring(1);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vstring;
  }
}
