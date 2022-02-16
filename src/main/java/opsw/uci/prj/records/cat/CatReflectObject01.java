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
  private boolean isGenericType;
  private boolean isClassOfPrimitive;
  private Class<?> genericType;
  private String xmlAnnotationName;
  private boolean xmlElementRequired;

  public CatReflectObject01()
  {
    this.fieldName = null;
    this.fieldType = null;
    this.fieldValue = null;
    this.isPrimitive = false;
    this.isGenericType = false;
    this.isClassOfPrimitive = false;
    this.genericType = null;
    this.xmlAnnotationName = null;
    this.xmlElementRequired = false;
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

  public boolean isIsGenericType()
  {
    return isGenericType;
  }

  public void setIsGenericType(boolean isGenericType)
  {
    this.isGenericType = isGenericType;
  }

  public boolean isIsClassOfPrimitive()
  {
    return isClassOfPrimitive;
  }

  public void setIsClassOfPrimitive(boolean isClassOfPrimitive)
  {
    this.isClassOfPrimitive = isClassOfPrimitive;
  }

  public Class<?> getGenericType()
  {
    return genericType;
  }

  public void setGenericType(Class<?> genericType)
  {
    this.genericType = genericType;
  }

  public String getXmlAnnotationName()
  {
    return xmlAnnotationName;
  }

  public void setXmlAnnotationName(String xmlAnnotationName)
  {
    this.xmlAnnotationName = xmlAnnotationName;
  }

  public boolean isXmlElementRequired()
  {
    return xmlElementRequired;
  }

  public void setXmlElementRequired(boolean xmlElementRequired)
  {
    this.xmlElementRequired = xmlElementRequired;
  }
}
