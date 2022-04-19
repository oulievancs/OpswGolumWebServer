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
import java.util.Locale;
import javax.xml.bind.DatatypeConverter;
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
  public final static String OPSW_DATE_THYMLEAF_01 = "dd/MM/yyyy";
  public final static String OPSW_DATE_THYMLEAF_02 = "yyyy-MM-dd";
  //public final static String OPSW_DATE_XMLFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  public final static String OPSW_DATE_XMLFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

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

  public static String DateToStr02(Date idate)
          throws CatException
  {
    String result = "";

    try
    {
      result = DateToStr01(DateToCalendar_Internal(idate, false));
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
        vcal = StrToDate(idateStr, OPSW_DATE_DEFAULT_FORMAT, true);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcal;
  }

  public static Calendar StrToDate(String idateStr, String iformat, boolean checkDate)
          throws CatException
  {
    Calendar vcal = null;
    try
    {
      if (idateStr == null && checkDate)
      {
        throw new CatException("Δεν δόθηκε ημ/νία!");
      }
      DateFormat vf = null;
      if (iformat != null)
      {
        vf = new SimpleDateFormat(iformat);
      }

      if (vf == null)
      {
        throw new CatException("Δεν δόθηκε format για την ημ/νία!");
      }

      if (idateStr != null && !idateStr.equals(""))
      {
        Date vdate = vf.parse(idateStr);

        vcal = Calendar.getInstance();
        vcal.setTime(vdate);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcal;
  }

  public static Calendar StrToDateXml(String iXmldateStr)
          throws CatException
  {
    Calendar vcal = null;
    try
    {
      if (iXmldateStr == null)
      {
        throw new CatException("Δεν δόθηκε ημ/νία!");
      }

      vcal = DatatypeConverter.parseDateTime(iXmldateStr);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vcal;
  }

  public static String DateToStrXml(Calendar icalendar)
          throws CatException
  {
    String vstr = null;
    try
    {
      if (icalendar == null)
      {
        throw new CatException("Δεν δόθηκε ημ/νία!");
      }

      vstr = DatatypeConverter.printDateTime(icalendar);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vstr;
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

  private static Calendar DateToCalendar_Internal(Date idate, boolean thowException)
          throws CatException
  {
    Calendar vcal = null;
    try
    {
      vcal = Calendar.getInstance();

      if (thowException)
      {
        throw new CatException("Δεν έχει δοθεί ημ/νία!");
      }
      else if (idate != null)
      {
        vcal.setTime(idate);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcal;
  }

  public static Date CalendarToDateElseNow(Calendar idate) throws CatException
  {
    Date result = null;
    try
    {
      if (idate == null)
      {
        idate = Calendar.getInstance();
      }
      result = new Date();
      result = idate.getTime();
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  public static Date StrToDate02(String idate) throws CatException
  {
    Date result = null;
    try
    {
      result = StrToDate02_Internal(idate, false);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static Date StrToDate03(String idate) throws CatException
  {
    Date result = null;
    try
    {
      result = StrToDate02_Internal(idate, true);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  private static Date StrToDate02_Internal(String idate, boolean doExec) throws CatException
  {
    Date result = null;
    try
    {
      if (idate == null && doExec)
      {
        throw new CatException("Date not provided!");
      }

      Calendar vcal = StrToDate(idate);

      result = CalendarToDateElseNow(vcal);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public static Calendar DateToCalendarElseNow(Date idate)
          throws CatException
  {
    Calendar vcal = null;
    try
    {
      vcal = DateToCalendar_Internal(idate, false);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcal;
  }

  public static String CalendarLocale_FormatDateTime(Calendar calendar) throws CatException
  {
    return CalendarLocale_Internal(calendar, DateFormat.SHORT, DateFormat.SHORT, (byte) 2, null);
  }

  public static String CalendarLocale_FormatDate(Calendar calendar)
          throws CatException
  {
    return CalendarLocale_Internal(calendar, DateFormat.SHORT, 0, (byte) 1, null);
  }

  public static String CalendarLocale_FormatTime(Calendar calendar)
          throws CatException
  {
    return CalendarLocale_Internal(calendar, 0, DateFormat.SHORT, (byte) 3, null);
  }

  private static String CalendarLocale_FormatDateTime(Calendar calendar, int dateFormat,
          int timeFormat) throws CatException
  {
    return CalendarLocale_Internal(calendar, dateFormat, timeFormat, (byte) 2, null);
  }

  private static String CalendarLocale_FormatDate(Calendar calendar, int dateFormat)
          throws CatException
  {
    return CalendarLocale_Internal(calendar, dateFormat, 0, (byte) 1, null);
  }

  private static String CalendarLocale_FormatTime(Calendar calendar, int timeFormat)
          throws CatException
  {
    return CalendarLocale_Internal(calendar, 0, timeFormat, (byte) 3, null);
  }

  private static String CalendarLocale_Internal(Calendar calendar, int dateFormat,
          int timeFormat, byte imode, Locale locale)
          throws CatException
  {
    String vval = null;
    try
    {
      DateFormat df = null;
      if (calendar != null)
      {
        if (imode == 1)
        {
          if (locale != null)
          {
            df = DateFormat.getDateInstance(dateFormat, locale);
          }
          else
          {
            df = DateFormat.getDateInstance(dateFormat);
          }
        }
        else if (imode == 2)
        {
          if (locale != null)
          {
            df = DateFormat.getDateTimeInstance(dateFormat, timeFormat, locale);
          }
          else
          {
            df = DateFormat.getDateTimeInstance(dateFormat, timeFormat);
          }
        }
        else if (imode == 3)
        {
          if (locale != null)
          {
            df = DateFormat.getTimeInstance(timeFormat, locale);
          }
          else
          {
            df = DateFormat.getTimeInstance(timeFormat);
          }
        }

        if (df != null)
        {
          vval = df.format(calendar.getTime());
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vval;
  }

  public static Calendar CalendarClone(Calendar ical) throws CatException
  {
    Calendar vcal = null;
    try
    {
      if (ical == null)
      {
        throw new CatException(CatException.CODE_NULL_PRM, "Δεν δόθηκε ημ/νία!");
      }

      vcal = Calendar.getInstance();
      vcal.setTimeInMillis(ical.getTimeInMillis());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vcal;
  }
}
