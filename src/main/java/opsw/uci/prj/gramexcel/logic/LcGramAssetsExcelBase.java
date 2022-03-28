/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Assets00fl;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Gram00Rec02;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.OpswconstvService;
import opsw.uci.prj.services.SequencesService;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswArrayUtils;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
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

  protected OpswconstvService OpswconstvService;

  protected long gram;

  private byte[] file;

  private OpswLoginVars logivars;

  private ByteArrayOutputStream baos;

  //Create Workbook instance holding reference to .xlsx file
  private XSSFWorkbook FXssfworkbook;

  //Get first/desired sheet from the workbook
  private XSSFSheet FXssfsheet;

  protected boolean isToSetInternalKey;

  protected String hartofolakio;

  private Gram00Rec02 gram00Rec02;

  protected SequencesService SequencesService;

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
    this.OpswconstvService = null;
    this.Gram01Service = null;
    this.Gram00Service = null;
    this.Assetets00Service = null;
    this.isToSetInternalKey = false;
    this.hartofolakio = null;
    //
    this.gram00Rec02 = null;
    this.SequencesService = null;
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

  public OpswconstvService getOpswconstvService()
  {
    return OpswconstvService;
  }

  public void setOpswconstvService(OpswconstvService OpswconstvService)
  {
    this.OpswconstvService = OpswconstvService;
  }

  public SequencesService getSequencesService()
  {
    return SequencesService;
  }

  public void setSequencesService(SequencesService SequencesService)
  {
    this.SequencesService = SequencesService;
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

  protected static interface OpswGramAssetsCell
  {

    public String getStringCellValue();

    public double getNumericCellValue();

    public CellStyle getCellStyle();

    public CellType getCellType();

    public Date getDateCellValue();

    public Cell getCell();

    public int getColumnIndex();

    public int getRowIndex();
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
        this.isToSetInternalKey = false;

        vrow = rowIterator.next();

        if (idx >= this.GetIndexOfFirstLine())
        {
          //Prepare Assets00//
          this.assets00 = new Assets00();
          this.assets00.setUser_modify(this.logivars.getLoginUser());
          this.assets00.setDate_modify(Calendar.getInstance());
          //
          params.setExcelRow(vrow);
          this.NextRow(params);
          //

          if (OpswNumberUtils.OpswGetLong(this.assets00.getAauci()) < 1)
          {
            this.assets00.setAauci(
                    this.SequencesService.SequencesGetNextVal(Sequences.SEQ_AAUCI)
            );
          }

          if (this.isToSetInternalKey)
          {
            String vinternalKey = null;

            vinternalKey = this.AssetsInternlKeyComp(this.assets00);
            OpswReflection.SetFieldValue(this.assets00, Opswconstsv.FIELD_ASSETS_VALUE_INTRNLKEY.toLowerCase(), vinternalKey);
          }
          /*prepei edo na kanoyme select me to internal_key gia na doyme an
          * yparxei kai an yparxei na mhn kanoyme post
          */ 
          Assets00 tmpAsset = this.Assetets00Service.Assets00Select01(this.assets00.getIntrnlkey());
          boolean isFound = false;
          if(tmpAsset != null)
          {
            isFound = true;
          }
          this.Assetets00Service.Assets00Post03(this.assets00, true, !isFound);
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
          short ifieldType, OpswGramAssetsCell cell)
          throws CatException
  {
    try
    {
      boolean vfiledIsFld = false;

      Assets00fl vassetfl = null;
      Opswconstsv vopswConst
              = this.OpswconstvService.OpswconstvSelect02(Opswconstsv.ASSETS00_FLDS, ifieldName.toUpperCase());

      if (vopswConst != null)
      {
        vfiledIsFld = true;
        vassetfl = new Assets00fl();
        vassetfl.setFld(ifieldName.toUpperCase());
      }

      //Logic Pedia
      if (ifieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_INTRNLKEY) && cell.getColumnIndex() == -1)
      {
        this.isToSetInternalKey = true;
      }
      else if (ifieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_SYMB_NAME)
              && OpswNumberUtils.OpswGetLong(this.assets00.getSymb_id()) < 1)
      {        
        String vnamee = cell.getStringCellValue();
        Symb vsymb = this.Assets00InvokeSymbByNameOrTel(vnamee, null);

        if (vsymb != null)
        {
          this.assets00.setSymb_id(vsymb.getId());
        }
        else if (vnamee != null && !OpswStringUtils.OpswStringIsEmpty(vnamee))
        {
          if (this.assets00.getSymb() == null)
          {
            this.assets00.setSymb(this.SymbNewInstance());
          }

          this.assets00.getSymb().setName(vnamee);
        }
      }
      else if (ifieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_SYMB_TEL)
              && OpswNumberUtils.OpswGetLong(this.assets00.getSymb_id()) < 1)
      {
        String vtelaa = cell.getCell().getStringCellValue();
        Symb vsymb = this.Assets00InvokeSymbByNameOrTel(null, vtelaa);

        if (vsymb != null)
        {
          this.assets00.setSymb_id(vsymb.getId());
        }
        else if (vtelaa != null && !OpswStringUtils.OpswStringIsEmpty(vtelaa))
        {
          if (this.assets00.getSymb() == null)
          {
            this.assets00.setSymb(this.SymbNewInstance());
          }

          this.assets00.getSymb().setTele(vtelaa);
        }
      }
      //****** OLA TA ALLA ********
      else if (ifieldType == Gram01.FIELD_TYPE_NUMBER)
      {
        double vnumFiled = this.GetCellContentAsDouble(cell);

        if (!vfiledIsFld)
        {
          OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vnumFiled);
        }
        else
        {
          vassetfl.setType(Assets00fl.ASSETS_FLD_NUMBER);
          vassetfl.setValnum(vnumFiled);
        }
      }
      else if (ifieldType == Gram01.FIELD_TYPE_STRING)
      {
        String vstrField = this.RetousarismaValueString(this.GetCellContentAsString(cell));

        if (!vfiledIsFld)
        {
          OpswReflection.SetFieldValueAppend(this.assets00, ifieldName.toLowerCase(), vstrField, " ");
        }
        else
        {
          vassetfl.setType(Assets00fl.ASSETS_FLD_STRING);
          vassetfl.setValstr(vstrField);
        }
      }
      else if (ifieldType == Gram01.FIELD_TYPE_CALENDAR)
      {
        if (OpswStringUtils.OpswStringIsEmpty(ifieldDateFormat))
        {
          throw new CatExceptionUser("Δεν έχει ορισθεί πρότυπο ημ/νίας. Παρακαλώ επιλέξτε!");
        }
        String vstrField = GetCellContentAsString(cell);
        
        Calendar vcal = OpswDateUtils.StrToDate(vstrField, ifieldDateFormat, false);
        OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vcal);
      }
      else if (ifieldType == Gram01.FIELD_TYPE_LONG)
      {
        Long vnumFiled = this.GetCellContentAsLong(cell);
        OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vnumFiled, true);
      }
      else if (ifieldType == Gram01.FIELD_TYPE_Y_OR_N)
      {
        byte vval = Assets00.FIELD_Y_OR_N_NO;
        String vfval = this.GetCellContentAsString(cell);

        if (vfval != null && vfval.trim().equalsIgnoreCase(Gram01.FIELD_Y_OR_N_YES) && vfval.trim().equalsIgnoreCase(Gram01.FIELD_Y_OR_N_Y))
        {
          vval = Assets00.FIELD_Y_OR_N_YES;
        }

        OpswReflection.SetFieldValue(this.assets00, ifieldName.toLowerCase(), vval);
      }

      if (vassetfl != null)
      {
        List<Assets00fl> vlist = this.assets00.getAssets00fl();

        if (vlist == null)
        {
          vlist = new ArrayList<>();
          this.assets00.setAssets00fl(vlist);
        }

        vlist.add(vassetfl);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private String RetousarismaValueString(String ival)
          throws CatException
  {
    String result = null;
    try
    {
      if (ival != null)
      {
        result = ival.trim();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  protected void Assets00InvokeByField(Gram01 gram01, OpswGramAssetsCell icc)
          throws CatException
  {
    String vmess = "";
    try
    {
      String vfieldName = gram01.getField_name();
      vmess = "Field = " + vfieldName + " ";
      vmess += "Line = " + icc.getRowIndex() + " ";

      this.Assets00InvokeByField_Internal(vfieldName, gram01.getDate_format(), gram01.getField_type(), icc);
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

  protected boolean ExcelCellIsString(OpswGramAssetsCell icell)
          throws CatException
  {
    boolean result = false;
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.STRING)
      {
        result = true;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  protected boolean ExcelCellIsNumberic(OpswGramAssetsCell icell)
          throws CatException
  {
    boolean result = false;
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.NUMERIC)
      {
        result = true;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  protected boolean ExcelCellIsDate(OpswGramAssetsCell icell)
          throws CatException
  {
    boolean result = false;
    try
    {
      CellType ct = icell.getCellType();
      try
      {
        if (ct == CellType.NUMERIC && DateUtil.isCellDateFormatted(icell.getCell()))
        {
          result = true;
        }
      }
      catch (Exception ex)
      {
        throw new CatException("Cell [" + icell.getColumnIndex() + "] " + ex.getMessage());
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return result;
  }

  protected String GetCellContentAsString(OpswGramAssetsCell icell)
          throws CatException
  {
    String result = null;
    try
    {
      if (this.ExcelCellIsString(icell))
      {
        result = icell.getStringCellValue();
      }
      else if (this.ExcelCellIsDate(icell))
      {
        Date vdate = icell.getDateCellValue();
        CellStyle vcs = icell.getCellStyle();

        if (vdate != null && vcs != null)
        {
          Calendar vcal = Calendar.getInstance();
          vcal.setTime(vdate);
          result = OpswDateUtils.DateToStr(vcal, vcs.getDataFormatString());
        }
      }
      else if (this.ExcelCellIsNumberic(icell))
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

  protected double GetCellContentAsDouble(OpswGramAssetsCell icell)
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

  protected long GetCellContentAsLong(OpswGramAssetsCell icell)
          throws CatException
  {
    long result = 0;
    try
    {
      CellType ct = icell.getCellType();

      if (ct == CellType.STRING)
      {
        result = OpswNumberUtils.OpswGetIntFromString(icell.getStringCellValue());
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
        this.NextRow(params);
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

  protected boolean ExcelRowIsEmpty(Row row)
          throws CatException
  {
    boolean isEmptyRow = true;
    try
    {
      for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++)
      {
        Cell vcell = row.getCell(cellNum);

        OpswGramAssetsCell vcc = this.GetOpswGramAssetCellFromCell(vcell);

        if (vcell != null)
        {
          boolean vcellIsNullOrEmpty = true;
          if (ExcelCellIsString(vcc) || ExcelCellIsDate(vcc))
          {
            String vval = GetCellContentAsString(vcc);
            vcellIsNullOrEmpty = OpswStringUtils.OpswStringIsEmpty(vval);
          }
          else if (ExcelCellIsNumberic(vcc))
          {
            //
          }
          boolean vcellIsBlank = vcell.getCellType() == CellType.BLANK;
          if (!vcellIsBlank && !vcellIsNullOrEmpty)
          {
            isEmptyRow = false;
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return isEmptyRow;
  }

  protected OpswGramAssetsCell GetOpswGramAssetCellFromCell(Cell icell)
          throws CatException
  {
    OpswGramAssetsCell vcc = null;
    try
    {
      vcc = new OpswGramAssetsCell()
      {
        @Override
        public String getStringCellValue()
        {
          return icell.getStringCellValue();
        }

        @Override
        public double getNumericCellValue()
        {
          return icell.getNumericCellValue();
        }

        @Override
        public CellStyle getCellStyle()
        {
          return icell.getCellStyle();
        }

        @Override
        public CellType getCellType()
        {
          return icell.getCellType();
        }

        @Override
        public Date getDateCellValue()
        {
          return icell.getDateCellValue();
        }

        @Override
        public Cell getCell()
        {
          return icell;
        }

        @Override
        public int getColumnIndex()
        {
          return icell.getColumnIndex();
        }

        @Override
        public int getRowIndex()
        {
          return icell.getRowIndex();
        }
      };
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcc;
  }
  
  private Symb SymbNewInstance() throws CatException
  {
    Symb vsymb = null;
    try
    {
      vsymb = new Symb();
      vsymb.setDate_modify(Calendar.getInstance());
      vsymb.setUser_create(this.logivars.getLoginUser());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vsymb;
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

  /**
   * Επιστρέφει το internal key όπως προκύπτει από την επεξεργασία της
   * υλοποίησης.
   *
   * @param assets00
   * @return
   * @throws CatException
   */
  protected String AssetsInternlKeyComp(Assets00 assets00) throws CatException
  {
    return null;
  }

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
