/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.client;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author oulis
 */
public class XmlReaderWriter
{

  private String dateFormat;

  public XmlReaderWriter()
  {
    this.dateFormat = null;
  }

  public void ObjectProcessFill01(Element element, CatReflectObject01 obj, Document document)
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

            for (Object o : vlist)
            {
              List<CatReflectObject01> vRefL = OpswReflection.ReflectObjectToObject01List(o);
              Element velement = document.createElement(obj.getXmlAnnotationName());

              if (vRefL != null)
              {
                for (CatReflectObject01 c : vRefL)
                {
                  this.ObjectProcessFill01(velement, c, document);
                }
              }

              element.appendChild(velement);
            }
          }
        }
        else
        {
          List<CatReflectObject01> objR = OpswReflection.ReflectObjectToObject01List(obj.getFieldValue());

          if (objR != null)
          {
            for (CatReflectObject01 c : objR)
            {
              Element velement = document.createElement(c.getXmlAnnotationName());

              this.ObjectProcessFill01(velement, c, document);

              element.appendChild(velement);
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
        Element velem = document.createElement(obj.getXmlAnnotationName());
        velem.appendChild(document.createTextNode(String.valueOf(vval)));

        element.appendChild(velem);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public void EntityProcessFill01(Element element, CatReflectObject01 obj, Object object)
          throws CatException
  {
    try
    {
      if (!obj.isIsPrimitive() && !obj.isIsClassOfPrimitive())
      {
        List<CatReflectObject01> objR = null;
        Object internalObj = null;
        Node vnode = null;

        if (obj.getFieldType().getName().equals(List.class.getName())
                && obj.isIsGenericType())
        {
          this.CheckFieldAA(obj);
          NodeList vNList = element.getElementsByTagName(obj.getXmlAnnotationName());

          if (vNList != null)
          {
            internalObj = new ArrayList<>();

            for (int i = 0; i < vNList.getLength(); i++)
            {
              vnode = vNList.item(i);
              Object internalObj1 = obj.getGenericType().newInstance();

              objR = OpswReflection.ReflectObjectToObject01List(internalObj1);

              for (CatReflectObject01 c : objR)
              {
                Element vell = (Element) vnode;
                this.CheckFieldAA(c);
                this.EntityProcessFill01((Element) vell.getElementsByTagName(c.getXmlAnnotationName()).item(0), c, internalObj1);
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
              this.CheckFieldAA(c);
              NodeList vNList = element.getElementsByTagName(c.getXmlAnnotationName());

              if (vNList != null)
              {
                for (int i = 0; i < vNList.getLength(); i++)
                {
                  vnode = vNList.item(i);

                  if (vnode.getNodeType() == Node.ELEMENT_NODE)
                  {
                    if (vnode.getNodeName().equals(c.getXmlAnnotationName()))
                    {
                      Element vel = (Element) vnode;
                      this.EntityProcessFill01((Element) vel, c, internalObj);
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        String elVal = null;
        try
        {
          elVal = element.getTextContent();
        }
        catch (Exception ex)
        {
          //
        }

        Object vval = null;
        if (elVal != null)
        {
          vval = this.GetValueByTypeRead(obj, elVal);
        }

        OpswReflection.SetFieldValue(object, obj.getFieldName(), vval);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void CheckFieldAA(CatReflectObject01 obj) throws CatException
  {
    try
    {
      if (obj != null)
      {
        if (OpswStringUtils.OpswStringIsEmpty(obj.getXmlAnnotationName()))
        {
          throw new CatException("Δεν έχει δοθεί Xml Tag Element για το πεδίο "
                  + "[Filed = " + obj.getFieldName() + "]!");
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  /**
   * Check root header!
   *
   * @param obj
   * @throws CatException
   */
  public void CheckFieldBB(CatReflectObject01 obj) throws CatException
  {
    try
    {
      if (obj != null)
      {
        if (OpswStringUtils.OpswStringIsEmpty(obj.getXmlRootElementName()))
        {
          throw new CatException("Δεν έχει δοθεί Xml Root Tag Element για την κλάσση "
                  + "[Class = " + obj.getFieldName() + "]!");
        }
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
      res = GetValueByType(obj, elVal, true);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  public Object GetValueByTypeRead(CatReflectObject01 obj, Object elVal) throws CatException
  {
    Object res = null;
    try
    {
      res = GetValueByType(obj, elVal, false);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  private Object GetValueByType(CatReflectObject01 obj, Object elVal, boolean ixmlWrite) throws CatException
  {
    Object vval = null;
    try
    {
      if (this.TypesComp01(obj.getFieldType(), Boolean.class))
      {
        boolean vbool = false;
        if (elVal != null)
        {
          if ((elVal instanceof String
                  && ((((String) elVal).equalsIgnoreCase("1")) || (((String) elVal).equalsIgnoreCase("true")))))
          {
            vbool = true;
          }
          else if (ixmlWrite)
          {
            vbool = (boolean) elVal;
          }
        }
        vval = vbool;
      }
      else if (this.TypesComp01(obj.getFieldType(), Long.class))
      {
        long vlong = 0;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            vlong = OpswNumberUtils.OpswGetLongFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            vlong = (long) elVal;
          }
        }
        vval = vlong;
      }
      else if (this.TypesComp01(obj.getFieldType(), Integer.class))
      {
        int vint = 0;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            vint = OpswNumberUtils.OpswGetIntFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            vint = (int) elVal;
          }
        }
        vval = vint;
      }
      else if (this.TypesComp01(obj.getFieldType(), Short.class))
      {
        short vshort = 0;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            vshort = OpswNumberUtils.OpswGetShortFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            vshort = (short) elVal;
          }
        }
        vval = vshort;
      }
      else if (this.TypesComp01(obj.getFieldType(), Byte.class))
      {
        byte vbyte = 0;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            vbyte = OpswNumberUtils.OpswGetByteFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            vbyte = (byte) elVal;
          }
        }
        vval = vbyte;
      }
      else if (this.TypesComp01(obj.getFieldType(), Double.class))
      {
        double vdouble = 0;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            vdouble = OpswNumberUtils.OpswGetDoubleFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            vdouble = (double) elVal;
          }
        }
        vval = vdouble;
      }
      else if (this.TypesComp01(obj.getFieldType(), Float.class))
      {
        float vfloat = 0;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            vfloat = OpswNumberUtils.OpswGetFloatFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            vfloat = (float) elVal;
          }
        }
        vval = vfloat;
      }
      else if (this.TypesComp01(obj.getFieldType(), Calendar.class))
      {
        String valEl = null;
        if (elVal != null)
        {
          valEl = (String) elVal;
        }

        vval = null;
        if (!OpswStringUtils.OpswStringIsEmpty(valEl))
        {
          vval = OpswDateUtils.StrToDate(valEl, this.dateFormat);
        }
      }
      else if (this.TypesComp01(obj.getFieldType(), BigDecimal.class))
      {
        BigDecimal valEl = null;
        if (elVal != null)
        {
          if (elVal instanceof String)
          {
            valEl = OpswNumberUtils.OpswGetBigDecimalFromString((String) elVal);
          }
          else if (ixmlWrite)
          {
            valEl = (BigDecimal) elVal;
          }
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
