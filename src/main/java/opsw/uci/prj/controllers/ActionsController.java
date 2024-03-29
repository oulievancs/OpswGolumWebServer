/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.gramexcel.logic.OpswExcelUtilsAA;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.cat.CatThmlfAssets00List01Params;
import opsw.uci.prj.records.cat.CatThmlfAssets00List02Params;
import opsw.uci.prj.records.cat.CatThmlfObjectDates01;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author n.oulis
 */
@Controller
//@RolesAllowed( value =
//{
//  "uci-user"
//})
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_ACTIONS)
public class ActionsController
{

  @Autowired
  private Gram00Service Gram00Service;

  @Autowired
  private SymbService SymbService;

  @Autowired
  private OpswExcelUtilsAA ExcelUtilsService;

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_ACTIONS_INPORT_FILE)
  public String importFileForm(Model model) throws CatException
  {
    try
    {
      //OpswE*jbContext.se*tCur*rentTena*nt(null);
      List<Gram00Rec01> gramList = this.Gram00Service.Gram00Rec01List01();
      Gram00Rec01 gramrec = new Gram00Rec01();
      model.addAttribute("gramList", gramList);
      model.addAttribute("gramRec", gramrec);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "inportForm";
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_ACTIONS_INPORT_FILE_POST)
  public String uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute("gramRec") Gram00Rec01 gramrec,
          RedirectAttributes attributes, HttpServletRequest request) throws CatException
  {
    OpswLoginVars vlogvar = new OpswLoginVars();
    try
    {
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, vlogvar);
      //check for file
      if (file.isEmpty())
      {
        throw new CatExceptionUser("Please select a file to upload.");
        //attributes.addFlashAttribute("message", "Please select a file to upload.");
      }
      else if (gramrec.getGram() == null || gramrec.getGram().equals(""))
      {
        throw new CatExceptionUser("Please select a gram.");
        //attributes.addFlashAttribute("message", "Please select a gram.");
      }
      else
      {
        this.ExcelUtilsService.ReadFileFromMultipartAndImport(file, gramrec, vlogvar);
        attributes.addFlashAttribute("message", "The file uploaded. " + this.ExcelUtilsService.getRows() + " records uploaded.");
      }
      attributes.addFlashAttribute("error", false);
    }
    catch (CatException ex)
    {
      ex.setRedirectToError(false);
      ex.setRedirectPath("actions/inportfile");
      CatException.ErrorAddErrorParameter(ex, new Boolean(true));
      CatException.ErrorAddErrorMessageParameter(ex, ex.getTechMessage());
      CatException.RethrowCatException(ex);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "redirect:" + OpswWebConst.OPSW_CONTROLLER_ACTIONS
            + OpswWebConst.OPSW_CONTROLLER_ACTIONS_INPORT_FILE;
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_ACTIONS_EXPORT_FILE_POST02)
  public String exportfile02(@ModelAttribute("params") CatThmlfAssets00List01Params iparams, Model model) throws CatException
  {
    CatThmlfAssets00List02Params returnParams = null;
    List<Gram00Rec01> gramList = null;
    List<Symb> symbList01 = null;
    try
    {
      gramList = this.Gram00Service.Gram00Rec01List01();
      symbList01 = this.SymbService.SymbList02();
      if (iparams != null)
      {
        returnParams = new CatThmlfAssets00List02Params();
        returnParams.setSearchDates(iparams.getSearchDates());
        returnParams.setSymb_id(iparams.getSymb_id());
      }
      model.addAttribute("CLM1", symbList01);
      model.addAttribute("gramList", gramList);
      model.addAttribute("paramsOb", returnParams);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }

    return "exportform";
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_ACTIONS_EXPORT_FILE)
  public String exportFile(Model model) throws CatException
  {
    CatThmlfAssets00List02Params params = null;
    List<Gram00Rec01> gramList = null;
    List<Symb> symbList01 = null;
    try
    {
      gramList = this.Gram00Service.Gram00Rec01List01();
      symbList01 = this.SymbService.SymbList02();
      params = new CatThmlfAssets00List02Params();
      CatThmlfObjectDates01 dates = new CatThmlfObjectDates01();
      Calendar today = Calendar.getInstance();
      dates.setDateFrom(today.getTime());
      dates.setDateTo(today.getTime());
      params.setSearchDates(dates);

      model.addAttribute("CLM1", symbList01);
      model.addAttribute("gramList", gramList);
      model.addAttribute("paramsOb", params);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }

    return "exportform";
  }

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_ACTIONS_EXPORT_FILE_POST)
  public ResponseEntity<byte[]> exportFilePost(@ModelAttribute("paramsOb") CatThmlfAssets00List02Params iparams) throws CatException
  {
    ResponseEntity<byte[]> result = null;
    try
    {
      byte[] excelFile = ExcelUtilsService.ExportExcelFile(iparams);
      result = ResponseEntity.ok()
              .header("Content-Disposition", "attachment; filename=assets_" + OpswDateUtils.DateToStr01(Calendar.getInstance()) + ".xlsx")
              .contentLength(excelFile.length)
              .contentType(MediaType.APPLICATION_OCTET_STREAM)
              .body(excelFile);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  /*@GetMapping("/testtab")
  public String TabTest(Model model) throws CatException
  {
    Assets00 asset = null;
    try
    {
      long id = 2005;
      asset = this.Assetets00Service.Assets00Select01(id);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    model.addAttribute("asset", asset);
    return "TestTabForm";
  }*/
}
