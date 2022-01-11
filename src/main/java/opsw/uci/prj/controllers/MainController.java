/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.system.OpswMenuDo01;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author n.oulis
 */
@Controller
@RequestMapping("/")
public class MainController
{

  @GetMapping("home")
  public String home(HttpServletRequest request, Model model) throws CatException
  {
    try
    {
      
    }
    catch(Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return "home";
  }

  @GetMapping("logout")
  public String logout(HttpServletRequest request) throws Exception
  {
    request.logout();
    return "home";
  }

  @GetMapping("login")
  public String login(HttpServletRequest request) throws Exception
  {
    return "redirec:/home";
  }
}
