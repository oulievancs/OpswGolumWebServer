/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.util.ArrayList;
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
          List<OpswConnectionSchemas> vlist = null;
          for (OpswJsonTenant c : vconList)
          {
            vlist = null;

            result[ii] = new OpswConnection();
            result[ii].setDatasourceName(c.getDatasourceName());
            result[ii].setDatasourcePath(c.getDatasourcePath());
            result[ii].setRunViews(c.isRunViews());
            result[ii].setRunAlters(c.isRunAlters());

            if (c.getSchemas() != null)
            {
              vlist = new ArrayList<>();
            }

            result[ii].setSchemas(vlist);

            if (vlist != null)
            {
              OpswConnectionSchemas vsch = null;
              for (OpswJsonTenantSchemas s : c.getSchemas())
              {
                vsch = new OpswConnectionSchemas();

                vlist.add(vsch);
                vsch.setFilePath(s.getFilePath());
                vsch.setFileRun(s.isFileRun());
              }
            }
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
    private List<OpswConnectionSchemas> schemas;
    private boolean runViews;
    private boolean runAlters;

    public OpswConnection(String datasourceName, String datasourcePath)
    {
      this.datasourceName = datasourceName;
      this.datasourcePath = datasourcePath;
      this.schemas = null;
      this.runViews = false;
      this.runAlters = false;
    }

    public OpswConnection()
    {
      this.datasourceName = null;
      this.datasourcePath = null;
      this.schemas = null;
      this.runViews = false;
      this.runAlters = false;
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

    public List<OpswConnectionSchemas> getSchemas()
    {
      return schemas;
    }

    public void setSchemas(List<OpswConnectionSchemas> schemas)
    {
      this.schemas = schemas;
    }

    public boolean isRunViews()
    {
      return runViews;
    }

    public void setRunViews(boolean runViews)
    {
      this.runViews = runViews;
    }

    public boolean isRunAlters()
    {
      return runAlters;
    }

    public void setRunAlters(boolean runAlters)
    {
      this.runAlters = runAlters;
    }
  }

  public static class OpswConnectionSchemas
  {

    private String filePath;
    private boolean fileRun;

    public OpswConnectionSchemas()
    {
      this.filePath = null;
      this.fileRun = false;
    }

    public String getFilePath()
    {
      return filePath;
    }

    public void setFilePath(String filePath)
    {
      this.filePath = filePath;
    }

    public boolean isFileRun()
    {
      return fileRun;
    }

    public void setFileRun(boolean fileRun)
    {
      this.fileRun = fileRun;
    }
  }
}
