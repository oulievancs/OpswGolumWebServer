/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.exception.controllers;

import opsw.uci.prj.logic.OpswExceptionHandler;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author oulis
 */
@ControllerAdvice
public class OpswExceptionHandlerController
{

  // @RequestHandler methods
  //...
  // Exception handling methods
  // Convert a predefined exception to an HTTP Status code
  //@ResponseStatus(value = HttpStatus.CONFLICT,
  //        reason = "Data integrity violation")  // 409
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ModelAndView conflict(RedirectAttributes ra, HttpServletRequest req, Exception ex)
          throws Exception
  {
    ModelAndView mav = new ModelAndView();
    try
    {
      mav = OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ra, ex, mav);
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }
    return mav;
  }

  @ResponseStatus(
          value = HttpStatus.INTERNAL_SERVER_ERROR,
          reason = "Internal Error!"
  )
  public ModelAndView internalError(RedirectAttributes ra, HttpServletRequest req, Exception ex)
          throws Exception
  {
    ModelAndView mav = new ModelAndView();
    try
    {
      mav = OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ra, ex, mav);
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }
    return mav;
  }

  @ResponseStatus(
          value = HttpStatus.NOT_FOUND,
          reason = "Resource not found!"
  )
  public ModelAndView notFound(RedirectAttributes ra, HttpServletRequest req, Exception ex)
          throws Exception
  {
    ModelAndView mav = new ModelAndView();
    try
    {
      mav = OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ra, ex, mav);
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }
    return mav;
  }

  // Specify name of a specific view that will be used to display the error:
  @ExceptionHandler(
          {
            SQLException.class, DataAccessException.class
          })
  public ModelAndView databaseError(RedirectAttributes ra, HttpServletRequest req, Exception ex)
          throws Exception
  {
    // Nothing to do.  Returns the logical view name of an error page, passed
    // to the view-resolver(s) in usual way.
    // Note that the exception is NOT available to this view (it is not added
    // to the model) but see "Extending ExceptionHandlerExceptionResolver"
    // below.
    ModelAndView mav = new ModelAndView();
    try
    {
      mav = OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ra, ex, mav);
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }
    return mav;
  }

  // Total control - setup a model and return the view name yourself. Or
  // consider subclassing ExceptionHandlerExceptionResolver (see below).
  @ExceptionHandler(
          {
            Exception.class,
            CatException.class,
            CatExceptionUser.class
          })
  public ModelAndView handleError(RedirectAttributes ra, HttpServletRequest req, Exception ex)
          throws Exception
  {
    ModelAndView mav = new ModelAndView();
    try
    {
      mav = OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ra, ex, mav);
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }
    return mav;
  }

  @ExceptionHandler(
          {
            AccessDeniedException.class
          })
  public ModelAndView accessDenied(RedirectAttributes ra, HttpServletRequest req, Exception ex)
          throws Exception
  {
    ModelAndView mav = new ModelAndView();
    try
    {
      mav = OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ra, ex, mav);
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }
    return mav;
  }

  @ExceptionHandler(
          {
            ResponseStatusException.class
          })
  public ResponseEntity<Object> voidResponseStatusException(HttpServletRequest req, Exception ex)
          throws Exception
  {
    ResponseEntity resEnt = null;

    try
    {
      ResponseStatusException vresStat = (ResponseStatusException) ex;

      Map<String, Object> response = new HashMap<>();

      response.put("success", "false");
      response.put("reason", vresStat.getReason());
      response.put("timestamp", OpswDateUtils.DateTimeToStr01(Calendar.getInstance()));

      resEnt = new ResponseEntity<>(response, vresStat.getStatus());
    }
    catch (Exception ex1)
    {
      OpswLogger.LoggerLogException(ex1);
      OpswLogger.LoggerLogException(ex);
      CatException.RethrowCatException(ex1);
    }

    return resEnt;
  }
}
