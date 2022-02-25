/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

/**
 *
 * @author oulis
 */
public class OpswJsonTenant
{

  private int tenantNo;
  private String datasourceName;
  private String datasourcePath;
  private String descr;

  public OpswJsonTenant()
  {
    this.tenantNo = 0;
    this.datasourceName = null;
    this.datasourcePath = null;
    this.descr = null;
  }

  public int getTenantNo()
  {
    return tenantNo;
  }

  public void setTenantNo(int tenantNo)
  {
    this.tenantNo = tenantNo;
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

  public String getDescr()
  {
    return descr;
  }

  public void setDescr(String descr)
  {
    this.descr = descr;
  }

}
