/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.cat;

import java.util.Map;

/**
 *
 * @author oulis
 */
public class CatExceptionUser extends CatException
{

  private String userMessage;

  public CatExceptionUser()
  {
    super();
    this.userMessage = null;
  }

  public CatExceptionUser(byte code, String userMessage, String techMessage, String message,
          boolean redirectToError, Map<String, Object> errorParameters, String redirectPath,
          Throwable th)
  {
    super(code, techMessage, message, redirectToError, errorParameters, redirectPath, th);
    this.userMessage = userMessage;
  }

  public CatExceptionUser(byte code, String userMessage)
  {
    super(code, userMessage);
    this.userMessage = userMessage;
  }

  public CatExceptionUser(String userMessage)
  {
    super(CatException.CODE_USER_EXCEPTION, userMessage);
    this.userMessage = userMessage;
  }

  public CatExceptionUser(String userMessage, String techMessage)
  {
    super(CatException.CODE_USER_EXCEPTION, techMessage);
    this.userMessage = userMessage;
  }

  public String getUserMessage()
  {
    return userMessage;
  }

  public void setUserMessage(String userMessage)
  {
    this.userMessage = userMessage;
  }
}
