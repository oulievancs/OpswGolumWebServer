/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author n.oulis
 */
@Entity
public class Gram01 implements Serializable
{

  @Id
  private Long gram;
  @Id
  private Long senu;
  private Integer field_type;
  private String field_name;
  private String value_str;
  private Double value_num;

  public Gram01()
  {
    super();
    this.gram = null;
    this.senu = null;
    this.field_type = null;
    this.field_name = null;
    this.value_str = null;
    this.value_num = null;
  }

  public Long getGram()
  {
    return gram;
  }

  public void setGram(Long gram)
  {
    this.gram = gram;
  }

  public Long getSenu()
  {
    return senu;
  }

  public void setSenu(Long senu)
  {
    this.senu = senu;
  }

  public Integer getField_type()
  {
    return field_type;
  }

  public void setField_type(Integer field_type)
  {
    this.field_type = field_type;
  }

  public String getField_name()
  {
    return field_name;
  }

  public void setField_name(String field_name)
  {
    this.field_name = field_name;
  }

  public String getValue_str()
  {
    return value_str;
  }

  public void setValue_str(String value_str)
  {
    this.value_str = value_str;
  }

  public Double getValue_num()
  {
    return value_num;
  }

  public void setValue_num(Double value_num)
  {
    this.value_num = value_num;
  }

}
