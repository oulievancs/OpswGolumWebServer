/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.SymbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author n.oulis
 */
@Controller
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_MODAL)
public class ModalController
{
  @Autowired
  private SymbService SymbService;
  
  @Autowired
  private Assets00Service assets00Service;
  
  @GetMapping(OpswWebConst.OPSW_CONTROLLER_MODAL_SYMB_MODAL01)
  public String modal2(@RequestParam(name="asset", required=true) Long iAsset, Model model) throws CatException
  {
    List<Symb> symbList = null;
    try
    {
      symbList = this.SymbService.SymbList02();
    }
    catch(Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("asset", iAsset);
    model.addAttribute("CLM0", symbList);
    return "symb_modal";
  }
  
  @GetMapping(OpswWebConst.OPSW_CONTROLLER_MODAL_SYMB_MODAL01_POST)
  public String modalPost(@RequestParam(name="asset", required=true) Long assetId, @RequestParam(name="symb", required=true) Long symbId) throws CatException
  {
    Symb vSymb;
    Assets00 asset00;
    String redirectUrl = OpswWebConst.OPSW_CONTROLLER_ASSETS00 + OpswWebConst.OPSW_CONTROLLER_ASSETS00_ED01;
    try
    {
      vSymb = this.SymbService.SymbSelect02(symbId);
      
      if (vSymb != null)
      {
        asset00 = assets00Service.Assets00Select01(assetId);
        asset00.setSymb_id(vSymb.getId());
        asset00.setSymb(vSymb);
        asset00 = assets00Service.Assets00Post02(asset00, false);
        redirectUrl += "?asset=" + asset00.getAsset();
      }
    }
    catch(Exception e)
    {
      CatException.RethrowCatException(e);
    }
    
    return "redirect:" + redirectUrl;
  }

}
