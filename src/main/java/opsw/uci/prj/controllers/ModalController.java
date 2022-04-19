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
import opsw.uci.prj.utils.OpswStringUtils;
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
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_MODAL)
public class ModalController
{

  @Autowired
  private SymbService SymbService;

  @Autowired
  private Assets00Service assets00Service;

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_MODAL_SYMB_MODAL01)
  public String modal2(@RequestParam(name = "asset", required = true) Long iAsset,
          @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
          Model model) throws CatException
  {
    List<Symb> symbList = null;
    try
    {
      symbList = this.SymbService.SymbList02();
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("asset", iAsset);
    model.addAttribute("CLM0", symbList);

    model.addAttribute("params1RedirectUrl", redirectUrl);

    return "symb_modal";
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_MODAL_SYMB_MODAL01_POST)
  public String modalPost(@PathVariable("asset") Long assetId,
          @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
          @RequestParam("symbId") Long symbId) throws CatException
  {
    Symb vSymb;
    Assets00 asset00;
    String vredirectUrl = OpswWebConst.OPSW_CONTROLLER_ASSETS00 + OpswWebConst.OPSW_CONTROLLER_ASSETS00_ED01;

    try
    {
      vSymb = this.SymbService.SymbSelect02(symbId);

      if (vSymb != null)
      {
        asset00 = assets00Service.Assets00Select01(assetId);
        asset00.setSymb_id(vSymb.getId());
        asset00.setSymb(vSymb);
        asset00 = assets00Service.Assets00Post02(asset00, false, true);

        vredirectUrl += "?asset=" + asset00.getAsset();
        vredirectUrl += "&redirectUrl=" + (OpswStringUtils.OpswStringIsEmpty(redirectUrl) ? "" : redirectUrl);
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }

    return "redirect:" + vredirectUrl;
  }

}
