/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
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
  public String home()
  {
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
