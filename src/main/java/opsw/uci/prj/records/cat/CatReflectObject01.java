/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records.cat;

/**
 *
 * @author e.oulis
 */
public class CatReflectObject01
{

  private String fieldName;
  private Class<?> fieldType;
  private Object fieldValue;
  private boolean isPrimitive;

  public CatReflectObject01()
  {
    this.fieldName = null;
    this.fieldType = null;
    this.fieldValue = null;
    this.isPrimitive = false;
  }

  public String getFieldName()
  {
    return fieldName;
  }

  public void setFieldName(String fieldName)
  {
    this.fieldName = fieldName;
  }

  public Class<?> getFieldType()
  {
    return fieldType;
  }

  public void setFieldType(Class<?> fieldType)
  {
    this.fieldType = fieldType;
  }

  public Object getFieldValue()
  {
    return fieldValue;
  }

  public void setFieldValue(Object fieldValue)
  {
    this.fieldValue = fieldValue;
  }

  public boolean isIsPrimitive()
  {
    return isPrimitive;
  }

  public void setIsPrimitive(boolean isPrimitive)
  {
    this.isPrimitive = isPrimitive;
  }
}
