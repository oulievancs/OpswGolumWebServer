/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;

import opsw.uci.prj.entity.Assets00fl;

/**
 *
 * @author n.oulis
 */
public class Assets00flRec01 extends Assets00fl
{  
  private String fldDescr;

  public Assets00flRec01()
  {
    super();
    this.fldDescr = null;
  }

  public String getFldDescr()
  {
    return fldDescr;
  }

  public void setFldDescr(String fldDescr)
  {
    this.fldDescr = fldDescr;
  }
 
  
}
