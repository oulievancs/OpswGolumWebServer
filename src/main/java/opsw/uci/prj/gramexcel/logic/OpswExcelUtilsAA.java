/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.Date;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.records.cat.CatThmlfAssets00List01Params;
import opsw.uci.prj.records.cat.CatThmlfObjectDates01;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswDateUtils;

/**
 *
 * @author n.oulis
 */
public class OpswExcelUtilsAA
{
  private Assets00Service assets00Service;
  private SymbService symbService;
  private Gram01Service gram01Service;

  public OpswExcelUtilsAA(Assets00Service assets00Service, SymbService symbService, Gram01Service gram01Service)
  {
    this.assets00Service = assets00Service;
    this.symbService = symbService;
    this.gram01Service = gram01Service;
  }
  
  
  public byte[] ExportExcelFile(CatThmlfAssets00List01Params iparams) throws CatException
  {
    byte[] result = null;
    try
    {
      LcGramAssetsExcelBase excelUnit = new LcGramAssetsExportExcel();
      excelUnit.setAssetets00Service(this.assets00Service);
      excelUnit.setSymbService(this.symbService);
      excelUnit.setGram01Service(this.gram01Service);
      if (iparams != null && iparams.getSearchDates() != null)
      {
        ((LcGramAssetsExportExcel) excelUnit).setDateFrom(OpswDateUtils.DateToCalendarElseNow(iparams.getSearchDates().getDateFrom()));
        ((LcGramAssetsExportExcel) excelUnit).setDateTo(OpswDateUtils.DateToCalendarElseNow(iparams.getSearchDates().getDateTo()));
        ((LcGramAssetsExportExcel) excelUnit).setSymb_id(iparams.getSymb_id());
      }

      result = excelUnit.ExportExcel();
    }
    catch(Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }
}
