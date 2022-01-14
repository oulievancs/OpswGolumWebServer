/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import opsw.uci.prj.arifacts.OpswEjbContext;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.gramexcel.logic.LcGramAssetsExcel01;
import opsw.uci.prj.gramexcel.logic.LcGramAssetsExcelBase;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.SymbService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
//@RolesAllowed("uci-user")
@RequestMapping("/actions")
public class ActionsController
{

  @Autowired
  private Assets00Service Assetets00Service;

  @Autowired
  private Gram01Service Gram01Service;

  @Autowired
  private Gram00Service Gram00Service;

  @Autowired
  private SymbService SymbService;

  @GetMapping("/inportfile")
  public String importFileFomr(Model model) throws Exception
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

  @PostMapping("/inportfile/post")
  public String uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute("gramRec") Gram00Rec01 gramrec,
          RedirectAttributes attributes) throws Exception
  {
    try
    {
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
        LcGramAssetsExcelBase excelUnit = new LcGramAssetsExcel01();
        excelUnit.setGram(gramrec.getGram());
        excelUnit.setAssetets00Service(this.Assetets00Service);
        excelUnit.setGram00Service(this.Gram00Service);
        excelUnit.setGram01Service(this.Gram01Service);
        excelUnit.setSymbService(this.SymbService);

        excelUnit.ReadFileFromMultipart(file);
        attributes.addFlashAttribute("message", "The file uploaded.");
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
    return "redirect:/actions/inportfile";
  }
  
  @GetMapping("/exportfile")
  public String exportFile(Model model) throws Exception
  {
    return "exportform";
  }
  
  @PostMapping("/exportfile/post")
  public String exportFilePost(@ModelAttribute("dateFrom") String dateFrom, @ModelAttribute("dateTo") String dateTo) throws Exception
  {
    Logger logger = OpswLogger.getLogger();
    logger.debug(dateFrom);
    return "redirect:/actions/exportfile";
  }
}
