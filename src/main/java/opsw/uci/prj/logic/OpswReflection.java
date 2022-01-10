/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.logic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.records.cat.CatReflectObject01;

/**
 *
 * @author oulis
 */
public class OpswReflection
{

  private static Field GetFieldByName(Object obj, String fieldName)
          throws CatException
  {
    Field field = null;
    try
    {
      field = obj.getClass().getDeclaredField(fieldName);

      if (field == null)
      {
        throw new CatException("Δεν βρέθηκε το πεδίο [Field = " + fieldName + "]!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return field;
  }

  private static Method GetSetterFieldByName(Object obj, String fieldName, Class fieldType)
          throws CatException
  {
    Method method = null;
    try
    {
      String vsetterMethodName = "set" + fieldName.substring(0, 1).toUpperCase()
              + fieldName.substring(1);

      method = obj.getClass().getDeclaredMethod(vsetterMethodName, fieldType);

      if (method == null)
      {
        throw new CatException("Δεν βρέθηκε setter διαδικασία για το πεδίο [Field = " + fieldName + "]!");
      }

      if (method.getModifiers() != Modifier.PUBLIC)
      {
        throw new CatException("Το πεδίο [Field = " + fieldName + "] δεν έχει public setter method!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return method;
  }

  private static Method GetGetterFieldByName(Object obj, String fieldName, Class fieldType)
          throws CatException
  {
    Method method = null;
    try
    {
      String vgetterMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
              + fieldName.substring(1);

      method = obj.getClass().getDeclaredMethod(vgetterMethodName, fieldType);

      if (method == null)
      {
        throw new CatException("Δεν βρέθηκε getter διαδικασία για το πεδίο [Field = " + fieldName + "]!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return method;
  }

  public static Object GetFieldValue(Object obj, String fieldName, Class fieldType)
          throws CatException
  {
    Object vvalue = null;
    try
    {
      Method vmethod = GetGetterFieldByName(obj, fieldName, fieldType);

      if (vmethod != null)
      {
        vvalue = (Object) (vmethod.invoke(obj, null));
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vvalue;
  }

  public static void SetFieldValue(Object obj, String fieldName, Object value)
          throws CatException
  {
    try
    {
      Field vfield = GetFieldByName(obj, fieldName);
      Method vmethod = null;

      if (vfield != null)
      {
        vmethod = GetSetterFieldByName(obj, fieldName, vfield.getType());
      }

      if (vmethod != null)
      {
        //Invoke με type cast.
        vmethod.invoke(obj, vfield.getType().cast(value));
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static Field[] GetObjectDeclaredFields(Class iclass)
          throws CatException
  {
    return (Field[]) iclass.getDeclaredFields();
  }

  public static List<CatReflectObject01> ReflectObjectToObject01List(Object obj)
          throws CatException
  {
    List<CatReflectObject01> resList = null;
    try
    {
      if (obj == null)
      {
        throw new CatException("Δώθηκε null Object!");
      }

      Field[] vfields = GetObjectDeclaredFields(obj.getClass());

      resList = new ArrayList<>();
      if (vfields != null)
      {
        CatReflectObject01 vcatObj01 = null;
        for (Field fld : vfields)
        {
          vcatObj01 = new CatReflectObject01();
          resList.add(vcatObj01);

          vcatObj01.setFieldName(fld.getName());
          vcatObj01.setFieldType(fld.getType());
          vcatObj01.setFieldValue(GetFieldValue(obj, fld.getName(), fld.getType()));
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return resList;
  }
}
