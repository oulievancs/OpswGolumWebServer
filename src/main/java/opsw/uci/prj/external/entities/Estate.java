/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.external.entities;

/**
 *
 * @author oulis
 */
public class Estate
{

  private String AgencyKey;
  private String AgencyEmail;
  private String AgencyPhone;
  private Long ID;
  private String Title_GR;
  private String Title_EN;

  public Estate()
  {
    this.AgencyKey = null;
    this.AgencyEmail = null;
    this.AgencyPhone = null;
    this.ID = null;
    this.Title_GR = null;
    this.Title_EN = null;
  }

  public String getAgencyKey()
  {
    return AgencyKey;
  }

  public void setAgencyKey(String AgencyKey)
  {
    this.AgencyKey = AgencyKey;
  }

  public String getAgencyEmail()
  {
    return AgencyEmail;
  }

  public void setAgencyEmail(String AgencyEmail)
  {
    this.AgencyEmail = AgencyEmail;
  }

  public String getAgencyPhone()
  {
    return AgencyPhone;
  }

  public void setAgencyPhone(String AgencyPhone)
  {
    this.AgencyPhone = AgencyPhone;
  }

  public Long getID()
  {
    return ID;
  }

  public void setID(Long ID)
  {
    this.ID = ID;
  }

  public String getTitle_GR()
  {
    return Title_GR;
  }

  public void setTitle_GR(String Title_GR)
  {
    this.Title_GR = Title_GR;
  } 

  public String getTitle_EN()
  {
    return Title_EN;
  }

  public void setTitle_EN(String Title_EN)
  {
    this.Title_EN = Title_EN;
  }
}
