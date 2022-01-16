/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00SearchParams01;
import opsw.uci.prj.records.cat.CatReflectObject01;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.utils.OpswArrayUtils;
import opsw.uci.prj.utils.OpswDateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author n.oulis
 */
public class LcGramAssetsExportExcel extends LcGramAssetsExcelBase
{

  private List<Assets00Rec01> assets;
  private List<CatThmlfObject01> fields;
  private Calendar dateFrom;
  private Calendar dateTo;
  private Long symb_id;

  public LcGramAssetsExportExcel()
  {
    this.assets = null;
    this.fields = null;
  }

  public List<Assets00Rec01> getAssets()
  {
    return assets;
  }

  public void setAssets(List<Assets00Rec01> assets)
  {
    this.assets = assets;
  }

  public List<CatThmlfObject01> getFields()
  {
    return fields;
  }

  public void setFields(List<CatThmlfObject01> fields)
  {
    this.fields = fields;
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

  public Long getSymb_id()
  {
    return symb_id;
  }

  public void setSymb_id(Long symb_id)
  {
    this.symb_id = symb_id;
  }
  

  public void findAssets() throws CatException
  {
    try
    {
      this.fields = this.Gram01Service.FieldsList01(Opswconstsv.ASSETS_VALUE);
      Assets00SearchParams01 assetsParams = new Assets00SearchParams01();
      assetsParams.setDateFrom(this.dateFrom);
      assetsParams.setDateTo(this.dateTo);
      assetsParams.setSymb_id(this.symb_id);
      this.assets = this.Assetets00Service.Assets00List03(assetsParams);
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
        if (OpswArrayUtils.OpswArrayContainsAtLeastOne(this.fields))
        {
          for (CatThmlfObject01 ob1 : fields)
          {
            Cell cell = params.getExcelRow().createCell(cellCounter);
            cell.setCellValue(ob1.getDescr());
            cellCounter++;
          }
        }

      }
      else if (this.assets.size() >= currentRow)
      {
        List<CatReflectObject01> objectList = OpswReflection.ReflectObjectToObject01List(this.assets.get(currentRow - 1));
        if (OpswArrayUtils.OpswArrayContainsAtLeastOne(this.fields))
        {
          for (CatThmlfObject01 ob1 : this.fields)
          {
            if (OpswArrayUtils.OpswArrayContainsAtLeastOne(objectList))
            {
              for (CatReflectObject01 ob : objectList)
              {
                if (ob1.getCode().equalsIgnoreCase(ob.getFieldName()))
                {
                  if (ob.getFieldValue() != null)
                  {
                    Cell cell = params.getExcelRow().createCell(cellCounter);
                    
                    if (ob.getFieldType() == String.class)
                    {
                      cell.setCellValue((String) ob.getFieldValue());
                    }
                    else if (ob.getFieldType() == Double.class)
                    {
                      cell.setCellValue((double) ob.getFieldValue());
                    }
                    else if (ob.getFieldType() == Integer.class)
                    {
                      cell.setCellValue((int) ob.getFieldValue());
                    }
                    else if (ob.getFieldType() == Long.class)
                    {
                      cell.setCellValue((long) ob.getFieldValue());
                    }
                    else if (ob.getFieldType() == Calendar.class)
                    {
                      cell.setCellValue(OpswDateUtils.DateToStr((Calendar) ob.getFieldValue(), "dd/MM/yyyy"));
                    }
                  }
                  
                  break;
                }
              }
              cellCounter++;
            }
          }
        }
      }
      params.setHasNextrow(this.assets.size() >= currentRow + 1);
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
      CatException.RethrowCatException(e);
    }
  }

  @Override
  protected short GetIndexOfFirstLine() throws CatException
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
