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
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.services.Gram01Service;
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

  @Autowired
  protected Assets00Service AssetetsService;
  
  @Autowired
  protected Gram00Service Gram00Service;
  
  @Autowired
  protected Gram01Service Gram01Service;
  
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
    } catch (Exception ex)
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
    } catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void GetSheetAt(int sheetIndex) throws CatException
  {
    try
    {
      this.FXssfsheet = this.FXssfworkbook.getSheetAt(sheetIndex);
    } catch (Exception ex)
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
        this.NextRow(rowIterator.next());
      }
    } catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  protected void CloseWorkbook() throws CatException
  {
    try
    {
      this.FXssfworkbook.close();
    } catch (Exception ex)
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
}
