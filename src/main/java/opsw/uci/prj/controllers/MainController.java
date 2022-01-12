/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.globals.OpswErpRecords01;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.records.cat.CatThmlfObject02;
import opsw.uci.prj.records.cat.CatThmlfObjectBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    catch (Exception e)
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

  @GetMapping("init1")
  public String init1(Model model, HttpServletRequest request) throws Exception
  {
    try
    {
      CatThmlfObject02 obj1 = new CatThmlfObject02();

      OpswLoginVars vLoginVars = new OpswLoginVars();
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, vLoginVars);
      obj1.setCode(new Long(vLoginVars.getEtai()));

      List<CatThmlfObject02> vlist = OpswErpRecords01.OpswListXrhshListObj();

      model.addAttribute("fieldsList", vlist);
      model.addAttribute("CLM0", obj1);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "init1";
  }

  @PostMapping("init1/post")
  public String init1Post(@ModelAttribute("CLM0") CatThmlfObject02 clm0,
          HttpServletRequest request,
          Principal principal,
          RedirectAttributes redirectAttrs)
          throws Exception
  {
    try
    {
      CatThmlfObject02 obj = (CatThmlfObject02) clm0;

      if (obj == null || obj.getCode() == null)
      {
        throw new CatExceptionUser("Δεν έχει επιλεγεί κάποια έγγυρη επιλογή!");
      }

      OpswLoginVars wLoginVars = new OpswLoginVars();
      OpswErpRecords01.OpswXrhshByEtairSetConnection(wLoginVars, obj.getCode().shortValue());
      wLoginVars.setEtai(obj.getCode().shortValue());

      if (principal != null)
      {
        wLoginVars.setLoginUser(principal.getName());
      }
      else
      {
        wLoginVars.setLoginUser("dev");
      }

      OpswCookies01.OpswFillCookiesFromLoginVars01(request, wLoginVars);
      redirectAttrs.addFlashAttribute("message", "Η αλλαγή πραγματοποιήθηκε με επιτυχία");
      redirectAttrs.addFlashAttribute("error", false);
    }
    catch (CatException ex)
    {
      CatException.ErrorAddParameter(ex, "errorMessage", ex.getTechMessage());
      ex.setRedirectToError(true);
      ex.setRedirectPath("init1");
      CatException.RethrowCatException(ex);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "redirect:/init1";
  }
}
