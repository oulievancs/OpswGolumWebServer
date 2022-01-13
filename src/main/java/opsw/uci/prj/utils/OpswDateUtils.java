/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import opsw.uci.prj.cat.CatException;

/**
 *
 * @author oulis
 */
public class OpswDateUtils
{

  public static String DateTimeToStr01(Calendar calendar)
          throws CatException
  {
    SimpleDateFormat df = null;
    String result = "";

    try
    {
      if (calendar != null)
      {
        df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
        result = df.format(calendar.getTime());
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static String DateToStr01(Calendar calendar)
          throws CatException
  {
    SimpleDateFormat df = null;
    String result = "";

    try
    {
      if (calendar != null)
      {
        df = new SimpleDateFormat("DD-MM-YYYY");
        result = df.format(calendar.getTime());
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static Calendar StrToDate(String idateStr)
          throws CatException
  {
    Calendar vcal = null;
    try
    {
      if (idateStr != null)
      {

      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcal;
  }

  public static Calendar StrToDate(String idateStr, String iformat)
          throws CatException
  {
    Calendar vcal = null;
    try
    {
      SimpleDateFormat vf = null;
      if (iformat != null)
      {
        vf = new SimpleDateFormat(iformat);
      }

      if (vf == null)
      {
        throw new CatException("Δεν δόθηκε format για την ημ/νία!");
      }

      Date vdate = vf.parse(idateStr);

      vcal = Calendar.getInstance();
      vcal.setTime(vdate);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcal;
  }
}
