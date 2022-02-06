/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.cat.CatReflectObject01;
import opsw.uci.prj.repositories.SymbRepository;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswArrayUtils;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author oulis
 */
public abstract class LcGramAssetsExcelBase
{

  protected Assets00Service Assetets00Service;

  protected Gram00Service Gram00Service;

  protected Gram01Service Gram01Service;

  private Assets00 assets00;

  private SymbService SymbService;

  protected long gram;

  private byte[] file;

  private OpswLoginVars logivars;

  private ByteArrayOutputStream baos;

  //Create Workbook instance holding reference to .xlsx file
  private XSSFWorkbook FXssfworkbook;

  //Get first/desired sheet from the workbook
  private XSSFSheet FXssfsheet;

  public LcGramAssetsExcelBase()
  {
    super();
    this.file = null;
    this.baos = null;
    this.FXssfworkbook = null;
    this.FXssfsheet = null;
    this.gram = 0;
    this.assets00 = null;
    this.SymbService = null;
    this.logivars = null;
  }

  public byte[] getFile()
  {
    return file;
  }

  public void setFile(byte[] file)
  {
    this.file = file;
  }

  public long getGram()
  {
    return gram;
  }

  public void setGram(long gram)
  {
    this.gram = gram;
  }

  public OpswLoginVars getLogivars()
  {
    return logivars;
  }

  public void setLogivars(OpswLoginVars logivars)
  {
    this.logivars = logivars;
  }

  protected static class GramAssetsExcelPrms01
  {

    private Row excelRow;
    private boolean hasNextrow;

    public GramAssetsExcelPrms01()
    {
      this.excelRow = null;
      this.hasNextrow = false;
    }

    public Row getExcelRow()
    {
      return excelRow;
    }

    public void setExcelRow(Row excelRow)
    {
      this.excelRow = excelRow;
    }

    public boolean isHasNextrow()
    {
      return hasNextrow;
    }

    public void setHasNextrow(boolean hasNextrow)
    {
      this.hasNextrow = hasNextrow;
    }

  }

