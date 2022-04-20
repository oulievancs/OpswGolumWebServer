/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.Calendar;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.api.client.OpswHttpRequestBase;
import opsw.uci.prj.assetsapi.logic.LcOpswAssetsApi;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.globals.OpswRolesAllowed;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00Rec02;
import opsw.uci.prj.records.Assets00SearchParams01;
import opsw.uci.prj.records.cat.CatThmlfAssets00List01Params;
import opsw.uci.prj.records.cat.CatThmlfObjectDates01;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import opsw.uci.prj.utils.OpswUrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00)
public class Assets00Controller
{

  @Autowired
  private Assets00Service Assets00Service;

  @Autowired
  private SymbService SymbService;

  @Autowired
  private LcOpswAssetsApi opswAssetApi;

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_LIST01)
  public String Assets00List01(@RequestParam(name = "dateFrom", required = false) String dateFrom,
          @RequestParam(name = "dateTo", required = false) String dateTo,
          @RequestParam(name = "symb_id", required = false) Long symb_id,
          @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
          @ModelAttribute(name = "params") CatThmlfAssets00List01Params iparams,
          Model model)
          throws Exception
  {
    boolean returnRedirection = false;
    try
    {
      if (!OpswStringUtils.OpswStringIsEmpty(redirectUrl))
      {
        returnRedirection = true;
      }

      if (!returnRedirection)
      {
        CatThmlfAssets00List01Params vparams = iparams;

        if (vparams == null || vparams.getSearchDates() == null
                || vparams.getSearchDates().getDateFrom() == null
                || vparams.getSearchDates().getDateTo() == null)
        {
          if (vparams == null)
          {
            vparams = new CatThmlfAssets00List01Params();
          }

          vparams.setSymb_id(symb_id);

          CatThmlfObjectDates01 vsrch = vparams.getSearchDates();
          if (vsrch == null)
          {
            vsrch = new CatThmlfObjectDates01();
          }
          vparams.setSearchDates(vsrch);

          vsrch.setDateFrom(OpswDateUtils.StrToDate02(dateFrom));
          vsrch.setDateTo(OpswDateUtils.StrToDate02(dateTo));
        }
        this.Assets00List01_Internal(model, vparams);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    String res = null;

    if (returnRedirection)
    {
      res = "redirect:" + OpswUrlUtils.UrlDecoding(redirectUrl);
    }
    else
    {
      res = "assets00List01";
    }

    return res;
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_LIST01_POST)
  public String Assets00List01Post(/*@RequestParam(name = "dateFrom", required = false) String dateFrom,
          @RequestParam(name = "dateTo", required = false) String dateTo,*/
          @ModelAttribute(name = "params") CatThmlfAssets00List01Params iparams,
          Model model)
          throws CatException
  {
    try
    {
      Assets00List01_Internal(model, iparams);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return "assets00List01";
  }

  private void Assets00List01_Internal(Model model, CatThmlfAssets00List01Params iparams)
          throws CatException
  {
    List<Assets00Rec01> assets00List = null;
    List<Symb> symbList01 = null;

    try
    {
      //******CHECKS********//

      if (iparams.getSearchDates() == null)
      {
        iparams.setSearchDates(new CatThmlfObjectDates01());
      }

      Calendar vdateFrom = null;
      vdateFrom = OpswDateUtils.DateToCalendarElseNow(iparams.getSearchDates().getDateFrom());
      /*if (!OpswStringUtils.OpswStringIsEmpty(dateFrom))
      {
        vdateFrom = OpswDateUtils.StrToDate(dateFrom, OpswDateUtils.OPSW_DATE_THYMLEAF_02);
      }
      else
      {
        vdateFrom = Calendar.getInstance();
      }*/

      Calendar vdateTo = null;
      vdateTo = OpswDateUtils.DateToCalendarElseNow(iparams.getSearchDates().getDateTo());
      /*if (!OpswStringUtils.OpswStringIsEmpty(dateTo))
      {
        vdateTo = OpswDateUtils.StrToDate(dateTo, OpswDateUtils.OPSW_DATE_THYMLEAF_02);
      }
      else
      {
        vdateTo = Calendar.getInstance();
      }*/

      Assets00SearchParams01 vparams = new Assets00SearchParams01();
      vparams.setDateFrom(vdateFrom);
      vparams.setDateTo(vdateTo);
      vparams.setSymb_id(OpswNumberUtils.OpswGetLong(iparams.getSymb_id()));

      assets00List = this.Assets00Service.Assets00List03(vparams);

      symbList01 = this.SymbService.SymbList02();

      iparams.getSearchDates().setDateFrom(vdateFrom.getTime());
      iparams.getSearchDates().setDateTo(vdateTo.getTime());

      model.addAttribute("CLM0", assets00List);
      model.addAttribute("CLM1", symbList01);
      model.addAttribute("params", iparams);

      String vredUrl = OpswWebConst.OPSW_CONTROLLER_ASSETS00
              + OpswWebConst.OPSW_CONTROLLER_ASSETS00_LIST01
              + "?dateFrom=" + OpswDateUtils.DateToStr02(iparams.getSearchDates().getDateFrom())
              + "&dateTo=" + OpswDateUtils.DateToStr02(iparams.getSearchDates().getDateTo())
              + "&symb_id=" + (iparams.getSymb_id() == null ? "0" : iparams.getSymb_id());

      model.addAttribute("params1RedirectUrl", OpswUrlUtils.UrlEncoding(vredUrl));
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_ED01)
  public String Assets00Ed01(@RequestParam(name = "asset", required = false) Long assetId,
          @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
          Model model, HttpServletRequest request) throws CatException
  {
    Assets00Rec02 asset = null;
    Symb vSymb = null;
    try
    {
      if (assetId != null)
      {
        asset = this.Assets00Service.Assets00SelectEd01(assetId);
        vSymb = this.SymbService.SymbSelect02(asset.getSymb_id());
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("CLM1_SYMB", vSymb);
    model.addAttribute("CLM0", asset);

    AssetsEdKoina01(model, redirectUrl);

    return "assets00Ed01";
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_ED01_POST01)
  public String Assets00Post01(@RequestParam(name = "asset", required = false) Long assetId,
          @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
          @ModelAttribute("CLM0") Assets00Rec02 asset01, Model model, HttpServletRequest request) throws CatException
  {
    Assets00Rec02 assetsReturned = null;
    Symb vSymb = null;
    try
    {
      OpswLoginVars logvars = new OpswLoginVars();
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, logvars);
      assetsReturned = this.Assets00Service.Assets00PostEd01(assetId, asset01, logvars);
      vSymb = this.SymbService.SymbSelect02(assetsReturned.getSymb_id());
    }
    catch (CatExceptionUser ex)
    {
      CatException.ErrorAddParameter(ex, "errorMessage", ex.getTechMessage());
      ex.setRedirectToError(false);
      ex.setRedirectPath(OpswWebConst.OPSW_CONTROLLER_ASSETS00 + OpswWebConst.OPSW_CONTROLLER_ASSETS00_ED01
              + "?asset=" + OpswStringUtils.OpswLongToString(assetId));
      CatException.RethrowCatException(ex);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("CLM1_SYMB", vSymb);
    model.addAttribute("CLM0", assetsReturned);

    AssetsEdKoina01(model, redirectUrl);

    return "assets00Ed01";
  }

  private void AssetsEdKoina01(Model model, String redirectUrl) throws CatException
  {
    try
    {
      model.addAttribute("params1RedirectUrl", OpswUrlUtils.UrlEncoding(redirectUrl));
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_FILLFROMCRM)
  public String Assets00FillFromCRM(@RequestParam(name = "asset", required = true) Long assetId,
          @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
          Model model, HttpServletRequest request)
          throws CatException
  {
    Assets00Rec02 assetReturned = null;
    Symb vSymb = null;
    try
    {
      OpswLoginVars logvars = new OpswLoginVars();
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, logvars);
      LcOpswAssetsApi apiCalls = this.opswAssetApi;

      assetReturned = apiCalls.InternalCRMCall(assetId, logvars);
      vSymb = this.SymbService.SymbSelect02(assetReturned.getSymb_id());
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("symb", vSymb);
    model.addAttribute("CLM0", assetReturned);

    AssetsEdKoina01(model, redirectUrl);

    return "assets00Ed01";
  }

  @RolesAllowed(value =
  {
    OpswRolesAllowed.UCI_ADMIN
  })
  @GetMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_DELETE01)
  public String Assets00Delete01(@PathVariable("asset") Long assetId) throws CatException
  {
    try
    {
      this.Assets00Service.Assets00DeleteAll(assetId);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "redirect:" + OpswWebConst.OPSW_CONTROLLER_ASSETS00 + OpswWebConst.OPSW_CONTROLLER_ASSETS00_LIST01;
  }

}
