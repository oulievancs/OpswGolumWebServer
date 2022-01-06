/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author oulis
 */
@Controller
@RequestMapping("/gram")
public class Gram00Controller
{

  @Autowired
  private Gram00Service Gram00Service;

  @Autowired
  private Gram01Service Gram01Service;

  @GetMapping("/gram00/list01")
  public String Gram00List01(Model model)
  {
    List<Gram00> gramList01 = this.Gram00Service.Gram00List01();

    model.addAttribute("CLM0", gramList01);

    return "gram00List01";
  }

  @GetMapping("/gram00/ed01/{gram}")
  public String Gram00Ed01(@PathVariable("gram") long gram, Model model)
  {
    Gram00 gram00 = this.Gram00Service.Gram00Select02(gram);

    model.addAttribute("CLM0", gram00);
    if (gram00 != null)
    {
      model.addAttribute("CLM1", gram00.getGram01List());
    }

    return "gram00Ed01";
  }

  @PostMapping("/gram00/ed01/post01/{gram}")
  public String Gram00Ed01Post01(@PathVariable("gram") long gram, @ModelAttribute("CLM0") Gram00 gram00, Model model)
  {
    Gram00 aft_gram00 = this.Gram00Service.Gram00Post02(gram, gram00);

    model.addAttribute("CLM0", aft_gram00);
    if (aft_gram00 != null)
    {
      model.addAttribute("CLM1", aft_gram00.getGram01List());
    }

    return "gram00Ed01";
  }

  @GetMapping("/gram01/ed01/{gram}")
  public String Gram01Ed01New(@PathVariable("gram") long gram, Model model)
  {
    Gram01 new_gram01 = new Gram01();
    new_gram01.setGram(gram);
    new_gram01.setSenu(this.Gram01Service.Gram01MaxSenu(gram) + 1);

    model.addAttribute("CLM0", new_gram01);
    return "gram01Ed01";
  }

  @PostMapping("/gram01/ed01/post01/{gram}/{senu}")
  public String Gram01Ed01Post01(@PathVariable("gram") long gram, @PathVariable("senu") long senu, @ModelAttribute("CLM0") Gram01 gram01)
  {
    Gram01 new_gram01 = this.Gram01Service.Gram01Post02(gram, senu, gram01);

    //model.addAttribute("CLM0", new_gram01);
    return "redirect:/gram00/ed01/" + gram;
  }

}
