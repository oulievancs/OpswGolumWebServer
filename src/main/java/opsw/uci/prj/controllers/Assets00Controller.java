/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.cat.CatThmlfObjectDates01;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.utils.OpswDateUtils;
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

  @GetMapping("/assets00/list01")
  public String Assets00List01(/*@RequestParam(name = "dateFrom", required = false) String dateFrom,
          @RequestParam(name = "dateTo", required = false) String dateTo,*/
          @ModelAttribute(name = "searchDates") CatThmlfObjectDates01 idates,
          Model model)
          throws Exception
  {
    try
    {
      Assets00List01_Internal(model, idates);
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
          @ModelAttribute(name = "searchDates") CatThmlfObjectDates01 idates,
          Model model)
          throws Exception
  {
    try
    {
      Assets00List01_Internal(model, idates);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return "assets00List01";
  }

  private void Assets00List01_Internal(Model model, CatThmlfObjectDates01 iDates)
          throws CatException
  {
    List<Assets00Rec01> assets00List = null;

    try
    {
      Calendar vdateFrom = null;
      vdateFrom = OpswDateUtils.DateToCalendarElseNow(iDates.getDateFrom());
      /*if (!OpswStringUtils.OpswStringIsEmpty(dateFrom))
      {
        vdateFrom = OpswDateUtils.StrToDate(dateFrom, OpswDateUtils.OPSW_DATE_THYMLEAF_02);
      }
      else
      {
        vdateFrom = Calendar.getInstance();
      }*/

      Calendar vdateTo = null;
      vdateTo = OpswDateUtils.DateToCalendarElseNow(iDates.getDateTo());
      /*if (!OpswStringUtils.OpswStringIsEmpty(dateTo))
      {
        vdateTo = OpswDateUtils.StrToDate(dateTo, OpswDateUtils.OPSW_DATE_THYMLEAF_02);
      }
      else
      {
        vdateTo = Calendar.getInstance();
      }*/

      assets00List = this.Assets00Service.Assets00List02(vdateFrom, vdateTo);

      CatThmlfObjectDates01 vdates = new CatThmlfObjectDates01();
      iDates.setDateFrom(vdateFrom.getTime());
      iDates.setDateTo(vdateTo.getTime());

      model.addAttribute("CLM0", assets00List);
      model.addAttribute("searchDates", iDates);
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
