/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import java.text.DateFormat;
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

  public final static String OPSW_DATE_DEFAULT_FORMAT = "dd-MM-yyyy";
  public final static String OPSW_DATE_TIME_DEFAULT_FORMAT = "dd-MM-yyyy HH:mm:ss";
  public final static String OPSW_DATE_FORMAT_AMER = "MM-dd-yyyy";
  public final static String OPSW_DATE_TIME_FORMAT_AMER = "MM-dd-yyyy HH:mm:ss";

  public static String DateTimeToStr01(Calendar icalendar)
          throws CatException
  {
    String result = "";

    try
    {
      if (icalendar != null)
      {
        result = DateToStr(icalendar, OPSW_DATE_TIME_DEFAULT_FORMAT);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static String DateToStr01(Calendar icalendar)
          throws CatException
  {
    String result = "";

    try
    {
      if (icalendar != null)
      {
        result = DateToStr(icalendar, OPSW_DATE_DEFAULT_FORMAT);
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
        vcal = StrToDate(idateStr, OPSW_DATE_DEFAULT_FORMAT);
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
      DateFormat vf = null;
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

  public static String DateToStr(Calendar icalendar, String vdateFormat)
          throws CatException
  {
    String vdateStr = null;
    try
    {
      DateFormat df = null;
      if (vdateFormat != null)
      {
        df = new SimpleDateFormat(vdateFormat);
      }

      if (df == null)
      {
        throw new CatException("Δεν δόθηκε format για την ημ/νία!");
      }

      vdateStr = df.format(icalendar.getTime());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vdateStr;
  }
}
