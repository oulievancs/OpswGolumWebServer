/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00SearchParams01;
import opsw.uci.prj.records.cat.CatThmlfAssets00List01Params;
import opsw.uci.prj.records.cat.CatThmlfObjectDates01;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

  @Autowired
  private SymbService SymbService;

  @GetMapping("/assets00/list01")
  public String Assets00List01(/*@RequestParam(name = "dateFrom", required = false) String dateFrom,
          @RequestParam(name = "dateTo", required = false) String dateTo,*/
          @ModelAttribute(name = "params") CatThmlfAssets00List01Params iparams,
          Model model)
          throws Exception
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

  @PostMapping("/assets00/list01")
  public String Assets00List01Post(/*@RequestParam(name = "dateFrom", required = false) String dateFrom,
          @RequestParam(name = "dateTo", required = false) String dateTo,*/
          @ModelAttribute(name = "params") CatThmlfAssets00List01Params iparams,
          Model model)
          throws Exception
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
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
//OpswEjbContext.setCurrentTenant(null);
//      KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
//              .getAuthentication();
//      OpswLogger.LoggerLogDebug("Token " + authentication.getAccount().getKeycloakSecurityContext().getToken().getAccessTokenHash());
