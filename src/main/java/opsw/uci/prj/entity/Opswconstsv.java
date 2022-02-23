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
  public static final String ASSETS00_FLDS = "ASSETS00_FLDS";
  public static final String ASSETS00_INTERNALKEY = "ASSETS00_INTERNALKEY";

  public static final String FIELD_ASSETS_VALUE_SYMB_NAME = "SYMB_NAME";
  public static final String FIELD_ASSETS_VALUE_SYMB_TEL = "SYMB_TEL";
  public static final String FIELD_ASSETS_VALUE_INTRNLKEY = "INTRNLKEY";
  public static final String CRM_SERVER_URL = "CRM_SERVER_URL";

  @Id
  private String code;
  @Id
  private String field;
  private String value;

  public Opswconstsv()
  {
    this.code = null;
    this.field = null;
    this.value = null;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getField()
  {
    return field;
  }

  public void setField(String field)
  {
    this.field = field;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

}
