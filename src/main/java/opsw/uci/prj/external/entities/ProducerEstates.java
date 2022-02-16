/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.external.entities;

import java.util.List;

/**
 *
 * @author oulis
 */
public class ProducerEstates
{

  List<Estate> Estate;

  public ProducerEstates()
  {
    this.Estate = null;
  }

  public List<Estate> getEstate()
  {
    return Estate;
  }

  public void setEstate(List<Estate> Estate)
  {
    this.Estate = Estate;
  }
}
