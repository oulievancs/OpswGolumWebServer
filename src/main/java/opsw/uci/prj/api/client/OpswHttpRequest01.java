/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.client;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.cat.CatReflectObject01;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpRequest;
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
      if (this.getMethod() == OpswHttpMethod.OPSW_HTTP_MENTHOD_GET)
      {
        result = this.OpswHttpSendGet(object);
      }
      else if (this.getMethod() == OpswHttpMethod.OPSW_HTTP_MENTHOD_POST)
      {
        result = this.OpswHttpSendPost(object);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  private void KoinaRequest(HttpUriRequest request) throws CatException
  {
    try
    {
      request.setHeader("User-Agent", "uci/application-server/x1.0");

      if (this.getMethod() == OpswHttpMethod.OPSW_HTTP_MENTHOD_POST)
      {
        request.addHeader("Content-Type", "application/xml");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private Object OpswHttpSendPost(Object object) throws CatException
  {
    Object result = null;
    try
    {
      HttpUriRequest httpPost = new HttpPost(this.getUrl());
      this.KoinaRequest(httpPost);

      // Parse the response using DocumentBuilder so you can get at elements easily
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

      Document doc = this.ObjectProcess(object);

      // Transform Document to XML String
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      StringWriter writer = new StringWriter();
      transformer.transform(new DOMSource(doc), new StreamResult(writer));

      // Get the String value of final xml document
      String vXMLStringValue = writer.getBuffer().toString();

      HttpEntity httpEntity = new StringEntity(vXMLStringValue);
      ((HttpPost) httpPost).setEntity(httpEntity);

      HttpResponse httpResponse = this.CreateHttpClient().execute(httpPost);

      int responseCode = httpResponse.getStatusLine().getStatusCode();

      if (responseCode == HttpStatus.OK.value())
      {
        if (this.getResponseBody() == null)
        {
          HttpEntity httpEntity1 = httpResponse.getEntity();

          // Parse the response using DocumentBuilder so you can get at elements easily
          DocumentBuilderFactory docBuilderFactory1 = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder1 = docBuilderFactory1.newDocumentBuilder();
          Document doc1 = docBuilder1.parse(httpEntity1.getContent());

          result = this.HttpEntityProcess(doc1);
        }
      }
      else
      {
        throw new CatException("Http Error [Error Code = " + responseCode + ", "
                + "Message = " + "null]!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  private Object OpswHttpSendGet(Object object) throws CatException
  {
    Object result = null;
    try
    {
      HttpUriRequest httpGet = new HttpGet(this.getUrl());
      this.KoinaRequest(httpGet);

      HttpResponse httpResponse = this.CreateHttpClient().execute(httpGet);

      int responseCode = httpResponse.getStatusLine().getStatusCode();

      if (responseCode == HttpStatus.OK.value())
      {
        HttpEntity httpEntity = httpResponse.getEntity();

        // Parse the response using DocumentBuilder so you can get at elements easily
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(httpEntity.getContent());

        result = this.HttpEntityProcess(doc);
      }
      else
      {
        throw new CatException("Http Error [Error Code = " + responseCode + ", "
                + "Message = " + "null]!");
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

  private Document ObjectProcess(Object obj) throws CatException
  {
    Document document = null;
    try
    {
      // Parse the response using DocumentBuilder so you can get at elements easily
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

      document = docBuilder.newDocument();

      List<CatReflectObject01> wRefL = OpswReflection.ReflectObjectToObject01List(obj);

      if (wRefL != null)
      {
        for (CatReflectObject01 c : wRefL)
        {
          Element vel = document.createElement(c.getFieldName());

          this.ObjectProcessFill01(vel, c, document);

          document.appendChild(vel);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return document;
  }

  private void ObjectProcessFill01(Element element, CatReflectObject01 obj, Document document)
          throws CatException
  {
    try
    {
      if (!obj.isIsPrimitive() && !obj.isIsClassOfPrimitive())
      {
        List<CatReflectObject01> objR = OpswReflection.ReflectObjectToObject01List(obj.getFieldValue());

        if (objR != null)
        {
          for (CatReflectObject01 c : objR)
          {
            Element velement = document.createElement(c.getFieldName());

            this.ObjectProcessFill01(velement, c, document);

            document.appendChild(velement);
          }
        }
      }
      else
      {
        Object elVal = obj.getFieldValue();

        Object vval = null;
        if (obj.getFieldType().getName().equals(Boolean.class.getName()))
        {
          boolean vbool = false;
          if (elVal != null)
          {
            vbool = (Boolean) elVal;
          }
          vval = vbool;
        }
        else if (obj.getFieldType().getName().equals(Long.class.getName()))
        {
          long vlong = 0;
          if (elVal != null)
          {
            vlong = (Long) elVal;
          }
          vval = vlong;
        }
        else if (obj.getFieldType().getName().equals(Integer.class.getName()))
        {
          int vint = 0;
          if (elVal != null)
          {
            vint = (Integer) elVal;
          }
          vval = vint;
        }
        else if (obj.getFieldType().getName().equals(Short.class.getName()))
        {
          short vshort = 0;
          if (elVal != null)
          {
            vshort = (Short) elVal;
          }
          vval = vshort;
        }
        else if (obj.getFieldType().getName().equals(Byte.class.getName()))
        {
          byte vbyte = 0;
          if (elVal != null)
          {
            vbyte = (Byte) elVal;
          }
          vval = vbyte;
        }
        else if (obj.getFieldType().getName().equals(Double.class.getName()))
        {
          double vdouble = 0;
          if (elVal != null)
          {
            vdouble = (Double) elVal;
          }
          vval = vdouble;
        }
        else if (obj.getFieldType().getName().equals(Float.class.getName()))
        {
          float vfloat = 0;
          if (elVal != null)
          {
            vfloat = (Float) elVal;
          }
          vval = vfloat;
        }
        else if (obj.getFieldType().getName().equals(Calendar.class.getName()))
        {
          String valEl = null;
          if (elVal != null)
          {
            valEl = (String) elVal;
          }

          vval = null;
          if (!OpswStringUtils.OpswStringIsEmpty(valEl))
          {
            vval = OpswDateUtils.StrToDate(valEl, this.getDateFormat());
          }
        }
        else
        {
          vval = elVal;
        }
        // Create Last Name Element
        Element velem = document.createElement(obj.getFieldName());
        velem.appendChild(document.createTextNode(String.valueOf(vval)));

        element.appendChild(velem);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private Object HttpEntityProcess(Document document) throws CatException
  {
    Object obj = null;
    try
    {

      obj = this.getResponseBody().newInstance();

      Element root = document.getDocumentElement();
      // Now let's say you have not one, but 'n' nodes that contain the value
      // you're looking for. Use NodeList to get a list of all those nodes and just 
      // pull out the tag/attribute's value you want.

      List<CatReflectObject01> fields = OpswReflection.ReflectObjectToObject01List(obj);

      if (fields != null)
      {
        for (CatReflectObject01 c : fields)
        {
          this.EntityProcessFill01(root, c, obj);
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
                  this.EntityProcessFill01((Element) vnode, c, internalObj);
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
        else if (obj.getFieldType().getName().equals(Calendar.class.getName()))
        {
          String valEl = null;
          if (elVal != null)
          {
            valEl = (String) elVal;
          }

          vval = null;
          if (!OpswStringUtils.OpswStringIsEmpty(valEl))
          {
            vval = OpswDateUtils.StrToDate(valEl, this.getDateFormat());
          }
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
