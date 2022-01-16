/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.services.SymbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author n.oulis
 */
@Controller
@RequestMapping("/notary")
public class NotaryController
{
  @Autowired
  private SymbService symbService;
  
  @GetMapping("/list01")
  public String notaryList01(Model model) throws CatException
  {
    List<Symb> notaries = null;
    try
    {
      notaries = this.symbService.SymbList02();
    }
    catch(Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("CLM0", notaries);
    return "symbList01";
  }
  
}
