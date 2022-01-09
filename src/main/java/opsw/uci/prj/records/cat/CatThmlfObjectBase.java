/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records.cat;

/**
 *
 * @author oulis
 */
public abstract class CatThmlfObjectBase
{

  private String descr;

  public CatThmlfObjectBase()
  {
    this.descr = null;
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
