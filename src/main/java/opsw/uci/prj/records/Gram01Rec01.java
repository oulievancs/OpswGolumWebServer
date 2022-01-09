/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;


/**
 *
 * @author n.oulis
 */
public class Gram01Rec01
{
  private Long gram;
  private Long senu;
  private String field_type;
  private String field_name;
  private String value_str;
  private Double value_num;
  private Integer excel_index;

  public Gram01Rec01()
  {
    super();
    this.gram = null;
    this.senu = null;
    this.field_type = null;
    this.field_name = null;
    this.value_str = null;
    this.value_num = null;
    this.excel_index = null;
  }

  public Gram01Rec01(Long gram, Long senu, String field_type, String field_name, String value_str, Double value_num, Integer excel_index)
  {
    this.gram = gram;
    this.senu = senu;
    this.field_type = field_type;
    this.field_name = field_name;
    this.value_str = value_str;
    this.value_num = value_num;
    this.excel_index = excel_index;
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

  public String getField_type()
  {
    return field_type;
  }

  public void setField_type(String field_type)
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
  
}
