/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.lang.management.ManagementFactory;
import java.util.Map;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.sql.DataSource;
import opsw.uci.prj.cat.CatException;
import org.apache.catalina.core.StandardServer;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;

/**
 *
 * @author oulis
 */
public class OpswSystemWebServer01
{

  public static final byte JBOSS_WEB_SERVER = 1;
  public static final byte TOMCAT_WEB_SERVER = 2;
  public static final byte VOID_WEB_SERVER = 0;

  /**
   * Web Server configuration.
   */
  public static String JBOSS_DS_PREFIX = "java:jboss/comp/env/";
  public static String TOMCAT_DS_PREFIX = "java:/comp/env/";
  /***********************************************************/

  public static String DEFAULT_ORCLH_MINLO_PROPERTY = "opsw.datasource.minlo";

  public final static String DEFAULT_ORCLH_MINLO = "ORCLH_MINLO";

  public static byte DetermineWebServer()
          throws CatException
  {
    byte vresult = VOID_WEB_SERVER;
    //Το βάζω εδώ προς το παρόν.
    vresult = JBOSS_WEB_SERVER;
    //
    MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
    //for Tomcat
    try
    {
      ObjectName name = new ObjectName("Catalina", "type", "Server");
      StandardServer server = (StandardServer) mBeanServer.getAttribute(name, "managedResource");
      if (server != null)
      {
        //its a TOMCAT application server
        vresult = TOMCAT_WEB_SERVER;
      }
    }
    catch (Exception e)
    {
      //its not a TOMCAT Application server
    }

//for wildfly
    try
    {
      ObjectName http = new ObjectName("jboss.as:socket-binding-group=standard-sockets,socket- binding=http");
      String jbossHttpAddress = (String) mBeanServer.getAttribute(http, "boundAddress");
      int jbossHttpPort = (Integer) mBeanServer.getAttribute(http, "boundPort");
      String url = jbossHttpAddress + ":" + jbossHttpPort;
      if (jbossHttpAddress != null)
      {
        //its a JBOSS/WILDFLY Application server
      }
    }
    catch (Exception e)
    {
      //its not a JBOSS/WILDFLY Application server
    }
    return vresult;
  }

  public static DataSource OpswDataSourceServer(String orclh_minlo, byte iwebServer, Environment env)
          throws CatException
  {
    return OpswDataSourceServer_Internal(orclh_minlo, iwebServer, env, true);
  }

  private static DataSource OpswDataSourceServer_Internal(String orclh_minlo, byte iwebServer, Environment env,
          boolean ithrowExceptionNotFound)
          throws CatException
  {
    DataSource ds = null;
    try
    {
      if (iwebServer == VOID_WEB_SERVER)
      {
        throw new CatException("Unknown web server!");
      }

      String dsUrl = env.getProperty(orclh_minlo);

      if (dsUrl != null)
      {
        dsUrl = TOMCAT_DS_PREFIX + dsUrl;

        if (iwebServer == JBOSS_WEB_SERVER)
        {
          dsUrl = JBOSS_DS_PREFIX + dsUrl;
        }

        ds = (DataSource) new JndiTemplate().lookup(dsUrl);
      }

      if (dsUrl == null && ithrowExceptionNotFound)
      {
        throw new CatException("Property not found [Name = " + orclh_minlo + "]!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return ds;
  }

  public static void OpswDataSourcesFill01(Map<String, DataSource> wDs, byte iwebServer, Environment env)
          throws CatException
  {
    try
    {
      String dsNamePath = DEFAULT_ORCLH_MINLO_PROPERTY;
      String dsName = DEFAULT_ORCLH_MINLO;
      OpswDataSourceFill01_Internal(wDs, dsName, OpswDataSourceServer_Internal(dsNamePath, iwebServer, env, false));
      /**
       * **************************************************************************************************
       *////
      dsNamePath = "opsw.datasource.01";
      dsName = "ORCLH_MINLO1";
      OpswDataSourceFill01_Internal(wDs, dsName, OpswDataSourceServer_Internal(dsNamePath, iwebServer, env, false));
      dsNamePath = "opsw.datasource.02";
      dsName = "ORCLH_MINLO2";
      OpswDataSourceFill01_Internal(wDs, dsName, OpswDataSourceServer_Internal(dsNamePath, iwebServer, env, false));
      /**
       * **************************************************************************************************
       *////
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static void OpswDataSourceFill01_Internal(Map<String, DataSource> wDs, String iDsName, DataSource iDs)
          throws CatException
  {
    try
    {
      if (iDs != null)
      {
        wDs.put(iDsName, iDs);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