  public void ReadFileFromMultipart(MultipartFile ifile)
          throws CatException
  {
    try
    {
      this.file = (byte[]) ifile.getBytes();

      this.ReadArxeio();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void ReadArxeio() throws CatException
  {
    try
    {
      if (this.file == null)
      {
        throw new CatException(CatException.CODE_NULL_PRM, "Δεν δόθηκε παράμετρος filename!");
      }

      if (this.logivars == null)
      {
        throw new CatException(CatException.CODE_NULL_PRM, "Δεν δόθηκε loginvars!");
      }

      this.FXssfworkbook = new XSSFWorkbook(new ByteArrayInputStream(this.file));

      this.SelectSheetAndDo(this.FXssfworkbook);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void GetSheetAt(int sheetIndex) throws CatException
  {
    try
    {
      this.FXssfsheet = this.FXssfworkbook.getSheetAt(sheetIndex);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void ReadSheet() throws CatException
  {
    try
    {
      Iterator<Row> rowIterator = this.FXssfsheet.iterator();
      GramAssetsExcelPrms01 params = new GramAssetsExcelPrms01();
      int idx = 1;

      Row vrow = null;
      while (rowIterator.hasNext())
      {
        vrow = rowIterator.next();

        if (idx >= this.GetIndexOfFirstLine())
        {
          this.assets00 = new Assets00();
          this.assets00.setUser_modify(this.logivars.getLoginUser());
          this.assets00.setDate_modify(Calendar.getInstance());
          params.setExcelRow(vrow);
          this.NextRow(params);
          this.Assetets00Service.Assets00Post02(assets00, true);
        }

        idx++;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void CloseWorkbook() throws CatException
  {
    try
    {
      this.FXssfworkbook.close();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void Assets00InvokeByField_Internal(String ifieldName, String ifieldDateFormat,
          short ifieldType, Cell cell)
          throws CatException
  {
    try
    {
      //Logic Pedia
      if (ifieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_SYMB_NAME)
              && OpswNumberUtils.OpswGetLong(this.assets00.getSymb_id()) < 1)
      {
        String vnamee = cell.getStringCellValue();
        Symb vsymb = Assets00InvokeSymbByNameOrTel(vnamee, null);

        if (vsymb != null)
        {
          this.assets00.setSymb_id(vsymb.getId());
        }
        else if (vnamee != null && !OpswStringUtils.OpswStringIsEmpty(vnamee))
        {
          if (this.assets00.getSymb() == null)
          {
            this.assets00.setSymb(new Symb());
          }

          this.assets00.getSymb().setName(vnamee);
        }
      }
      else if (ifieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_SYMB_TEL)
              && OpswNumberUtils.OpswGetLong(this.assets00.getSymb_id()) < 1)
      {
        String vtelaa = cell.getStringCellValue();
        Symb vsymb = Assets00InvokeSymbByNameOrTel(null, vtelaa);

        if (vsymb != null)
        {
          this.assets00.setSymb_id(vsymb.getId());
        }
        else if (vtelaa != null && !OpswStringUtils.OpswStringIsEmpty(vtelaa))
        {
          if (this.assets00.getSymb() == null)
          {
            this.assets00.setSymb(new Symb());
          }

          this.assets00.getSymb().setTele(vtelaa);
        }
      }
      //****** OLA TA ALLA ********
      else if (ifieldType == Gram01.FIELD_TYPE_NUMBER)
      {
        double vnumFiled = GetCellContentAsDouble(cell);

        OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vnumFiled);
      }
      else if (ifieldType == Gram01.FIELD_TYPE_STRING)
      {
        String vstrField = cell.getStringCellValue();

        OpswReflection.SetFieldValueAppend(this.assets00, ifieldName.toLowerCase(), vstrField, " ");
      }
      else if (ifieldType == Gram01.FIELD_TYPE_CALENDAR)
      {
        if (OpswStringUtils.OpswStringIsEmpty(ifieldDateFormat))
        {
          throw new CatExceptionUser("Δεν έχει ορισθεί πρότυπο ημ/νίας. Παρακαλώ επιλέξτε!");
        }
        String vstrField = GetCellContentAsString(cell, ifieldDateFormat);
        Calendar vcal = OpswDateUtils.StrToDate(vstrField, ifieldDateFormat);

        OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vcal);
      }
      else if (ifieldType == Gram01.FIELD_TYPE_LONG)
      {
        long vnumFiled = GetCellContentAsLong(cell);

        OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vnumFiled);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void Assets00InvokeByField(Gram01 gram01, Cell cell)
          throws CatException
  {
    String vmess = "";
    try
    {
      String vfieldName = gram01.getField_name();
      vmess = "Field = " + vfieldName + " ";
      vmess += "Line = " + cell.getRowIndex() + " ";

      Assets00InvokeByField_Internal(vfieldName, gram01.getDate_format(), gram01.getField_type(), cell);
    }
    catch (CatException ex)
    {
      String vtexchMes
              = (ex.getMessage() != null ? ex.getMessage() : "")
              + " " + (ex.getTechMessage() != null ? ex.getTechMessage() : "")
              + " " + vmess;
      ex.setTechMessage(vtexchMes);
      CatException.RethrowCatException(ex);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void CellValidationByType(Cell icell)
          throws CatException
  {
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.ERROR || ct == CellType.BOOLEAN
              || ct == CellType.FORMULA || ct == CellType._NONE)
      {
        throw new CatExceptionUser("Δεν υποστηρίζεται ο τύπος του κελιού "
                + "[Cords x: " + (icell.getRow().getRowNum() + 1) + ", y: "
                + "" + (icell.getColumnIndex() + 1) + "]!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected String GetCellContentAsString(Cell icell, String idateFormat)
          throws CatException
  {
    String result = null;
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.STRING)
      {
        result = icell.getStringCellValue();
      }
      else if (HSSFDateUtil.isCellDateFormatted(icell))
      {
        Date vdate = icell.getDateCellValue();
        if (vdate != null)
        {
          Calendar vcal = Calendar.getInstance();
          vcal.setTime(vdate);
          result = OpswDateUtils.DateToStr(vcal, icell.getCellStyle().getDataFormatString());
        }
      }
      else if (ct == CellType.NUMERIC)
      {
        result = OpswStringUtils.OpswDoubleToString(icell.getNumericCellValue());
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  protected double GetCellContentAsDouble(Cell icell)
          throws CatException
  {
    double result = 0;
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.STRING)
      {
        result = OpswNumberUtils.OpswGetDoubleFromString(icell.getStringCellValue());
      }
      else if (ct == CellType.NUMERIC)
      {
        result = icell.getNumericCellValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return result;
  }

  protected long GetCellContentAsLong(Cell icell)
          throws CatException
  {
    long result = 0;
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.STRING)
      {
        result = OpswNumberUtils.OpswGetLongFromString(icell.getStringCellValue());
      }
      else if (ct == CellType.NUMERIC)
      {
        result = (long) icell.getNumericCellValue();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return result;
  }

  private Symb Assets00InvokeSymbByNameOrTel(String nameOrSurename, String tel)
          throws CatException
  {
    Symb vsymaa = null;

    try
    {
      List<Symb> vsymbL = null;

      if (nameOrSurename != null)
      {
        String[] vnames = OpswStringUtils.OpswStringSePedia(nameOrSurename);

        if (vnames != null && vnames.length > 0)
        {
          vsymbL = this.SymbService.SymbList01(OpswStringUtils.OpswStringTrim(vnames[0]));

          if (vsymaa == null && OpswArrayUtils.OpswArrayContainsAtLeastOne(vsymbL))
          {
            vsymaa = vsymbL.get(0);
          }

          if (vsymaa == null && vnames.length > 1)
          {
            vsymbL = this.SymbService.SymbList01(OpswStringUtils.OpswStringTrim(vnames[1]));
          }

          if (vsymaa == null && OpswArrayUtils.OpswArrayContainsAtLeastOne(vsymbL))
          {
            vsymaa = vsymbL.get(0);
          }

          if (vsymaa == null && vnames.length > 2)
          {
            vsymbL = this.SymbService.SymbList01(OpswStringUtils.OpswStringTrim(vnames[2]));
          }

          if (vsymaa == null && OpswArrayUtils.OpswArrayContainsAtLeastOne(vsymbL))
          {
            vsymaa = vsymbL.get(0);
          }
        }
      }

      List<Symb> vsymbL01 = null;
      if (tel != null)
      {
        Symb vsymbb = null;

        vsymbL01 = this.SymbService.SymbList01(OpswStringUtils.OpswStringTrim(tel));

        if (vsymbL01 != null)
        {
          vsymbb = vsymbL01.get(0);
        }

        if (vsymbb != null)
        {
          if (!vsymbb.equals(vsymaa) && vsymbL != null && vsymbL.size() > 1)
          {
            for (Symb ss : vsymbL)
            {
              if (ss.equals(vsymbb))
              {
                vsymaa = ss;

                break;
              }
            }
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vsymaa;
  }

  private void createWorbook() throws CatException
  {
    try
    {
      this.FXssfworkbook = new XSSFWorkbook();
      this.FXssfsheet = this.FXssfworkbook.createSheet("Assets00");
      this.FXssfworkbook.setActiveSheet(0);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
  }

  private Row fillRow(Assets00Rec01 rec, int rowNum) throws CatException
  {
    Row row = null;
    try
    {
      row = this.FXssfsheet.createRow(rowNum);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return row;
  }

  public byte[] ExportExcel() throws CatException
  {
    byte[] results = null;
    GramAssetsExcelPrms01 params = new GramAssetsExcelPrms01();
    try
    {
      int rowCounter = 0;
      this.createWorbook();
      SelectSheetAndDo(this.FXssfworkbook);
      params.setHasNextrow(true);
      while (params.isHasNextrow())
      {
        params.setExcelRow(this.FXssfsheet.createRow(rowCounter));
        NextRow(params);
        rowCounter++;
      }
      this.baos = new ByteArrayOutputStream();
      this.FXssfworkbook.write(this.baos);
      results = this.baos.toByteArray();
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return results;
  }

  /**
   * Καλείται στην κάθε γραμμή του Excel δίντας ένα αντικείμενο ROW.
   *
   * @param row
   * @throws CatException
   */
  protected abstract void NextRow(GramAssetsExcelPrms01 params) throws CatException;

  /**
   * καλείται αφού διαβαστεί το αρχείο και επιλέγει το/τα sheets που θα
   * διαβάσει.
   *
   * @param workbook
   * @throws CatException
   */
  protected abstract void SelectSheetAndDo(XSSFWorkbook workbook) throws CatException;

  /**
   * Επιστρέφει τον αριθμό της πρώτης γραμμής που πρέπει να διαβάσει.
   *
   * @return
   * @throws CatException
   */
  protected abstract short GetIndexOfFirstLine() throws CatException;

  public Assets00Service getAssetets00Service()
  {
    return Assetets00Service;
  }

  public void setAssetets00Service(Assets00Service Assetets00Service)
  {
    this.Assetets00Service = Assetets00Service;
  }

  public Gram00Service getGram00Service()
  {
    return Gram00Service;
  }

  public void setGram00Service(Gram00Service Gram00Service)
  {
    this.Gram00Service = Gram00Service;
  }

  public Gram01Service getGram01Service()
  {
    return Gram01Service;
  }

  public void setGram01Service(Gram01Service Gram01Service)
  {
    this.Gram01Service = Gram01Service;
  }

  public SymbService getSymbService()
  {
    return SymbService;
  }

  public void setSymbService(SymbService SymbService)
  {
    this.SymbService = SymbService;
  }
}
