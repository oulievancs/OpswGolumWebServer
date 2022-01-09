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
public class OpswMenu01
{

  private String path;
  private boolean isActive;
  private String caption;

  public OpswMenu01()
  {
    this.path = null;
    this.isActive = false;
    this.caption = null;
  }

  public String getPath()
  {
    return path;
  }

  public void setPath(String path)
  {
    this.path = path;
  }

  public boolean isIsActive()
  {
    return isActive;
  }

  public void setIsActive(boolean isActive)
  {
    this.isActive = isActive;
  }

  public String getCaption()
  {
    return caption;
  }

  public void setCaption(String caption)
  {
    this.caption = caption;
  }
}
