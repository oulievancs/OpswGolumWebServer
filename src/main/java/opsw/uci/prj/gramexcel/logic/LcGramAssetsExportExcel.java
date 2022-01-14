/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.cat.CatReflectObject01;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.utils.OpswArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author n.oulis
 */
public class LcGramAssetsExportExcel extends LcGramAssetsExcelBase
{

  private List<Assets00Rec01> assets;
  private Calendar dateFrom;
  private Calendar dateTo;

  public LcGramAssetsExportExcel()
  {
    this.assets = null;
    this.dateFrom = null;
    this.dateTo = null;
  }

  public List<Assets00Rec01> getAssets()
  {
    return assets;
  }

  public void setAssets(List<Assets00Rec01> assets)
  {
    this.assets = assets;
  }

  public Calendar getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(Calendar dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  public Calendar getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(Calendar dateTo)
  {
    this.dateTo = dateTo;
  }

  public void findAssets() throws CatException
  {
    try
    {
      this.assets = this.Assetets00Service.Assets00List02(this.dateFrom, this.dateTo);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
  }

  @Override
  protected void NextRow(GramAssetsExcelPrms01 params) throws CatException
  {
    try
    {
      int cellCounter = 0;
      int currentRow = params.getExcelRow().getRowNum();
      if (currentRow == 0)
      {
        List<CatThmlfObject01> fields = this.Gram01Service.FieldsList01(Opswconstsv.ASSETS_VALUE);
        if (OpswArrayUtils.OpswArrayContainsAtLeastOne(fields))
        {
          for (CatThmlfObject01 ob1 : fields)
          {
            //List<CatReflectObject01> objectList = OpswReflection.ReflectObjectToObject01List(ob1);
            /*if (OpswArrayUtils.OpswArrayContainsAtLeastOne(objectList))
            {
              int cellCounter = 0;
              for (CatReflectObject01 ob2 : objectList)
              {
                Cell cell = params.getExcelRow().createCell(cellCounter);
                if (ob2.getFieldType().equals(String.class))
                {
                  cell.setCellFormula((String) ob2.getFieldValue());
                }
                cellCounter++;
              }
            }*/
            Cell cell = params.getExcelRow().createCell(cellCounter);
            cell.setCellValue(ob1.getDescr());
            cellCounter++;
          }
        }

      }
      else if (this.assets.size() >= currentRow)
      {
        List<CatReflectObject01> objectList = OpswReflection.ReflectObjectToObject01List(this.assets.get(currentRow));
        if (objectList != null && !objectList.isEmpty())
        {
          //int cellCounter = 0;
          for (CatReflectObject01 ob : objectList)
          {
            Cell cell = params.getExcelRow().createCell(cellCounter);
            if (ob.getFieldType().equals(String.class))
            {
              cell.setCellFormula((String) ob.getFieldValue());
            }
            if (ob.getFieldType().equals(Double.class) || ob.getFieldType().equals(Integer.class)
                    || ob.getFieldType().equals(Long.class))
            {
              cell.setCellValue((double) ob.getFieldValue());
            }
            if (ob.getFieldType().equals(Calendar.class))
            {
              cell.setCellValue((Calendar) ob.getFieldValue());
            }
            cellCounter++;
          }
        }
      }
      params.setHasNextrow(this.assets.size() > currentRow + 1);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
  }

  @Override
  protected void SelectSheetAndDo(XSSFWorkbook workbook) throws CatException
  {
    try
    {
      if (workbook.getNumberOfSheets() < 1)
      {
        throw new CatExceptionUser("Στο workBook δεν έχει δημιουργηθεί καρτέλα!");
      }
      this.findAssets();
    }
    catch (Exception e)
    {

    }
  }

  @Override
  protected short GetIndexOfFirstLine() throws CatException
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
