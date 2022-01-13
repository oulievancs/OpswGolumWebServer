/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.Iterator;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author oulis
 */
public class LcGramAssetsExcel01 extends LcGramAssetsExcelBase
{

  private Gram00 gram00;
  private List<Gram01> gram01List;

  public LcGramAssetsExcel01()
  {
    super();
    this.gram00 = null;
    this.gram01List = null;
  }

  @Override
  protected void NextRow(Row row) throws CatException
  {
    try
    {
      Iterator<Cell> cellIterator = row.cellIterator();

      int j = 0;
      while (cellIterator.hasNext())
      {
        Cell vcell = cellIterator.next();
        OnEachCell(j++, vcell.getColumnIndex(), vcell);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  /**
   *
   * @param columnOrig: Ξεκινάει από το 0.
   */
  private void OnEachCell(int columnOrig, int column, Cell cell) throws CatException
  {
    try
    {
      KoinaGram00(this.gram);

      Gram01 vgram01 = Gram01FindWithSenu(column);

      if (vgram01 != null)
      {
        Assets00InvokeByField(vgram01, cell);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void KoinaGram00(long gram) throws CatException
  {
    try
    {
      if (this.gram00 == null)
      {
        this.gram00 = this.Gram00Service.Gram00Select01(gram);

        if (this.gram00 == null)
        {
          throw new CatException(CatException.CODE_DBREC_NOT_FOUND,
                  "Δεν βρέθηκε η γραμμογράφηση [Gram = " + this.gram + "]!");
        }
        this.gram01List = this.Gram01Service.Gram01List01(this.gram);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private Gram01 Gram01FindWithSenu(long senu) throws CatException
  {
    Gram01 gram01 = null;
    try
    {
      for (long i = 0; i < this.gram01List.size(); i++)
      {
        if (senu == this.gram01List.get((int) i).getExcel_index())
        {
          gram01 = this.gram01List.get((int) i);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return gram01;
  }

  @Override
  protected void SelectSheetAndDo(XSSFWorkbook workbook) throws CatException
  {
    try
    {
      if (workbook.getNumberOfSheets() < 1)
      {
        throw new CatExceptionUser("Στο αρχείο δεν βρέθηκαν καρτέλες!");
      }

      for (int i = 0; i < workbook.getNumberOfSheets(); i++)
      {
        this.GetSheetAt(i);

        this.ReadSheet();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  protected short GetIndexOfFirstLine() throws CatException
  {
    short result = 0;
    try
    {
      KoinaGram00(this.gram);

      if (this.gram00 != null && this.gram00.getStart_line() != null)
      {
        result = this.gram00.getStart_line();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return result;
  }

}
