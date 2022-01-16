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
public class OpswMenu01
{

  
  private String path;
  private boolean isActive;
  private String caption;
  private boolean haveSub;
  private List<OpswMenu01> subs;
  private String id;

  public OpswMenu01()
  {
    this.path = null;
    this.isActive = false;
    this.caption = null;
    this.haveSub = false;
    this.subs = null;
    this.id = null;
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

  public boolean isHaveSub()
  {
    return haveSub;
  }

  public void setHaveSub(boolean haveSub)
  {
    this.haveSub = haveSub;
  }

  public List<OpswMenu01> getSubs()
  {
    return subs;
  }

  public void setSubs(List<OpswMenu01> subs)
  {
    this.subs = subs;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
  
}
