/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.services.Gram00Service;
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
@RequestMapping("/gram00")
public class Gram00Controller
{

  @Autowired
  private Gram00Service Gram00Service;

  @GetMapping("/list01")
  public String Gram00List01(Model model)
  {
    List<Gram00> gramList01 = this.Gram00Service.Gram00List01();

    model.addAttribute("CLM0", gramList01);

    return "gram00List01";
  }

  @GetMapping("/ed01/{gram}")
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

  @PostMapping("/ed01/post01/{gram}")
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

}
