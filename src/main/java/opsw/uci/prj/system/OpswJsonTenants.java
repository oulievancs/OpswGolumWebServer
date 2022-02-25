/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.util.List;

/**
 *
 * @author oulis
 */
public class OpswJsonTenants
{

  private List<OpswJsonTenant> tenants;

  public OpswJsonTenants()
  {
    this.tenants = null;
  }

  public List<OpswJsonTenant> getTenants()
  {
    return tenants;
  }

  public void setTenants(List<OpswJsonTenant> tenants)
  {
    this.tenants = tenants;
  }
}
