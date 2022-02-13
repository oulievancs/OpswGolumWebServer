/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.gramexcel.logic;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import opsw.uci.prj.arifacts.OpswTransactional;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.records.Gram00Rec02;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author oulis
 */
@Component
@Service
public class LcGramAssetsExcel01 extends LcGramAssetsExcelBase
{

  private static final String ASSETSFIELD_DATE_STR_FORMAT = "ddMMyyyy";

  private Gram00Rec02 gram00Rec02;
  private List<Gram01> gram01List;

  public LcGramAssetsExcel01()
  {
    super();
    this.gram00Rec02 = null;
    this.gram01List = null;
  }

  @OpswTransactional
  public void ReadFileFromMultipartAndImport(MultipartFile ifile)
          throws CatException
  {
    try
    {
      this.ReadFileFromMultipart(ifile);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  protected void NextRow(GramAssetsExcelPrms01 params) throws CatException
  {
    try
    {
      if (!this.ExcelRowIsEmpty(params.getExcelRow()))
      {
        int vrowIndex = params.getExcelRow().getRowNum();
        Iterator<Cell> cellIterator = params.getExcelRow().cellIterator();

        int j = 0;
        while (cellIterator.hasNext())
        {
          Cell vcell = cellIterator.next();
          this.OnEachCell(j++, vcell.getColumnIndex(), vcell);
        }

        List<Gram01> vgram01 = this.gram01List;

        if (vgram01 != null)
        {
          this.DoCustomFields(vgram01, vrowIndex);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private OpswGramAssetsCell GetOpswGramAssetCellFromGram01(Gram01 igram01, int irowIndex)
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
          return igram01.getValue_str();
        }

        @Override
        public double getNumericCellValue()
        {
          return igram01.getValue_num();
        }

        @Override
        public CellStyle getCellStyle()
        {
          return null;
        }

        @Override
        public CellType getCellType()
        {
          CellType ct = null;

          if (igram01.getField_type() == Gram01.FIELD_TYPE_LONG || igram01.getField_type() == Gram01.FIELD_TYPE_NUMBER)
          {
            ct = CellType.NUMERIC;
          }
          else if (igram01.getField_type() == Gram01.FIELD_TYPE_STRING || igram01.getField_type() == Gram01.FIELD_TYPE_Y_OR_N)
          {
            ct = CellType.STRING;
          }
          else if (igram01.getField_type() == Gram01.FIELD_TYPE_CALENDAR)
          {
            ct = null;
          }

          return ct;
        }

        @Override
        public Date getDateCellValue()
        {
          return null;
        }

        @Override
        public Cell getCell()
        {
          return null;
        }

        @Override
        public int getColumnIndex()
        {
          return igram01.getExcel_index();
        }

        @Override
        public int getRowIndex()
        {
          return irowIndex;
        }
      };
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vcc;
  }

  private void DoCustomFields(List<Gram01> igram01List, int irowIndex)
          throws CatException
  {
    try
    {
      if (igram01List != null && !igram01List.isEmpty())
      {
        OpswGramAssetsCell vcc = null;
        for (Gram01 vgram : igram01List)
        {
          boolean vgoon = true;

          vgoon &= vgram.getExcel_index() == Gram01.GRAM01_FIELD_IS_NOT_EXCEL_FIELD;

          if (vgoon)
          {
            vcc = this.GetOpswGramAssetCellFromGram01(vgram, irowIndex);

            this.Assets00InvokeByField(vgram, vcc);
          }
        }
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
      this.KoinaGram00(this.gram);

      Gram01 vgram01 = this.Gram01FindWithSenu(column);

      if (vgram01 != null)
      {

        OpswGramAssetsCell vcc = this.GetOpswGramAssetCellFromCell(cell);
        this.Assets00InvokeByField(vgram01, vcc);
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
      if (this.gram00Rec02 == null)
      {
        this.gram00Rec02 = this.Gram00Service.Gram00Rec02Select01(gram);

        if (this.gram00Rec02 == null)
        {
          throw new CatException(CatException.CODE_DBREC_NOT_FOUND,
                  "Δεν βρέθηκε η γραμμογράφηση [Gram = " + this.gram + "]!");
        }
        this.gram01List = this.Gram01Service.Gram01List02(this.gram);
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

      if (this.gram00Rec02 != null && this.gram00Rec02.getStart_line() != null)
      {
        result = this.gram00Rec02.getStart_line();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return result;
  }

  @Override
  protected String AssetsInternlKeyComp(Assets00 assets00) throws CatException
  {
    String res = null;
    try
    {
      this.KoinaGram00(this.gram);

      List<String> viternalKey = null;
      viternalKey = this.gram00Rec02.getInternalKeyFlds();

      if (viternalKey != null && !viternalKey.isEmpty())
      {
        for (String fld : viternalKey)
        {
          if (fld != null)
          {
            if (fld.equalsIgnoreCase(Gram00.GRAM00_INTERNALKEY_AAUCI))
            {
              long vaausci = OpswNumberUtils.OpswGetLong(assets00.getAauci());

              if (vaausci < 1)
              {
                throw new CatException("Δεν έχει ανατεθεί το aauci!");
              }

              res = this.InternalKeyAdd01(res, OpswStringUtils.OpswLongToString(vaausci));
            }
            else if (fld.equalsIgnoreCase(Gram00.GRAM00_INTERNALKEY_ASSFILE))
            {
              res = this.InternalKeyAdd01(res, OpswDateUtils.DateToStr(
                      assets00.getAssfile(), ASSETSFIELD_DATE_STR_FORMAT)
              );
            }
            else if (fld.equalsIgnoreCase(Gram00.GRAM00_INTERNALKEY_UNIQCODE))
            {
              res = this.InternalKeyAdd01(res, assets00.getUniqcode());
            }
            //DOV -> DOVALUE CODE PART.
            else
            {
              res = this.InternalKeyAdd01(res, fld.toUpperCase());
            }
          }
        }
      }
      else
      {
        if (assets00.getAauci() != null)
        {
          res = this.InternalKeyAdd01(res, OpswStringUtils.OpswLongToString(assets00.getAauci()));
        }

        if (this.hartofolakio != null)
        {
          res = this.InternalKeyAdd01(res, this.hartofolakio);
        }

        if (assets00.getAssfile() != null)
        {
          res = this.InternalKeyAdd01(res, OpswDateUtils.DateToStr(
                  assets00.getAssfile(), ASSETSFIELD_DATE_STR_FORMAT)
          );
        }

        if (assets00.getUniqcode() != null)
        {
          res = this.InternalKeyAdd01(res, assets00.getUniqcode());
        }
      }

      if (OpswStringUtils.OpswStringIsEmpty(res))
      {
        throw new CatExceptionUser("Δεν μπόρεσε να δημιουργηθεί ο εσωτερικό κωδικός!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  private String InternalKeyAdd01(String add1, String add2) throws CatException
  {
    String res = null;
    try
    {
      res = add1;
      if (res == null)
      {
        res = add2;
      }
      else
      {
        res += "_" + add2;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

}
