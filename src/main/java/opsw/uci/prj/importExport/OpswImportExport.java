/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.importExport;

import java.util.List;
import opsw.uci.prj.api.client.JsonReaderWriter;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.services.Gram00Service;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author oulis
 */
@Service
@Component
public class OpswImportExport
{
  private String FileName;
  
  public OpswImportExport()
  {
      this.FileName = null;
  }

  public String getFileName() {
      return FileName;
  }

  public void setFileName(String FileName) {
      this.FileName = FileName;
  }
  
  
  public static final String FILE_GRAM = "gram";
  
  private static final String IMPORT_EXPORT_DATE_TIME_FORMAT = OpswDateUtils.OPSW_DATE_TIME_DEFAULT_FORMAT;

  @Autowired
  private Gram00Service Gram00Service;

  public void ImportFromMultipart(MultipartFile file, String ifile, OpswLoginVars iloginVars)
          throws CatException
  {
    try
    {
      this.Import(file.getBytes(), ifile, iloginVars);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public void Import(byte[] file, String ifile, OpswLoginVars iloginVars) throws CatException
  {
    try
    {
      if (ifile != null && ifile.equals(FILE_GRAM))
      {
        this.ImportGramFile(file, iloginVars);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  public byte[] Export(String ifile, String iid1) throws CatException
  {
    byte[] vfile = null;
    try
    {
      if (ifile != null && ifile.equals(FILE_GRAM))
      {
        vfile = this.ExportGramFile(OpswNumberUtils.OpswGetLongFromString(iid1));
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vfile;
  }

  private byte[] ExportGramFile(Long gram00) throws CatException
  {
    byte[] vfile = null;
    try
    {
      Gram00 vgram00 = this.Gram00Service.Gram00Select02(gram00);
      this.FileName = vgram00.getDescr();
      
      JsonReaderWriter job = new JsonReaderWriter();
      job.setDateFormat(IMPORT_EXPORT_DATE_TIME_FORMAT);

      vfile = job.ObjectProcessToFile(vgram00, "UTF-8");
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vfile;
  }

  private void ImportGramFile(byte[] file, OpswLoginVars iloginVars) throws CatException
  {
    try
    {
      JsonReaderWriter job = new JsonReaderWriter();
      job.setDateFormat(IMPORT_EXPORT_DATE_TIME_FORMAT);

      Gram00 vgram00 = (Gram00) job.EntityProcess02(file, Gram00.class);

      this.GramImportPre(vgram00);

      vgram00 = this.Gram00Service.Gram00Gram00Post03(vgram00, iloginVars);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void GramImportPre(Gram00 wgram00) throws CatException
  {
    wgram00.setGram(null);
    List<Gram01> vgram01List = wgram00.getGram01List();

    if (vgram01List != null)
    {
      for (Gram01 gram01 : vgram01List)
      {
        gram01.setGram(null);
        gram01.setSenu(null);
      }
    }
  }
}
