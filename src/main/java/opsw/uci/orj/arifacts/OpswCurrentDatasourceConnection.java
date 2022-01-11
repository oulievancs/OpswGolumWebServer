/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.orj.arifacts;

import opsw.uci.prj.system.OpswSystemWebServer01;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 *
 * @author e.oulis
 */
public class OpswCurrentDatasourceConnection implements CurrentTenantIdentifierResolver
{

  @Override
  public String resolveCurrentTenantIdentifier()
  {
    String currentDs = OpswEjbContext.getCurrentTenant();
    if (currentDs == null)
    {
      currentDs = OpswSystemWebServer01.DEFAULT_ORCLH_MINLO;
    }
    return currentDs;
  }

  @Override
  public boolean validateExistingCurrentSessions()
  {
    return true;
  }

}
