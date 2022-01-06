/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.logging;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;

/**
 *
 * @author oulis
 */
public class OpswLogger
{

  private static final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  private static final Logger logger = Logger.getLogger(OpswLogger.class);

  public static Logger getLogger()
  {
    return logger;
  }

  public static void LoggerLogException(Throwable ex)
  {
    getLogger().error(ex.getClass().getName() + ": " + ex.getMessage(), ex);
  }

  public static void LoggerLogException(String message, Throwable th)
  {
    getLogger().error(getStringTimeNow() + ": " + th.getClass().getName(), th);
  }

  private static String getStringTimeNow()
  {
    return (String) getStringTime(Calendar.getInstance());
  }

  private static String getStringTime(Calendar calendar)
  {
    String result = "N/A";
    try
    {
      result = df.format(calendar.getTime());
    } catch (Exception ex)
    {
      getLogger().error(ex.getMessage(), ex);
    }

    return result;
  }
}
