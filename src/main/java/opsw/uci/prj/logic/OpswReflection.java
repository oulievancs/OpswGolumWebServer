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
      //field = obj.getClass().getDeclaredField(fieldName);
      field = GetAllFieldsIncludeSuperClass(obj.getClass(), fieldName);

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

  private static Method GetSetterFieldByName(Object obj, String fieldName, Class<?> fieldType)
          throws CatException
  {
    Method method = null;
    try
    {
      String vsetterMethodName = "set" + fieldName.substring(0, 1).toUpperCase()
              + fieldName.substring(1);

      //method = obj.getClass().getDeclaredMethod(vsetterMethodName, fieldType);
      method = GetAllSetterGetterIncludeSuperClass(obj.getClass(), vsetterMethodName, fieldType);

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

  private static Method GetGetterFieldByName(Object obj, String fieldName, Class<?> fieldType)
          throws CatException
  {
    Method method = null;
    try
    {
      String vprefix = "get";

      if (fieldType.getClass().getName().equalsIgnoreCase("boolean"))
      {
        vprefix = "is";
      }

      String vgetterMethodName = vprefix + fieldName.substring(0, 1).toUpperCase()
              + fieldName.substring(1);

      //method = obj.getClass().getDeclaredMethod(vgetterMethodName);
      method = GetAllSetterGetterIncludeSuperClass(obj.getClass(), vgetterMethodName, null);

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

  public static Object GetFieldValue(Object obj, String fieldName, Class<?> fieldType)
          throws CatException
  {
    Object vvalue = null;
    try
    {
      vvalue = CallGetterMethod(obj, fieldName, fieldType);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vvalue;
  }

  private static Object CallGetterMethod(Object obj, String fieldName, Class<?> fieldType)
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

      if (vfield != null)
      {
        CallSetterMethod(obj, fieldName, value, vfield.getType());
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static void CallSetterMethod(Object obj, String fieldName, Object value, Class<?> paramType)
          throws CatException
  {
    try
    {
      Method vmethod = null;
      if (paramType != null)
      {
        vmethod = GetSetterFieldByName(obj, fieldName, paramType);
      }

      if (vmethod != null)
      {
        //Invoke με type cast.
        vmethod.invoke(obj, paramType.cast(value));
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static Field[] GetObjectDeclaredFields(Class<?> iclass)
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

  public static void OpswReflectionCopyParentObject(Object objFrom, Object objeTo, Class<?> iclass)
          throws CatException
  {
    try
    {
      if (objFrom == null || objeTo == null)
      {
        throw new CatException(CatException.CODE_NULL_PRM, "Δεν δόθηκαν αντικείμενα!");
      }

      Field[] fields = GetObjectDeclaredFields(iclass);

      Class vsuperObj = objeTo.getClass().getSuperclass();

      if (!vsuperObj.getName().equals(iclass.getName()))
      {
        throw new CatException("Το αντικείμενο From δεν κληρωνομείται στο To!");
      }

      if (fields != null && fields.length > 0)
      {
        Object vval1 = null;

        for (Field fld : fields)
        {
          vval1 = GetFieldValue(objFrom, fld.getName(), fld.getType());

          CallSetterMethod(objeTo, fld.getName(), vval1, fld.getType());
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static Method GetAllSetterGetterIncludeSuperClass(Class<?> clazz, String imethodName, Class<?> paramType)
          throws CatException
  {
    Method ls = null;

    try
    {
      boolean isSuper = false;

      for (Class<?> superClass = clazz; superClass != null
              && superClass != Object.class; superClass = superClass
                      .getSuperclass())
      {
        Method[] methods = superClass.getDeclaredMethods();

        for (int i = 0; i < methods.length; i++)
        {
          Method m = methods[i];

          if (isSuper && m.getModifiers() == Modifier.PRIVATE)
          {
            throw new CatException("Η μέθοδος [Method = " + imethodName + "] είναι private!");
          }

          if (m.getName().equals(imethodName))
          {
            Class<?>[] paramTypes = m.getParameterTypes();
            if ((paramType == null)
                    || (paramTypes.length == 1 && paramTypes[0].equals(paramType)))
            {
              ls = m;
            }
          }
        }

        isSuper = true;
      }

    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);

    }

    return ls;
  }

  private static Field GetAllFieldsIncludeSuperClass(Class<?> clazz, String ifieldName)
          throws CatException
  {
    Field ls = null;

    try
    {
      boolean isSuper = false;

      for (Class<?> superClass = clazz; superClass != null
              && superClass != Object.class; superClass = superClass
                      .getSuperclass())
      {
        Field[] fields = superClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++)
        {
          Field f = fields[i];

          if (isSuper && f.getModifiers() == Modifier.PRIVATE)
          {
            throw new CatException("Το πεδίο [field = " + ifieldName + "] είναι private!");
          }

          if (f.getName().equals(ifieldName))
          {
            ls = f;
          }
        }

        isSuper = true;
      }

    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);

    }

    return ls;
  }
}
