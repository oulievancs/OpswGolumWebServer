/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
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

      this.SelectSheetAndRead(this.FXssfworkbook);
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

      while (rowIterator.hasNext())
      {
        this.assets00 = new Assets00();
        this.NextRow(rowIterator.next());
        this.Assetets00Service.Assets00Post01(assets00);
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
      if (gram01.getField_type() == Gram01.FIELD_TYPE_NUMBER)
      {
        double vnumFiled = cell.getNumericCellValue();

        OpswReflection.SetFieldValue(this.assets00, vfieldName.toLowerCase(), vnumFiled);
      }
      else if (gram01.getField_type() == Gram01.FIELD_TYPE_STRING)
      {
        String vstrField = cell.getStringCellValue();

        OpswReflection.SetFieldValue(this.assets00, vfieldName.toLowerCase(), vstrField);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
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
  protected abstract void SelectSheetAndRead(XSSFWorkbook workbook) throws CatException;

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
}
