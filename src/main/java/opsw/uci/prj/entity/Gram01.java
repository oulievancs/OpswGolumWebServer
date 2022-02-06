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
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author n.oulis
 */
@Entity
@Table(name = "GRAM01")
@IdClass(Gram01Key.class)
public class Gram01 implements Serializable
{

  public static final Short FIELD_TYPE_NUMBER = 0;
  public static final Short FIELD_TYPE_STRING = 1;
  public static final Short FIELD_TYPE_CALENDAR = 2;
  public static final Short FIELD_TYPE_LONG = 3;
  
  @Id
  private Long gram;
  @Id
  private Long senu;
  private Short field_type;
  private String field_name;
  private String value_str;
  private Double value_num;
  private Integer excel_index;
  private String date_format;
  private Byte concatOrder;

  public Gram01()
  {
    super();
    this.gram = null;
    this.senu = null;
    this.field_type = null;
    this.field_name = null;
    this.value_str = null;
    this.value_num = null;
    this.excel_index = null;
    this.date_format = null;
    this.concatOrder = null;
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

  public Short getField_type()
  {
    return field_type;
  }

  public void setField_type(Short field_type)
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

  public Integer getExcel_index()
  {
    return excel_index;
  }

  public void setExcel_index(Integer excel_index)
  {
    this.excel_index = excel_index;
  }

  public String getDate_format()
  {
    return date_format;
  }

  public void setDate_format(String date_format)
  {
    this.date_format = date_format;
  }

  public Byte getConcatOrder()
  {
    return concatOrder;
  }

  public void setConcatOrder(Byte concatOrder)
  {
    this.concatOrder = concatOrder;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.gram);
    hash = 59 * hash + Objects.hashCode(this.senu);
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    final Gram01 other = (Gram01) obj;
    if (!Objects.equals(this.gram, other.gram))
    {
      return false;
    }
    if (!Objects.equals(this.senu, other.senu))
    {
      return false;
    }
    return true;
  }

}
