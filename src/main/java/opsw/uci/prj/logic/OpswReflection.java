/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.logic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import opsw.uci.prj.cat.CatException;

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
    } catch (Exception ex)
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
    } catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return method;
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
        vmethod.invoke(obj, value.getClass().cast(vfield.getClass()));
      }
    } catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
