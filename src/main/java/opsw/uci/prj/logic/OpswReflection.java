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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.logging.OpswLogger;
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
      field = GetFieldIncludeSuperClass(obj.getClass(), fieldName);

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

      if (!Modifier.isPublic(method.getModifiers()))
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

      if (fieldType.getClass().getSimpleName().equalsIgnoreCase("boolean"))
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
        vvalue = (Object) (vmethod.invoke(obj, (Object[]) null));
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

  public static void SetFieldValueAppend(Object obj, String fieldName, Object value, String prefix)
          throws CatException
  {
    try
    {
      Field vfield = GetFieldByName(obj, fieldName);

      if (vfield != null)
      {
        Object vval = value;
        if (value instanceof String)
        {
          String vstr = null;
          Object vstrObj = CallGetterMethod(obj, fieldName, vfield.getType());

          if (vstrObj != null && vstrObj instanceof String)
          {
            vstr = (String) vstrObj;
          }

          if (vstr == null)
          {
            vstr = (String) value;
          }
          else
          {
            vstr += prefix + (String) value;
          }

          vval = vstr;
        }
        CallSetterMethod(obj, fieldName, vval, vfield.getType());
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
    return (Field[]) GetAllFieldsIncludeSuperClass01(iclass, false);
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
      resList = new ArrayList<>();

      ReflectObjectToObject01List_Internal(obj, resList);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return resList;
  }

  private static void ReflectObjectToObject01List_Internal(Object obj, List<CatReflectObject01> wList)
          throws CatException
  {
    try
    {
      Field[] vfields = GetAllFieldsIncludeSuperClass01(obj.getClass(), true);

      if (vfields != null)
      {
        CatReflectObject01 vcatObj01 = null;
        for (Field fld : vfields)
        {
          vcatObj01 = new CatReflectObject01();
          wList.add(vcatObj01);

          vcatObj01.setFieldName(fld.getName());
          vcatObj01.setFieldType(fld.getType());
          vcatObj01.setFieldValue(GetFieldValue(obj, fld.getName(), fld.getType()));
          boolean isPrimitiveType
                  = fld.getType().getClass().getSimpleName().equals(Boolean.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Long.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Short.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Byte.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Integer.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Double.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Float.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Character.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Calendar.class.getSimpleName())
                  || fld.getType().getClass().getSimpleName().equals(Date.class.getSimpleName());
          vcatObj01.setIsPrimitive(fld.getType().isPrimitive());
          vcatObj01.setIsClassOfPrimitive(isPrimitiveType);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public static void OpswReflectionCopyParentObject(Object objFrom, Object objTo, Class<?> iclass)
          throws CatException
  {
    try
    {
      if (objFrom == null || objTo == null)
      {
        throw new CatException(CatException.CODE_NULL_PRM, "Δεν δόθηκαν αντικείμενα!");
      }

      Field[] fields = GetObjectDeclaredFields(iclass);

      Class vsuperObj = objTo.getClass().getSuperclass();

      if (!vsuperObj.getName().equals(iclass.getName()))
      {
        throw new CatException("Το αντικείμενο From δεν κληρωνομείται στο To!");
      }

      ReflectionCopyFields(objFrom, objTo, fields);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static void ReflectionCopyFields(Object objFrom, Object objTo, Field[] ifields)
          throws CatException
  {
    try
    {
      if (ifields != null && ifields.length > 0)
      {
        Object vval1 = null;

        for (Field fld : ifields)
        {
          String vfieldName = fld.getName();
          Class<?> vfieldType = fld.getType();
          boolean vgoon = FieldExistsInClass(objFrom.getClass(), vfieldName, vfieldType);

          vgoon &= FieldExistsInClass(objTo.getClass(), vfieldName, vfieldType);

          if (vgoon)
          {
            vval1 = GetFieldValue(objFrom, vfieldName, vfieldType);

            CallSetterMethod(objTo, vfieldName, vval1, vfieldType);
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private static boolean FieldExistsInClass(Class<?> iclass, String ifieldName, Class<?> ifieldType)
          throws CatException
  {
    boolean vfldExists = false;
    try
    {
      for (Class<?> superClass = iclass; superClass != null
              && superClass != Object.class; superClass = superClass
                      .getSuperclass())
      {
        Field[] fields = GetObjectDeclaredFields(superClass);

        if (fields != null && fields.length > 0)
        {
          for (Field fld : fields)
          {
            if (fld.getName() != null && fld.getName().equals(ifieldName)
                    && fld.getType().getClass().getName().equals(ifieldType.getClass().getName()))
            {
              vfldExists = true;
              break;
            }
          }
        }

        if (vfldExists)
        {
          break;
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vfldExists;
  }

  public static void OpswReflectionCopyObjectFields(Object objFrom, Object objTo, Class<?> iclassSrc)
          throws CatException
  {
    try
    {
      Field[] fields = GetObjectDeclaredFields(iclassSrc);

      ReflectionCopyFields(objFrom, objTo, fields);
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

          if (isSuper && Modifier.isPrivate(m.getModifiers()))
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

  private static Field GetFieldIncludeSuperClass(Class<?> clazz, String ifieldName)
          throws CatException
  {
    Field ls = null;

    try
    {
      Field[] vfields = GetAllFieldsIncludeSuperClass01(clazz, false);

      if (vfields != null)
      {
        boolean isSuper = false;
        for (Class<?> superClass = clazz; superClass != null
                && superClass != Object.class; superClass = superClass
                        .getSuperclass())
        {
          for (Field ff : vfields)
          {
            if (isSuper && Modifier.isPrivate(ff.getModifiers()))
            {
              throw new CatException("Το πεδίο [field = " + ff.getName() + "] είναι private!");
            }

            if (ff.getName().equals(ifieldName))
            {
              ls = ff;
            }
          }

          isSuper = true;
        }
      }

    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);

    }

    return ls;
  }

  private static Field[] GetAllFieldsIncludeSuperClass01(Class<?> clazz, boolean makeInception)
          throws CatException
  {
    Field[] vfields = null;
    try
    {
      List<Field> vlistFields = new ArrayList<>();

      boolean isSubclass = true;
      for (Class<?> superClass = clazz; superClass != null
              && superClass != Object.class && (makeInception || isSubclass); superClass = superClass
                      .getSuperclass())
      {
        Field[] fields = superClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++)
        {
          Field f = fields[i];

          if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers())
                  || Modifier.isTransient(f.getModifiers()))
          {
            //
          }
          else
          {
            vlistFields.add(f);
          }
        }

        isSubclass = false;
      }

      vfields = new Field[vlistFields.size()];
      vfields = (Field[]) vlistFields.toArray(vfields);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vfields;
  }
}
