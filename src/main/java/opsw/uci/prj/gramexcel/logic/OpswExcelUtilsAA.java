/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.Date;
import opsw.uci.prj.arifacts.OpswTransactional;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.cat.CatThmlfAssets00List01Params;
import opsw.uci.prj.records.cat.CatThmlfAssets00List02Params;
import opsw.uci.prj.records.cat.CatThmlfObjectDates01;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.OpswconstvService;
import opsw.uci.prj.services.SequencesService;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author n.oulis
 */
@Component
@Service
public class OpswExcelUtilsAA
{

  @Autowired
  private Assets00Service assets00Service;
  @Autowired
  private Gram00Service gram00Service;
  @Autowired
  private SymbService symbService;
  @Autowired
  private Gram01Service gram01Service;
  @Autowired
  private OpswconstvService opswconstvService;
  @Autowired
  private SequencesService SequencesService;
  
  private Integer Rows;

    public Integer getRows() {
        return Rows;
    }

    public void setRows(Integer Rows) {
        this.Rows = Rows;
    }
  
  

  public byte[] ExportExcelFile(CatThmlfAssets00List02Params iparams) throws CatException
  {
    byte[] result = null;
    try
    {
      LcGramAssetsExcelBase excelUnit = new LcGramAssetsExportExcel();
      excelUnit.setAssetets00Service(this.assets00Service);
      excelUnit.setSymbService(this.symbService);
      excelUnit.setGram01Service(this.gram01Service);
      excelUnit.setOpswconstvService(this.opswconstvService);

      if (iparams != null && iparams.getSearchDates() != null)
      {
        ((LcGramAssetsExportExcel) excelUnit).setDateFrom(OpswDateUtils.DateToCalendarElseNow(iparams.getSearchDates().getDateFrom()));
        ((LcGramAssetsExportExcel) excelUnit).setDateTo(OpswDateUtils.DateToCalendarElseNow(iparams.getSearchDates().getDateTo()));
        ((LcGramAssetsExportExcel) excelUnit).setSymb_id(iparams.getSymb_id());
        excelUnit.setGram(iparams.getGram00());
      }

      result = excelUnit.ExportExcel();
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  @OpswTransactional
  public void ReadFileFromMultipartAndImport(MultipartFile file, Gram00Rec01 gramrec, OpswLoginVars ilogvar)
          throws CatException
  {
    try
    {
      LcGramAssetsExcelBase excelUnit = new LcGramAssetsExcel01();
      excelUnit.setGram(gramrec.getGram());
      excelUnit.setAssetets00Service(this.assets00Service);
      excelUnit.setGram00Service(this.gram00Service);
      excelUnit.setGram01Service(this.gram01Service);
      excelUnit.setSymbService(this.symbService);
      excelUnit.setOpswconstvService(this.opswconstvService);
      excelUnit.setSequencesService(this.SequencesService);
      excelUnit.setLogivars(ilogvar);

      ((LcGramAssetsExcel01) excelUnit).ReadFileFromMultipartAndImport(file);
      this.setRows(excelUnit.getRows());
      
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
