/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.exception.controllers;

import opsw.uci.prj.logic.OpswExceptionHandler;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
  @ResponseStatus(value = HttpStatus.CONFLICT,
          reason = "Data integrity violation")  // 409
  @ExceptionHandler(DataIntegrityViolationException.class)
  public void conflict()
  {
    // Nothing to do
  }

  // Specify name of a specific view that will be used to display the error:
  @ExceptionHandler(
          {
            SQLException.class, DataAccessException.class
          })
  public ModelAndView databaseError(HttpServletRequest req, Exception ex)
  {
    // Nothing to do.  Returns the logical view name of an error page, passed
    // to the view-resolver(s) in usual way.
    // Note that the exception is NOT available to this view (it is not added
    // to the model) but see "Extending ExceptionHandlerExceptionResolver"
    // below.
    ModelAndView mav = new ModelAndView();
    OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ex, mav);
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
  public ModelAndView handleError(HttpServletRequest req, Exception ex)
  {
    ModelAndView mav = new ModelAndView();
    OpswExceptionHandler.HandleControllerExceptionAndModelView(req, ex, mav);
    return mav;
  }
}
