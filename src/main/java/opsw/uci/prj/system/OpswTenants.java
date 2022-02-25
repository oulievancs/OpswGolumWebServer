/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.util.ArrayList;
import java.util.List;
import opsw.uci.prj.api.client.JsonReaderWriter;
import opsw.uci.prj.cat.CatException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author oulis
 */
public class OpswTenants
{

  private final static String SYSTEM_CONNECTION_FILE
          //= "/home/oulis/Documents/UCI_PROJECT/tenants.json";
          = "tenants.json";

  private static OpswJsonTenants OPSW_GLOBAL_TENANTS_INTERNAL;

  public static synchronized OpswJsonTenants OPSW_GLOBAL_TENANTS()
  {
    return OPSW_GLOBAL_TENANTS_INTERNAL;
  }

  private static synchronized void OPSW_GLOBAL_TENANTS(OpswJsonTenants tenants)
  {
    OPSW_GLOBAL_TENANTS_INTERNAL = tenants;
  }

  public static void OpswJsonTenantsRead() throws CatException
  {
    OpswJsonTenantsRead(SYSTEM_CONNECTION_FILE);
  }

  public static OpswJsonTenants OpswJsonTenantsReadAndGet() throws CatException
  {
    return OpswJsonTenantsRead(SYSTEM_CONNECTION_FILE);
  }

  public static OpswJsonTenants OpswJsonTenantsRead(String ifile) throws CatException
  {
    OpswJsonTenants tens = null;
    try
    {
      if (OPSW_GLOBAL_TENANTS() == null)
      {
        JsonReaderWriter jar = new JsonReaderWriter();
        jar.setDateFormat(null);

        Resource resource = new ClassPathResource(SYSTEM_CONNECTION_FILE);
        tens = (OpswJsonTenants) jar.EntityProcess01(resource.getFile(), OpswJsonTenants.class);

        List<OpswSystemConnections.OpswConnection> vconList = new ArrayList<>();
        if (tens != null)
        {
          if (tens.getTenants() != null)
          {
            OpswSystemConnections.OpswConnection vcon = null;
            for (OpswJsonTenant t : tens.getTenants())
            {
              vcon = new OpswSystemConnections.OpswConnection();
              vconList.add(vcon);

              vcon.setDatasourceName(t.getDatasourceName());
              vcon.setDatasourcePath(t.getDatasourcePath());
            }
          }
        }

        OPSW_GLOBAL_TENANTS(tens);
      }
      else
      {
        tens = OPSW_GLOBAL_TENANTS();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return tens;
  }
}
