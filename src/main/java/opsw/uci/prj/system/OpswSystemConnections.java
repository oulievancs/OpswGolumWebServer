/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

/**
 *
 * @author e.oulis
 */
public class OpswSystemConnections
{

  public final static String DEFAULT_ORCLH_MINLO = "ORCLH_MINLO";

  public static final String DEFAULT_ORCLH_MINLO_PROPERTY = "opsw.datasource.minlo";

  public static final OpswConnection[] OPSW_CONNECTIONS =
  {
    new OpswConnection(DEFAULT_ORCLH_MINLO, DEFAULT_ORCLH_MINLO_PROPERTY),
    new OpswConnection("ORCLH_MINLO1", "opsw.datasource.01"),
    new OpswConnection("ORCLH_MINLO2", "opsw.datasource.02"),
  };

  public static class OpswConnection
  {

    private String datasourceName;
    //Paths στον server χωρίς το java:/comp/env, που έχει οριστεί
    //στο applications properties.
    private String datasourcePath;

    public OpswConnection(String datasourceName, String datasourcePath)
    {
      this.datasourceName = datasourceName;
      this.datasourcePath = datasourcePath;
    }

    public OpswConnection()
    {
      this.datasourceName = null;
      this.datasourcePath = null;
    }

    public String getDatasourceName()
    {
      return datasourceName;
    }

    public void setDatasourceName(String datasourceName)
    {
      this.datasourceName = datasourceName;
    }

    public String getDatasourcePath()
    {
      return datasourcePath;
    }

    public void setDatasourcePath(String datasourcePath)
    {
      this.datasourcePath = datasourcePath;
    }
  }
}
