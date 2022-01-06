/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.Iterator;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

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
    } catch (Exception ex)
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

    } catch (Exception ex)
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
    } catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

}
