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
      HandleModelAndView(ex, mav);
      mav.addObject("url", req.getRequestURL());
      mav.setViewName("errors/error01");
    }
  }

  public static void HandleControllerException(HttpServletRequest req, Exception ex)
  {
    if (ex instanceof CatExceptionUser)
    {
      //
    } else if (ex instanceof CatException)
    {
      HandleCatException(req, (CatException) ex);
    } else
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

  private static void HandleModelAndView(Exception ex, ModelAndView mav)
  {
    if (ex instanceof CatExceptionUser)
    {
      HandleModelAndViewCatExceptionUser((CatExceptionUser) ex, mav);
    } else if (ex instanceof CatException)
    {
      HandleModelAndViewCatException((CatException) ex, mav);
    } else
    {
      HandleModelAndViewException((Exception) ex, mav);
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
