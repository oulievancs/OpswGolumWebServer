/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.orj.arifacts;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 *
 * @author e.oulis
 */
public class OpswCurrentDatasourceConnection implements CurrentTenantIdentifierResolver
{

  public final static String ORCLH_DEFAULT = "ORCLH_MINLO";

  @Override
  public String resolveCurrentTenantIdentifier()
  {
    String currentDs = OpswEjbContext.getCurrentTenant();
    if (currentDs == null)
    {
      currentDs = ORCLH_DEFAULT;
    }
    return currentDs;
  }

  @Override
  public boolean validateExistingCurrentSessions()
  {
    return true;
  }

}
