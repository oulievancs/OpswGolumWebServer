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
import opsw.uci.prj.globals.OpswErpRecords01;
import opsw.uci.prj.logging.OpswLogger;
import org.apache.catalina.core.StandardServer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jndi.JndiTemplate;

/**
 *
 * @author oulis
 */
public class OpswSystemWebServer01
{

  public static final String OPSW_SERVLET_CONTEXT_PATH = "/OPSWGOLUMWEBSERV";

  public static final byte JBOSS_WEB_SERVER = 1;
  public static final byte TOMCAT_WEB_SERVER = 2;
  public static final byte VOID_WEB_SERVER = 0;

  /**
   * Web Server configuration.
   */
  public static final String JBOSS_DS_PREFIX = "java:jboss/comp/env/";
  public static final String TOMCAT_DS_PREFIX = "java:/comp/env/";
  /**
   * ********************************************************
   */

  private static final boolean OPSW_INITIZE_DATASOURCE_ALTERS_AND_VIEWS = true;

  public static final String DEFAULT_ORCLH_MINLO = OpswSystemConnections.DEFAULT_ORCLH_MINLO;

  public final static String OPSW_DS_SCRIPTS_START = "<opsw_start>";
  public final static String OPSW_DS_SCRIPTS_END = "<opsw_end>";

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
    return OpswDataSourceServer_Internal(orclh_minlo, iwebServer, env, true, true);
  }

  private static DataSource OpswDataSourceServer_Internal(String orclh_minlo, byte iwebServer, Environment env,
          boolean ithrowExceptionNotFound, boolean isEnvProperty)
          throws CatException
  {
    DataSource ds = null;
    try
    {
      if (iwebServer == VOID_WEB_SERVER)
      {
        throw new CatException("Unknown web server!");
      }

      String dsUrl1 = null;
      if (isEnvProperty)
      {
        dsUrl1 = env.getProperty(orclh_minlo);
      }
      else
      {
        dsUrl1 = orclh_minlo;
      }

      if (dsUrl1 != null)
      {
        String dsUrl = TOMCAT_DS_PREFIX + dsUrl1;

        if (iwebServer == JBOSS_WEB_SERVER)
        {
          dsUrl = JBOSS_DS_PREFIX + dsUrl1;
        }

        ds = (DataSource) new JndiTemplate().lookup(dsUrl);
      }

      if (dsUrl1 == null && ithrowExceptionNotFound)
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
      String dsNamePath = null, dsName = null;
      /**
       * String dsNamePath = DEFAULT_ORCLH_MINLO_PROPERTY; String dsName =
       * OpswErpRecords01.OPSW_CONNECTIONS[0];
       * OpswDataSourceFill01_Internal(wDs, dsName,
       * OpswDataSourceServer_Internal(dsNamePath, iwebServer, env, false)); *
       */
      /**
       * **************************************************************************************************
       *////

      OpswSystemConnections.OpswConnection[] cons = OpswSystemConnections.OpswConnectionsGet01();
      if (cons != null)
      {
        for (OpswSystemConnections.OpswConnection conn : cons)
        {
          dsNamePath = conn.getDatasourcePath();
          dsName = conn.getDatasourceName();
          OpswDataSourceFill01_Internal(wDs, dsName, OpswDataSourceServer_Internal(dsNamePath, iwebServer, null, false, false));
        }
      }

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
        DataSource vDs = iDs;
        if (OPSW_INITIZE_DATASOURCE_ALTERS_AND_VIEWS)
        {
          vDs = OpswInitializeDatasource(vDs, iDsName);
        }
        wDs.put(iDsName, vDs);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static DataSource OpswInitializeDatasource(DataSource dataSource, String dataSourceName)
          throws CatException
  {
    try
    {
      OpswLogger.LoggerLogDebug("Running alters on " + dataSourceName + " -1");
      //ClassPathResource schemaResource = new ClassPathResource("schema.sql");
      //ClassPathResource dataResource = new ClassPathResource("data.sql");
      ClassPathResource altersSource = new ClassPathResource("/schema/alters.sql");
      ResourceDatabasePopulator vpop = new ResourceDatabasePopulator();
      vpop.addScript(altersSource);
      vpop.setIgnoreFailedDrops(true);
      vpop.setContinueOnError(true);
      vpop.setSqlScriptEncoding("UTF-8");
      vpop.execute(dataSource);
      OpswLogger.LoggerLogDebug("Running alters on " + dataSourceName + " -2");
    }
    catch (Exception ex)
    {
      OpswLogger.LoggerLogException(ex);
    }

    try
    {
      OpswLogger.LoggerLogDebug("Running views on " + dataSourceName + " -1");
      ClassPathResource viewsSource = new ClassPathResource("/schema/views.sql");
      ResourceDatabasePopulator vpop = new ResourceDatabasePopulator();
      vpop.addScript(viewsSource);
      vpop.setIgnoreFailedDrops(true);
      vpop.setContinueOnError(true);
      vpop.setSqlScriptEncoding("UTF-8");
      vpop.execute(dataSource);
      OpswLogger.LoggerLogDebug("Running views on " + dataSourceName + " -2");
    }
    catch (Exception ex)
    {
      OpswLogger.LoggerLogException(ex);
    }
    return dataSource;
  }
}
