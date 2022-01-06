/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.services.Assets00Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author oulis
 */
@Controller
@RequestMapping("/assets")
public class Assets00Controller
{

  @Autowired
  private Assets00Service Assets00Service;

  @GetMapping("/assets00/list01")
  public String Assets00List01(Model model)
          throws Exception
  {
    List<Assets00> assets00List = null;
    try
    {
      assets00List = this.Assets00Service.Assets00List02();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    model.addAttribute("CLM0", assets00List);

    return "assets00List01";
  }
}
