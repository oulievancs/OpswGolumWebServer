/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author oulis
 */
public class OpswDateUtils
{

  public static String DateTimeToStr01(Calendar calendar)
  {
    SimpleDateFormat df = null;
    String result = "";

    if (calendar != null)
    {
      df = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
      result = df.format(calendar.getTime());
    }
    return result;
  }

  public static String DateToStr01(Calendar calendar)
  {
    SimpleDateFormat df = null;
    String result = "";

    if (calendar != null)
    {
      df = new SimpleDateFormat("dd-mm-yyyy");
      result = df.format(calendar.getTime());
    }
    return result;
  }
}
