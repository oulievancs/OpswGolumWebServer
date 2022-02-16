/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.client;

import java.io.StringWriter;
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
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author oulis
 */
public class OpswHttpRequest01 extends OpswHttpRequestBase
{

  private XmlReaderWriter xmlReaderWriter;

  public OpswHttpRequest01()
  {
    super();
    this.xmlReaderWriter = null;
  }

  @Override
  protected void ValidationInternal() throws CatException
  {
    try
    {
      if (this.xmlReaderWriter == null)
      {
        throw new CatException("XmlReaderWriter not initialized!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
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
        Element vel = document.createElement(obj.getClass().getSimpleName());
        for (CatReflectObject01 c : wRefL)
        {
          this.xmlReaderWriter.ObjectProcessFill01(vel, c, document);

        }
        document.appendChild(vel);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return document;
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

      CatReflectObject01 lcatObj = OpswReflection.ReflectObject(obj);

      if (lcatObj != null)
      {
        this.xmlReaderWriter.EntityProcessFill01(root, lcatObj, obj);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return obj;
  }

  public XmlReaderWriter getXmlReaderWriter()
  {
    return xmlReaderWriter;
  }

  public void setXmlReaderWriter(XmlReaderWriter xmlReaderWriter)
  {
    this.xmlReaderWriter = xmlReaderWriter;
  }
}
