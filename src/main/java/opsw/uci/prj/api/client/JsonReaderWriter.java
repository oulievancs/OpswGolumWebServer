/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.cat.CatReflectObject01;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

/**
 *
 * @author oulis
 */
public class JsonReaderWriter
{

  private String dateFormat;

  public JsonReaderWriter()
  {
    super();
    this.dateFormat = null;
  }

  public void ObjectProcessFill01(JSONObject jsonObj, CatReflectObject01 obj)
          throws CatException
  {
    try
    {
      if (!obj.isIsPrimitive() && !obj.isIsClassOfPrimitive())
      {
        if (obj.getFieldType().getName().equals(List.class.getName())
                && obj.isIsGenericType())
        {
          List<Object> vlist = (List<Object>) obj.getFieldValue();

          if (vlist != null)
          {

            JSONArray jarr = new JSONArray();
            for (Object o : vlist)
            {
              List<CatReflectObject01> vRefL = OpswReflection.ReflectObjectToObject01List(o);
              JSONObject job = new JSONObject();

              if (vRefL != null)
              {
                for (CatReflectObject01 c : vRefL)
                {
                  this.ObjectProcessFill01(job, c);
                }
              }

              jarr.put(job);
            }

            jsonObj.put(obj.getFieldName(), jarr);
          }
        }
        else
        {
          List<CatReflectObject01> objR = OpswReflection.ReflectObjectToObject01List(obj.getFieldValue());

          if (objR != null)
          {
            for (CatReflectObject01 c : objR)
            {
              JSONObject job = new JSONObject();

              this.ObjectProcessFill01(job, c);

              jsonObj.put(c.getFieldName(), job);
            }
          }
        }
      }
      else
      {
        Object elVal = obj.getFieldValue();

        Object vval = null;

        if (elVal != null)
        {
          vval = this.GetValueByTypeWrite(obj, elVal);
        }

        // Create Last Name Element
        jsonObj.put(obj.getFieldName(), vval);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  /**
   * https://attacomsian.com/blog/processing-json-spring-bootsv
   */
  public Object EntityProcess01(String ifile, Class<?> dataBodyType) throws CatException
  {
    Object res = null;
    try
    {
      //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      //read json file and convert to customer object
      JsonNode job = objectMapper.readTree(new File(ifile));

      res = EntityProcess(job, dataBodyType);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public Object EntityProcess(JsonNode job, Class<?> dataBodyType) throws CatException
  {
    Object obj = null;
    try
    {
      obj = EntityProcess_Internal(job, dataBodyType);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return obj;
  }

  private Object EntityProcess_Internal(JsonNode job, Class<?> dataBodyType) throws CatException
  {
    Object obj = null;
    try
    {

      obj = dataBodyType.newInstance();

      // Now let's say you have not one, but 'n' nodes that contain the value
      // you're looking for. Use NodeList to get a list of all those nodes and just 
      // pull out the tag/attribute's value you want.
      CatReflectObject01 lcatObj = OpswReflection.ReflectObject(obj);

      if (lcatObj != null)
      {

        List<CatReflectObject01> vcatL = OpswReflection.ReflectObjectToObject01List(lcatObj.getFieldValue());
        if (vcatL != null)
        {
          for (CatReflectObject01 v : vcatL)
          {
            this.EntityProcessFill01(job, v, obj);
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return obj;
  }

  public void EntityProcessFill01(JsonNode jsonObj, CatReflectObject01 obj, Object object)
          throws CatException
  {
    try
    {
      if (!obj.isIsPrimitive() && !obj.isIsClassOfPrimitive())
      {
        List<CatReflectObject01> objR = null;
        Object internalObj = null;

        if (obj.getFieldType().getName().equals(List.class.getName())
                && obj.isIsGenericType())
        {
          JsonNode vNList = jsonObj.get(obj.getFieldName());

          if (vNList != null && vNList.isArray())
          {
            internalObj = new ArrayList<>();

            for (JsonNode job : vNList)
            {
              Object internalObj1 = obj.getGenericType().newInstance();

              objR = OpswReflection.ReflectObjectToObject01List(internalObj1);

              for (CatReflectObject01 c : objR)
              {
                this.EntityProcessFill01(job.get(c.getFieldName()), c, internalObj1);
              }

              ((List<Object>) internalObj).add(internalObj1);

              OpswReflection.SetFieldValue(object, obj.getFieldName(), internalObj);
            }
          }
        }
        else
        {
          internalObj = object;
          objR = OpswReflection.ReflectObjectToObject01List(internalObj);

          if (objR != null)
          {
            for (CatReflectObject01 c : objR)
            {
              JsonNode vNode = jsonObj.get(c.getFieldName());

              if (vNode != null)
              {
                this.EntityProcessFill01(vNode, c, internalObj);
              }
            }
          }
        }
      }
      else
      {

        Object vval = null;
        if (jsonObj != null)
        {
          vval = this.GetValueByTypeRead(obj, jsonObj);
        }

        OpswReflection.SetFieldValue(object, obj.getFieldName(), vval);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public Object GetValueByTypeWrite(CatReflectObject01 obj, Object elVal) throws CatException
  {
    Object res = null;
    try
    {
      res = SetValueByType(obj, elVal);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public Object GetValueByTypeRead(CatReflectObject01 obj, JsonNode elVal) throws CatException
  {
    Object res = null;
    try
    {
      res = GetValueByType(obj, elVal);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  private Object GetValueByType(CatReflectObject01 obj, JsonNode elVal) throws CatException
  {
    Object vval = null;
    try
    {
      if (this.TypesComp01(obj.getFieldType(), Boolean.class
      ))
      {
        boolean vbool = false;
        if (elVal
                != null)
        {
          vbool = elVal.asBoolean();
        }
        vval = vbool;
      }
      else if (this.TypesComp01(obj.getFieldType(), Long.class
      ))
      {
        long vlong = 0;
        if (elVal
                != null)
        {
          vlong = elVal.asLong();
        }
        vval = vlong;
      }
      else if (this.TypesComp01(obj.getFieldType(), Integer.class
      ))
      {
        int vint = 0;
        if (elVal
                != null)
        {
          vint = elVal.asInt();
        }
        vval = vint;
      }
      else if (this.TypesComp01(obj.getFieldType(), Short.class
      ))
      {
        short vshort = 0;
        if (elVal
                != null)
        {
          vshort = (short) elVal.asInt();
        }
        vval = vshort;
      }
      else if (this.TypesComp01(obj.getFieldType(), Byte.class
      ))
      {
        byte vbyte = 0;
        if (elVal
                != null)
        {
          vbyte = (byte) elVal.asInt();
        }
        vval = vbyte;
      }
      else if (this.TypesComp01(obj.getFieldType(), Double.class
      ))
      {
        double vdouble = 0;
        if (elVal
                != null)
        {
          vdouble = elVal.asDouble();
        }
        vval = vdouble;
      }
      else if (this.TypesComp01(obj.getFieldType(), Float.class
      ))
      {
        float vfloat = 0;
        if (elVal
                != null)
        {
          vfloat = (float) elVal.asDouble();
        }
        vval = vfloat;
      }
      else if (this.TypesComp01(obj.getFieldType(), Calendar.class
      ))
      {
        Calendar vcal = null;
        if (elVal
                != null)
        {
          vcal = OpswDateUtils.StrToDate((String) elVal.asText(), this.dateFormat);
        }
        vval = vcal;
      }
      else if (this.TypesComp01(obj.getFieldType(), BigDecimal.class
      ))
      {
        BigDecimal valEl = null;
        if (elVal
                != null)
        {
          valEl = BigDecimal.valueOf(elVal.asDouble());
        }

        vval = valEl;
      }
      else
      {
        vval = elVal.asText();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vval;
  }

  private Object SetValueByType(CatReflectObject01 obj, Object elVal) throws CatException
  {
    Object vval = null;
    try
    {
      if (this.TypesComp01(obj.getFieldType(), Boolean.class))
      {
        boolean vbool = false;
        if (elVal != null)
        {
          vbool = (boolean) elVal;
        }
        vval = vbool;
      }
      else if (this.TypesComp01(obj.getFieldType(), Long.class))
      {
        long vlong = 0;
        if (elVal != null)
        {
          vlong = (long) elVal;
        }
        vval = vlong;
      }
      else if (this.TypesComp01(obj.getFieldType(), Integer.class))
      {
        int vint = 0;
        if (elVal != null)
        {
          vint = (int) elVal;
        }
        vval = vint;
      }
      else if (this.TypesComp01(obj.getFieldType(), Short.class))
      {
        short vshort = 0;
        if (elVal != null)
        {
          vshort = (short) elVal;
        }
        vval = vshort;
      }
      else if (this.TypesComp01(obj.getFieldType(), Byte.class))
      {
        byte vbyte = 0;
        if (elVal != null)
        {
          vbyte = (byte) elVal;
        }
        vval = vbyte;
      }
      else if (this.TypesComp01(obj.getFieldType(), Double.class))
      {
        double vdouble = 0;
        if (elVal != null)
        {
          vdouble = (double) elVal;
        }
        vval = vdouble;
      }
      else if (this.TypesComp01(obj.getFieldType(), Float.class))
      {
        float vfloat = 0;
        if (elVal != null)
        {
          vfloat = (float) elVal;
        }
        vval = vfloat;
      }
      else if (this.TypesComp01(obj.getFieldType(), Calendar.class))
      {
        Object valEl = null;
        if (elVal != null)
        {
          valEl = OpswDateUtils.DateToStrXml((Calendar) elVal);
        }
        vval = valEl;
      }
      else if (this.TypesComp01(obj.getFieldType(), BigDecimal.class))
      {
        BigDecimal valEl = null;
        if (elVal != null)
        {
          valEl = (BigDecimal) elVal;
        }

        vval = valEl;
      }
      else
      {
        vval = elVal;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vval;
  }

  private boolean TypesComp01(Class<?> c1, Class<?> c2) throws CatException
  {
    boolean result = false;
    try
    {
      String c11 = c1.getSimpleName();
      String c22 = c2.getSimpleName();

      if (c22.toLowerCase().startsWith(c11.toLowerCase()))
      {
        result = true;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  public String getDateFormat()
  {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat)
  {
    this.dateFormat = dateFormat;
  }
}
