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
public class OpswJsonTenantSchemas
{

  private String filePath;
  private boolean fileRun;

  public OpswJsonTenantSchemas()
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
