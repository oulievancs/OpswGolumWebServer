/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author n.oulis
 */
@Entity
@Table(name = "OPSWCONSTSV")
@IdClass(OpswconstsvKey.class)
public class Opswconstsv implements Serializable
{

  public static final String FIELD_TYPE = "FIELD_TYPE";
  public static final String ASSETS_VALUE = "ASSETS_VALUE";

  public static final String FIELD_ASSETS_VALUE_SYMB_NAME = "SYMB_NAME";
  public static final String FIELD_ASSETS_VALUE_SYMB_TEL = "SYMB_TEL";

  @Id
  private String code;
  @Id
  private String value;
  private String descr;

  public Opswconstsv()
  {
    this.code = null;
    this.value = null;
    this.descr = null;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
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
