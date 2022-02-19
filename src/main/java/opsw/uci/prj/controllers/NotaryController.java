/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.services.SymbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author n.oulis
 */
@Controller
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_NOTARY)
public class NotaryController
{

  @Autowired
  private SymbService SymbService;

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_NOTARY_LIST01)
  public String notaryList01(Model model) throws CatException
  {
    List<Symb> notaries = null;
    try
    {
      notaries = this.SymbService.SymbList02();
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("CLM0", notaries);
    return "symbList01";
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_NOTARY_ED01)
  public String notaryEd01(@RequestParam(name = "id", required = false) Long symb_id, Model model) throws Exception
  {
    Symb vsymb = null;
    try
    {
      vsymb = this.SymbService.SymbSelect02(symb_id);

      if (vsymb == null)
      {
        vsymb = new Symb();
      }

      model.addAttribute("CLM0", vsymb);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "symbEd01";
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_NOTARY_ED01_POST01)
  public String notaryPost01(
          @RequestParam(name = "id", required = false) Long symb_id,
          @ModelAttribute(name = "CLM0") Symb isymb, Model model,
          HttpServletRequest request)
          throws CatException
  {
    Symb vsymb = null;
    try
    {
      OpswLoginVars vlogvar = new OpswLoginVars();
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, vlogvar);

      vsymb = this.SymbService.SymbEDPost01(symb_id, isymb, vlogvar);

      model.addAttribute("CLM0", vsymb);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "symbEd01";
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_NOTARY_DELETE01)
  public String notaryDelete01(
          @PathVariable(name = "symb_id") Long symb_id, Model model
  ) throws CatException
  {
    List<Symb> vsymbList = null;
    try
    {
      vsymbList = this.SymbService.SymbPRDelete01(symb_id);

      model.addAttribute("CLM0", vsymbList);
    }
    catch (CatException ex)
    {
      ex.setRedirectToError(false);
      ex.setRedirectPath("notary/list01");
      CatException.ErrorAddErrorParameter(ex, new Boolean(true));
      CatException.ErrorAddErrorMessageParameter(ex, ex.getTechMessage());
      CatException.RethrowCatException(ex);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "symbList01";
  }

}
