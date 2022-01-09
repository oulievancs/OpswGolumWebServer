/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author oulis
 */
public class CatException extends Exception
{

  public static final byte CODE_CHECK_ERROR = 1;
  public static final byte CODE_NULL_PRM = 2;
  public static final byte CODE_USER_EXCEPTION = 3;
  public static final byte CODE_DBREC_NOT_FOUND = 4;

  /**
   * List of throwables.
   */
  private List<Throwable> exceptionsList;

  private byte code;
  private String techMessage;
  private boolean redirectToError;

  private Map<String, Object> errorParameters;

  public CatException()
  {
    super();
    this.code = CODE_CHECK_ERROR;
    this.techMessage = null;
    this.redirectToError = true;
    this.errorParameters = null;
  }

  public CatException(Throwable th)
  {
    super(th);
    this.code = CODE_CHECK_ERROR;
    this.techMessage = null;
    Koina01(th);
  }

  public CatException(String techMessage)
  {
    super();
    this.code = CODE_CHECK_ERROR;
    this.techMessage = techMessage;
  }

  public CatException(byte code, String techMessage, String message, Throwable th)
  {
    super(message, th);
    this.code = code;
    this.techMessage = techMessage;
    Koina01(th);
  }

  public CatException(byte code, String techMessage, String message)
  {
    super(message);
    this.code = code;
    this.techMessage = techMessage;
  }

  public CatException(byte code, String techMessage)
  {
    super();
    this.code = code;
    this.techMessage = techMessage;
  }

  public static void RethrowCatException(Throwable th)
          throws CatException
  {
    CatExceptionUser ex1 = null;
    CatException ex2 = null;
    if (th instanceof CatExceptionUser)
    {
      ex1 = (CatExceptionUser) th;
      throw new CatExceptionUser(ex1.getCode(), ex1.getUserMessage(),
              ex1.getTechMessage(), ex1.getMessage(), th);
    }
    else if (th instanceof CatException)
    {
      ex2 = (CatException) th;
      throw new CatException(ex2.getCode(), ex2.getTechMessage(), ex2.getMessage(), th);
    }
    else
    {
      throw new CatException(th);
    }
  }

  private void Koina01(Throwable th)
  {
    if (th != null)
    {
      if (this.exceptionsList == null)
      {
        this.exceptionsList = new ArrayList<>();
      }
      this.exceptionsList.add(th);
    }
  }

  public byte getCode()
  {
    return code;
  }

  public void setCode(byte code)
  {
    this.code = code;
  }

  public String getTechMessage()
  {
    return techMessage;
  }

  public void setTechMessage(String techMessage)
  {
    this.techMessage = techMessage;
  }

  public boolean isRedirectToError()
  {
    return redirectToError;
  }

  public void setRedirectToError(boolean redirectToError)
  {
    this.redirectToError = redirectToError;
  }

  public Map<String, Object> getErrorParameters()
  {
    return errorParameters;
  }

  public void setErrorParameters(Map<String, Object> errorParameters)
  {
    this.errorParameters = errorParameters;
  }

  public static void ErrorAddParameter(CatException ex, String name, Object value)
  {
    ErrorAddParameterKoina01(ex);
    ex.getErrorParameters().put(name, value);
  }

  public static void ErrorAddParameterInt(CatException ex, String name, int value)
  {
    ErrorAddParameterKoina01(ex);
    ex.getErrorParameters().put(name, new Integer(value));
  }

  private static void ErrorAddParameterKoina01(CatException ex)
  {
    if (ex.getErrorParameters() == null)
    {
      ex.setErrorParameters(new HashMap<>());
    }
  }
}
