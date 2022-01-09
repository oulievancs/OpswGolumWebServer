/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.lang.management.ManagementFactory;
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

  public static String JBOSS_DS_URL = "jdbc.url02";
  public static String TOMCAT_DS_URL = "jdbc.url";

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

  public static DataSource OpswDataSourceServer(byte iwebServer, Environment env)
          throws CatException
  {
    DataSource ds = null;
    try
    {
      if (iwebServer == VOID_WEB_SERVER)
      {
        throw new CatException("Unknown web server!");
      }
      String dsUrl = TOMCAT_DS_URL;

      if (iwebServer == JBOSS_WEB_SERVER)
      {
        dsUrl = JBOSS_DS_URL;
      }
      ds = (DataSource) new JndiTemplate().lookup(env.getProperty(dsUrl));
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return ds;
  }
}
