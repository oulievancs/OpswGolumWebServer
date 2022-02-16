/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.client;

import opsw.uci.prj.cat.CatException;

/**
 *
 * @author oulis
 */
public abstract class OpswHttpRequestBase
{

  public static enum OpswHttpMethod
  {
    OPSW_HTTP_MENTHOD_NONE,
    OPSW_HTTP_MENTHOD_GET,
    OPSW_HTTP_MENTHOD_POST,
    OPSW_HTTP_MENTHOD_PUT,
    OPSW_HTTP_MENTHOD_DELETE
  }

  public static enum OpswHttpBodyType
  {
    OPSW_HTTP_BODY_NONE,
    OPSW_HTTP_BODY_XML,
    OPSW_HTTP_BODY_JSON
  }

  public static enum OpswHttpRequestProtocol
  {
    OPSW_HTTP_PROTOCOL_NONE,
    OPSW_HTTP_PROTOCOL_HTTP,
    OPSW_HTTP_PROTOCOL_HTTPS
  }

  private OpswHttpMethod method;
  private OpswHttpBodyType bodyType;
  private String url;
  private OpswHttpRequestProtocol httpProtocol;
  private Class<?> requestBody;
  private Class<?> responseBody;
  private String dateFormat;

  public OpswHttpRequestBase()
  {
    this.method = OpswHttpMethod.OPSW_HTTP_MENTHOD_NONE;
    this.bodyType = OpswHttpBodyType.OPSW_HTTP_BODY_NONE;
    this.httpProtocol = OpswHttpRequestProtocol.OPSW_HTTP_PROTOCOL_NONE;
    this.url = null;
    this.requestBody = null;
    this.responseBody = null;
    this.dateFormat = "dd/MM/yyyy";
  }

  public OpswHttpMethod getMethod()
  {
    return method;
  }

  public void setMethod(OpswHttpMethod method)
  {
    this.method = method;
  }

  public OpswHttpBodyType getBodyType()
  {
    return bodyType;
  }

  public void setBodyType(OpswHttpBodyType bodyType)
  {
    this.bodyType = bodyType;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public OpswHttpRequestProtocol getHttpProtocol()
  {
    return httpProtocol;
  }

  public void setHttpProtocol(OpswHttpRequestProtocol httpProtocol)
  {
    this.httpProtocol = httpProtocol;
  }

  public Class<?> getRequestBody()
  {
    return requestBody;
  }

  public void setRequestBody(Class<?> requestBody)
  {
    this.requestBody = requestBody;
  }

  public Class<?> getResponseBody()
  {
    return responseBody;
  }

  public void setResponseBody(Class<?> responseBody)
  {
    this.responseBody = responseBody;
  }

  public String getDateFormat()
  {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat)
  {
    this.dateFormat = dateFormat;
  }

  protected abstract Object OpswHttpSendRequest(Object object) throws CatException;

  public Object OpswHttpSend(Object object) throws CatException
  {
    Object result = null;
    try
    {
      this.Validation01();

      result = this.OpswHttpSendRequest(object);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  private void Validation01() throws CatException
  {
    try
    {
      if (this.method == null || this.method == OpswHttpMethod.OPSW_HTTP_MENTHOD_NONE)
      {
        throw new CatException("Method not provided!");
      }

      if ((this.method != OpswHttpMethod.OPSW_HTTP_MENTHOD_GET)
              && (this.bodyType == null || this.bodyType == OpswHttpBodyType.OPSW_HTTP_BODY_NONE))
      {
        throw new CatException("Body type not provided!");
      }

      if (this.httpProtocol == null || this.httpProtocol == OpswHttpRequestProtocol.OPSW_HTTP_PROTOCOL_NONE)
      {
        throw new CatException("Http protocol not provided!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
