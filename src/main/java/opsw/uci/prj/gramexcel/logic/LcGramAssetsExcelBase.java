/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.repositories.SymbRepository;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import opsw.uci.prj.services.SymbService;
import opsw.uci.prj.utils.OpswArrayUtils;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.apache.poi.ss.usermodel.Cell;
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

      int idx = 1;
      while (rowIterator.hasNext())
      {
        if (idx >= this.GetIndexOfFirstLine())
        {
          this.assets00 = new Assets00();
          this.NextRow(rowIterator.next());
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

  protected void Assets00InvokeByField(Gram01 gram01, Cell cell)
          throws CatException
  {
    try
    {
      String vfieldName = gram01.getField_name();

      //Logic Pedia
      if (vfieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_SYMB_NAME)
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
      else if (vfieldName.toLowerCase().equalsIgnoreCase(Opswconstsv.FIELD_ASSETS_VALUE_SYMB_TEL)
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
      else if (gram01.getField_type() == Gram01.FIELD_TYPE_NUMBER)
      {
        double vnumFiled = cell.getNumericCellValue();

        OpswReflection.SetFieldValue(this.assets00, vfieldName.toLowerCase(), vnumFiled);
      }
      else if (gram01.getField_type() == Gram01.FIELD_TYPE_STRING)
      {
        String vstrField = cell.getStringCellValue();

        OpswReflection.SetFieldValue(this.assets00, vfieldName.toLowerCase(), vstrField);
      }
      else if (gram01.getField_type() == Gram01.FIELD_TYPE_CALENDAR)
      {
        if (OpswStringUtils.OpswStringIsEmpty(gram01.getDateFormat()))
        {
          throw new CatExceptionUser("Δεν έχει ορισθεί πρότυπο ημ/νίας. Παρακαλώ επιλέξτε!");
        }
        String vstrField = cell.getStringCellValue();
        Calendar vcal = OpswDateUtils.StrToDate(vstrField, gram01.getDateFormat());

        OpswReflection.SetFieldValue(this.assets00, vfieldName.toLowerCase(), vcal);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
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

  /**
   * Καλείται στην κάθε γραμμή του Excel δίντας ένα αντικείμενο ROW.
   *
   * @param row
   * @throws CatException
   */
  protected abstract void NextRow(Row row) throws CatException;

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
