/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.importExport.OpswImportExport;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author oulis
 */
@Controller
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_IMPORT_EXPORT)
public class ImportExportController
{

  @Autowired
  private OpswImportExport OpswImportExport;

  @PostMapping(OpswWebConst.OPSW_CONTROLLER_IMPORT_EXPORT_IMPORT)
  public String importExportImport(@RequestParam("file") MultipartFile file, @RequestParam("redirect") String redirect,
          @PathVariable("file") String ifile, HttpServletRequest request) throws CatException
  {
    OpswLoginVars vlogvar = new OpswLoginVars();
    try
    {
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, vlogvar);

      this.OpswImportExport.ImportFromMultipart(file, ifile, vlogvar);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return "redirect:" + redirect;
  }

  @GetMapping(OpswWebConst.OPSW_CONTROLLER_IMPORT_EXPORT_EXPORT)
  public ResponseEntity<byte[]> importExportExport(Model model, @PathVariable("iid1") String iid1, @PathVariable("file") String ifile)
          throws CatException
  {
    ResponseEntity<byte[]> result = null;

    try
    {
      byte[] vfile = this.OpswImportExport.Export(ifile, iid1);
      String filename = "export_" + ifile + "_" + OpswDateUtils.DateToStr01(Calendar.getInstance());
      if (this.OpswImportExport.getFileName() != null && !this.OpswImportExport.getFileName().equals("") )
      {
        filename = this.OpswImportExport.getFileName();
      }
      
      result = ResponseEntity.ok()
              .header("Content-Disposition", "attachment; filename="
                      + filename + ".json")
              .contentLength(vfile.length)
              .contentType(MediaType.APPLICATION_OCTET_STREAM)
              .body(vfile);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return result;
  }
}
