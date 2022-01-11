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
        df.parse(wString);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vNumber;
  }
}
