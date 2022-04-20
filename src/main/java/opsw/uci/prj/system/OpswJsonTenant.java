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
public class OpswJsonTenant
{

  private int tenantNo;
  private String datasourceName;
  private String datasourcePath;
  private String descr;
  private List<OpswJsonTenantSchemas> schemas;
  private boolean runViews;
  private boolean runAlters;

  public OpswJsonTenant()
  {
    this.tenantNo = 0;
    this.datasourceName = null;
    this.datasourcePath = null;
    this.descr = null;
    this.schemas = null;
    this.runViews = false;
    this.runAlters = false;
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

  public List<OpswJsonTenantSchemas> getSchemas()
  {
    return schemas;
  }

  public void setSchemas(List<OpswJsonTenantSchemas> schemas)
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
