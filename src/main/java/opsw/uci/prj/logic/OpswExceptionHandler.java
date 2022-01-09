/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.logic;

import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.logging.OpswLogger;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author oulis
 */
public class OpswExceptionHandler
{

  public static void HandleControllerExceptionAndModelView(HttpServletRequest req, Exception ex, ModelAndView mav)
  {
    HandleControllerException(req, ex);

    if (mav != null)
    {
      HandleModelAndView(req, ex, mav);
    }
  }

  public static void HandleControllerException(HttpServletRequest req, Exception ex)
  {
    if (ex instanceof CatExceptionUser)
    {
      //
    }
    else if (ex instanceof CatException)
    {
      HandleCatException(req, (CatException) ex);
    }
    else
    {
      HandleException(req, ex);
    }
  }

  private static void HandleCatException(HttpServletRequest req, CatException ex)
  {
    OpswLogger.LoggerLogException("CATException / Access: " + req.getRequestURI() + ", " + ex.getTechMessage() + ", " + ex.getMessage(), ex);
  }

  private static void HandleException(HttpServletRequest req, Exception ex)
  {
    OpswLogger.LoggerLogException("Exception / Access: " + req.getRequestURI() + ", " + ex.getMessage(), ex);
  }

  private static void HandleModelAndView(HttpServletRequest req, Exception ex, ModelAndView mav)
  {
    CatException ex1 = null;

    if (ex instanceof CatExceptionUser)
    {
      ex1 = (CatExceptionUser) ex;
      HandleModelAndViewCatExceptionUser((CatExceptionUser) ex, mav);
    }
    else if (ex instanceof CatException)
    {
      ex1 = (CatException) ex;
      HandleModelAndViewCatException((CatException) ex, mav);
    }
    else
    {
      HandleModelAndViewException((Exception) ex, mav);
    }

    if (ex1 != null)
    {
      if (ex1.isRedirectToError())
      {
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errors/error01");
      }
      else
      {
        if (ex1.getErrorParameters() != null)
        {
          mav.addAllObjects(ex1.getErrorParameters());
          mav.setViewName("redirect:/" + req.getServletPath());
        }
      }
    }
  }

  private static void HandleModelAndViewCatExceptionUser(CatExceptionUser ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", ex.getUserMessage());
  }

  private static void HandleModelAndViewCatException(CatException ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", "Internal Error!");
  }

  private static void HandleModelAndViewException(Exception ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", "Internal Error!");
  }
}
