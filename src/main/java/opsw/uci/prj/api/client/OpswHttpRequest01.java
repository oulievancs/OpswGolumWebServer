/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.client;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.cat.CatReflectObject01;
import opsw.uci.prj.utils.OpswNumberUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author oulis
 */
public class OpswHttpRequest01 extends OpswHttpRequestBase
{

  public OpswHttpRequest01()
  {
    super();
  }

  @Override
  protected Object OpswHttpSendRequest(Object object) throws CatException
  {
    Object result = null;
    try
    {

    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return null;
  }

  private Object OpswHttpSendGet(Object object) throws CatException
  {
    Object result = null;
    try
    {
      HttpUriRequest httpGet = new HttpGet(this.getUrl());

      httpGet.setHeader("User-Agent", "uci/application-server/x1.0");

      HttpResponse httpResponse = this.CreateHttpClient().execute(httpGet);

      int responseCode = httpResponse.getStatusLine().getStatusCode();

      if (responseCode == HttpStatus.OK.value())
      {
        HttpEntity httpEntity = httpResponse.getEntity();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  private HttpClient CreateHttpClient() throws CatException
  {
    HttpClient httpClient = null;
    try
    {
      httpClient = HttpClientBuilder.create().build();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return httpClient;
  }

  private Object HttpEntityProcess(HttpEntity httpEntity) throws CatException
  {
    Object obj = null;
    try
    {

      obj = this.getResponseBody().newInstance();

      // Parse the response using DocumentBuilder so you can get at elements easily
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(httpEntity.getContent());
      Element root = doc.getDocumentElement();
      // Now let's say you have not one, but 'n' nodes that contain the value
      // you're looking for. Use NodeList to get a list of all those nodes and just 
      // pull out the tag/attribute's value you want.

      List<CatReflectObject01> fields = OpswReflection.ReflectObjectToObject01List(obj);

      if (fields != null)
      {
        for (CatReflectObject01 c : fields)
        {
          EntityProcessFill01(root, c, obj);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return obj;
  }

  private void EntityProcessFill01(Element element, CatReflectObject01 obj, Object object)
          throws CatException
  {
    try
    {
      if (!obj.isIsPrimitive() && !obj.isIsClassOfPrimitive())
      {
        NodeList vNList = element.getElementsByTagName(obj.getFieldName());

        if (vNList != null)
        {
          for (int i = 0; i < vNList.getLength(); i++)
          {
            Node vnode = vNList.item(i);

            if (vnode.getNodeType() == Node.ELEMENT_NODE)
            {
              List<CatReflectObject01> objR = OpswReflection.ReflectObjectToObject01List(obj.getFieldValue());

              if (objR != null)
              {
                Object internalObj = obj.getFieldType().newInstance();

                for (CatReflectObject01 c : objR)
                {
                  EntityProcessFill01((Element) vnode, c, internalObj);
                }
              }
            }
          }
        }
      }
      else
      {
        String elVal = element.getNodeValue();

        Object vval = null;
        if (obj.getFieldType().getName().equals(Boolean.class.getName()))
        {
          boolean vbool = false;
          if (elVal != null && elVal.equals("1"))
          {
            vbool = true;
          }
          vval = vbool;
        }
        else if (obj.getFieldType().getName().equals(Long.class.getName()))
        {
          long vlong = 0;
          if (elVal != null)
          {
            vlong = OpswNumberUtils.OpswGetLongFromString(elVal);
          }
          vval = vlong;
        }
        else if (obj.getFieldType().getName().equals(Integer.class.getName()))
        {
          int vint = 0;
          if (elVal != null)
          {
            vint = OpswNumberUtils.OpswGetIntFromString(elVal);
          }
          vval = vint;
        }
        else if (obj.getFieldType().getName().equals(Short.class.getName()))
        {
          short vshort = 0;
          if (elVal != null)
          {
            vshort = OpswNumberUtils.OpswGetShortFromString(elVal);
          }
          vval = vshort;
        }
        else if (obj.getFieldType().getName().equals(Byte.class.getName()))
        {
          byte vbyte = 0;
          if (elVal != null)
          {
            vbyte = OpswNumberUtils.OpswGetByteFromString(elVal);
          }
          vval = vbyte;
        }
        else if (obj.getFieldType().getName().equals(Double.class.getName()))
        {
          double vdouble = 0;
          if (elVal != null)
          {
            vdouble = OpswNumberUtils.OpswGetDoubleFromString(elVal);
          }
          vval = vdouble;
        }
        else if (obj.getFieldType().getName().equals(Float.class.getName()))
        {
          float vfloat = 0;
          if (elVal != null)
          {
            vfloat = OpswNumberUtils.OpswGetFloatFromString(elVal);
          }
          vval = vfloat;
        }
        else
        {
          vval = elVal;
        }

        OpswReflection.SetFieldValue(object, obj.getFieldName(), vval);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

}
