/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.util.List;
import opsw.uci.prj.cat.CatException;

/**
 *
 * @author e.oulis
 */
public class OpswSystemConnections
{

  private final static int SYSTEM_CONNECTION_READ_FILE = 1;

  public final static String DEFAULT_ORCLH_MINLO = "ORCLH_MINLO";

  public static final String DEFAULT_ORCLH_MINLO_PROPERTY = "opsw.datasource.minlo";

  private static final OpswConnection[] OPSW_CONNECTIONS =
  {
    new OpswConnection(DEFAULT_ORCLH_MINLO, DEFAULT_ORCLH_MINLO_PROPERTY),
    //new OpswConnection("ORCLH_MINLO1", "opsw.datasource.01"),
    //new OpswConnection("ORCLH_MINLO2", "opsw.datasource.02"),
    new OpswConnection("ORCLH_MINLO1", "ORCLH_MINLO1"),
    new OpswConnection("ORCLH_MINLO2", "ORCLH_MINLO2"),
  };

  /**
   * Γεμιζει ακομα τα connetiοn απο json αρχειο.
   *
   * @return
   * @throws CatException
   */
  public static OpswConnection[] OpswConnectionsGet01() throws CatException
  {
    OpswConnection[] result = null;
    try
    {
      if (SYSTEM_CONNECTION_READ_FILE == 1)
      {
        OpswJsonTenants vtenants = OpswTenants.OpswJsonTenantsReadAndGet();

        List<OpswJsonTenant> vconList = null;
        if (vtenants != null)
        {
          vconList = vtenants.getTenants();
        }

        if (vconList != null)
        {
          result = new OpswConnection[vconList.size()];

          int ii = 0;
          for (OpswJsonTenant c : vconList)
          {
            result[ii] = new OpswConnection();
            result[ii].setDatasourceName(c.getDatasourceName());
            result[ii].setDatasourcePath(c.getDatasourcePath());

            ii++;
          }
        }
      }
      else
      {
        result = OPSW_CONNECTIONS;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

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
