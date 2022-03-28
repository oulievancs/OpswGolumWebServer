/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.logic;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.utils.OpswStringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author oulis
 */
public class OpswExceptionHandler
{

  public static ModelAndView HandleControllerExceptionAndModelView(HttpServletRequest req,
          RedirectAttributes ra, Exception ex, ModelAndView mav)
          throws CatException
  {
    HandleControllerException(req, ex);

    if (mav != null)
    {
      mav = HandleModelAndView(req, ra, ex, mav);
    }
    return mav;
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
    else if (ex instanceof AccessDeniedException)
    {
      //
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

  private static ModelAndView HandleModelAndView(HttpServletRequest req, RedirectAttributes ra,
          Exception ex, ModelAndView mav)
          throws CatException
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
    else if (ex instanceof AccessDeniedException)
    {
      HandleModelAndViewAccessDenied((AccessDeniedException) ex, mav);
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
          mav = new ModelAndView("redirect:/" + OpswStringUtils.OpswMakeNotPathStart(ex1.getRedirectPath()));

          Set<String> keySet = ex1.getErrorParameters().keySet();

          for (String key : keySet)
          {
            ra.addFlashAttribute(key, ex1.getErrorParameters().get(key));
          }

          if (!keySet.contains(CatException.CATEXCEPTION_THYMLEAF_ERROR)
                  || ex1.getErrorParameters().get(CatException.CATEXCEPTION_THYMLEAF_ERROR) == null)
          {
            ra.addFlashAttribute(CatException.CATEXCEPTION_THYMLEAF_ERROR, false);
          }

          if (!keySet.contains(CatException.CATEXCEPTION_THYMLEAF_MESSAGE)
                  || OpswStringUtils.OpswStringIsEmpty((String) ex1.getErrorParameters().get(CatException.CATEXCEPTION_THYMLEAF_MESSAGE)))
          {
            ra.addFlashAttribute(CatException.CATEXCEPTION_THYMLEAF_MESSAGE, "Internal Error!");
          }
        }
      }
    }
    else
    {
      mav.addObject("url", req.getRequestURL());
      mav.setViewName("errors/error01");
    }

    return mav;
  }

  private static void HandleModelAndViewCatExceptionUser(CatExceptionUser ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", ex.getUserMessage());
  }

  private static void HandleModelAndViewCatException(CatException ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", "Internal Error!");
  }

  private static void HandleModelAndViewAccessDenied(AccessDeniedException ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", "Access Denied");
  }

  private static void HandleModelAndViewException(Exception ex, ModelAndView mav)
  {
    mav.addObject("errorMessage", "Internal Error!");
  }
}
