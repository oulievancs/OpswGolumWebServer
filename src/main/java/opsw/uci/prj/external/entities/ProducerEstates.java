/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.external.entities;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oulis
 */
@XmlRootElement(name = "ProducerEstates")
public class ProducerEstates
{

  @XmlElement(name = "Estate")
  List<Estate> estates;

  public ProducerEstates()
  {
    this.estates = null;
  }

  public List<Estate> getEstates()
  {
    return estates;
  }

  public void setEstates(List<Estate> estates)
  {
    this.estates = estates;
  }
}
