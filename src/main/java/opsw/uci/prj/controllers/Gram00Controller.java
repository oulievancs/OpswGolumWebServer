/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.globals.OpswLanguage;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.Gram00Rec02;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.OpswconstvService;
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
 * @author oulis
 */
@Controller
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_GRAM)
public class Gram00Controller
{

  @Autowired
  private Gram00Service Gram00Service;

  @Autowired
  private Gram01Service Gram01Service;

  @Autowired
  private OpswconstvService OpswconstvService;

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_LIST01)
  public String Gram00List01(Model model) throws Exception
  {
    List<Gram00> gramList01 = this.Gram00Service.Gram00List01();

    model.addAttribute("CLM0", gramList01);

    return "gram00List01";
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_ED01)
  public String Gram00Ed01(@RequestParam(name = "gram", required = false) Long gram, Model model)
          throws Exception
  {
    Gram00 gram00 = null;
    List<CatThmlfObject01> vcatLst = new ArrayList<>();
    if (gram != null)
    {
      gram00 = this.Gram00Service.Gram00Rec02EDSelect02(gram, vcatLst);
    }
    if (gram00 == null)
    {
      gram00 = new Gram00Rec02();
    }
    model.addAttribute("CLM0", gram00);

    if (gram00 != null)
    {
      model.addAttribute("CLM1", this.Gram01Service.Gram01Rec01List01(gram));
      model.addAttribute("internalKeyFldsLst", vcatLst);
    }

    return "gram00Ed01";
  }

  /*@PostMapping("/gram00/ed01/post01/{gram}")
  public String Gram00Ed01Post01(@PathVariable("gram") long gram, @ModelAttribute("CLM0") Gram00 gram00, Model model)
  {
    Gram00 aft_gram00 = this.Gram00Service.Gram00Post02(gram, gram00);

    model.addAttribute("CLM0", aft_gram00);
    if (aft_gram00 != null)
    {
      model.addAttribute("CLM1", aft_gram00.getGram01List());
    }

    return "gram00Ed01";
  }*/
  @PostMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_ED01_POST01)
  public String Gram00Ed01Post01(@RequestParam(name = "gram", required = false) Long gram,
          @ModelAttribute("CLM0") Gram00Rec02 gram00Rec02, Model model, HttpServletRequest request)
          throws Exception
  {
    OpswLoginVars vlogvar = new OpswLoginVars();
    OpswCookies01.OpswFillLoginVarsFromCookies01(request, vlogvar);

    List<CatThmlfObject01> vcatLst = new ArrayList<>();
    Gram00 aft_gram00 = this.Gram00Service.Gram00PostED02(gram, gram00Rec02,
            vlogvar, vcatLst);

    model.addAttribute("CLM0", aft_gram00);
    model.addAttribute("internalKeyFldsLst", vcatLst);

    if (aft_gram00 != null)
    {
      model.addAttribute("CLM1", aft_gram00.getGram01List());
    }

    return "gram00Ed01";
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_GRAM01_ED01)
  public String Gram01Ed01New(@PathVariable("gram") long gram, @RequestParam(name = "senu", required = false) Long senu, Model model)
          throws Exception
  {
    Gram01 gram01 = null;
    if (senu != null)
    {
      //fere to gram01
      gram01 = this.Gram01Service.Gram01Select01(gram, senu);
    }
    if (gram01 == null)
    {
      //new gram01
      gram01 = new Gram01();
      gram01.setGram(gram);
    }

    List<CatThmlfObject01> fieldsList = this.OpswconstvService.FieldsList01(Opswconstsv.ASSETS_VALUE);
    List<CatThmlfObject01> fieldsList1 = this.OpswconstvService.FieldsList01(Opswconstsv.FIELD_TYPE);

    model.addAttribute("CLM0", gram01);
    model.addAttribute("fieldsList", fieldsList);
    model.addAttribute("fieldsList1", fieldsList1);
    return "gram01Ed01";
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_GRAM01_ED01_POST01)
  public String Gram01Ed01Post01(@PathVariable("gram") long gram, @RequestParam(name = "senu", required = false) Long senu,
          @ModelAttribute("CLM0") Gram01 gram01, HttpServletRequest request)
          throws Exception
  {
    OpswLoginVars vLoginVars = new OpswLoginVars();
    OpswCookies01.OpswFillLoginVarsFromCookies01(request, vLoginVars);
    Gram01 new_gram01 = this.Gram01Service.Gram01Post02(gram, senu, gram01);

    //model.addAttribute("CLM0", new_gram01);
    return "redirect:" + OpswWebConst.OPSW_CONTROLLER_GRAM
            + OpswWebConst.OPSW_CONTROLLER_GRAM_ED01 + "?gram=" + gram;
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_GRAM00_DELETE01)
  public String Gram00Delete01(@PathVariable("gram") Long gram,
          HttpServletRequest request)
          throws Exception
  {
    OpswLoginVars vLoginVars = new OpswLoginVars();
    OpswCookies01.OpswFillLoginVarsFromCookies01(request, vLoginVars);
    if (gram != null)
    {
      this.Gram00Service.Gram00Delete01(gram);
    }

    return "redirect:" + OpswWebConst.OPSW_CONTROLLER_GRAM + OpswWebConst.OPSW_CONTROLLER_GRAM_LIST01;
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_GRAM_GRAM01_DELETE01)
  public String Gram01Delete01(@PathVariable("gram") Long gram, @PathVariable("senu") Long senu,
          HttpServletRequest request)
          throws Exception
  {
    OpswLoginVars vLoginVars = new OpswLoginVars();
    OpswCookies01.OpswFillLoginVarsFromCookies01(request, vLoginVars);
    if (gram != null && senu != null)
    {
      this.Gram01Service.Gram01Delete01(gram, senu);
    }
    return "redirect:" + OpswWebConst.OPSW_CONTROLLER_GRAM + OpswWebConst.OPSW_CONTROLLER_GRAM_ED01
            + "?gram=" + gram;
  }

}
