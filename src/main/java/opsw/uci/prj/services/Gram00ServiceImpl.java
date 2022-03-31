/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.Gram00Rec01;
import opsw.uci.prj.records.Gram00Rec02;
import opsw.uci.prj.records.Gram01Rec01;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.repositories.Gram00Repository;
import opsw.uci.prj.utils.OpswNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class Gram00ServiceImpl implements Gram00Service
{

  @Autowired
  private Gram00Repository Gram00Repository;

  @Autowired
  private SequencesService SequencesService;

  @Autowired
  private OpswconstvService OpswconstvService;

  @Autowired
  private OpswGlobalServices01 OpswGlobalServices01;

  @Autowired
  private Gram01Service Gram01Service;

  @PostConstruct
  public void init00()
  {
    this.OpswGlobalServices01.setGram00Service(this);
  }

  @Override
  public Gram00 Gram00Select01(Long gram)
  {
    return (Gram00) this.Gram00Repository.findById(gram).orElse(null);
  }

  @Override
  public List<Gram00> Gram00List01()
          throws CatException
  {
    return (List<Gram00>) this.Gram00Repository.findAll();
  }

  @Override
  public Gram00 Gram00Select02(Long gram)
          throws CatException
  {
    Gram00 gram00 = null;

    gram00 = this.Gram00Select01(gram);
    if (gram00 != null)
    {
      gram00.setGram01List(this.OpswGlobalServices01.getGram01Service().Gram01List01(gram00.getGram()));
    }

    return gram00;
  }

  @Override
  public Gram00 Gram00Post01(Gram00 gram00)
          throws CatException
  {
    if (gram00.getGram() == null || gram00.getGram() <= 0)
    {
      gram00.setGram(this.SequencesService.SequencesGetNextVal(Sequences.SEQ_GRAM00));
      //gram00.setGram(Long.valueOf(1998));
    }
    return (Gram00) this.Gram00Repository.saveAndFlush(gram00);
  }

  @Override
  public Gram00 Gram00Post02(Long gram, Gram00 gram00, OpswLoginVars loginVars)
          throws CatException
  {
    Gram00 gram00db = null;
    Calendar cal2 = Calendar.getInstance();
    if (gram != null)
    {
      gram00db = this.Gram00Select02(gram);
    }
    else if (gram00db == null)
    {
      gram00db = new Gram00();
      gram00db.setDate_create(cal2);
      gram00db.setUser_create(loginVars.getLoginUser());
    }
    gram00db.setDate_modify(cal2);
    gram00db.setUser_modify(loginVars.getLoginUser());

    this.CopyGram00(gram00db, gram00);

    return (Gram00) this.Gram00Post01(gram00db);
  }

  private void CopyGram00(Gram00 gram00db, Gram00 gram00)
          throws CatException
  {
    gram00db.setDescr(gram00.getDescr());
    gram00db.setDescr_sea(gram00.getDescr_sea());
    gram00db.setStart_line(gram00.getStart_line());
    gram00db.setInternalkey_flds(gram00.getInternalkey_flds());
    gram00db.setSheets(gram00.getSheets());
  }

  @Override
  public Gram00 Gram00Gram00Post03(Gram00 gram00, OpswLoginVars loginVars) throws CatException
  {
    Gram00 vgram00 = Gram00Post02(gram00.getGram(), gram00, loginVars);

    List<Gram01> vgram01List = gram00.getGram01List();

    if (vgram01List != null)
    {
      List<Gram01> vgram01NewList = this.Gram01Service.Gram01Post03(vgram00.getGram(), vgram01List);

      vgram00.setGram01List(vgram01NewList);
    }

    return vgram00;
  }

  @Override
  public void Gram00Delete01(Long gram)
          throws CatException
  {
    Gram00 gram00 = this.Gram00Select02(gram);
    if (gram00 != null)
    {
      if (gram00.getGram01List() != null && !gram00.getGram01List().isEmpty())
      {
        for (Gram01 gram01 : gram00.getGram01List())
        {
          Gram01Key key = new Gram01Key(gram01.getGram(), gram01.getSenu());
          this.OpswGlobalServices01.getGram01Service().Gram01Delete02(key);
        }
      }
      this.Gram00Repository.deleteById(gram00.getGram());
    }
  }

  @Override
  public Gram00Rec02 Gram00PostED01(Long gram, Gram00Rec02 gram00Rec02,
          OpswLoginVars loginVars)
          throws CatException
  {
    Gram00Rec02 vgram00 = null;
    try
    {
      gram00Rec02.setUser_modify(loginVars.getLoginUser());

      gram00Rec02.setInternalkey_flds(
              this.Gram00ListToInternalkeys(gram00Rec02.getInternalKeyFlds())
      );

      Gram00 vgram00_01 = this.Gram00Rec02ToGram00(gram00Rec02);

      vgram00_01 = this.Gram00Post02(gram, vgram00_01, loginVars);

      vgram00_01.setGram01List(this.OpswGlobalServices01.getGram01Service()
              .Gram01List01(OpswNumberUtils.OpswGetLong(vgram00_01.getGram())));

      vgram00 = this.Gram00ToGram00Rec02(vgram00_01);

      List<String> vfldsInternalKey = new ArrayList<>();
      vgram00.setInternalKeyFlds(vfldsInternalKey);

      this.Gram00InternalkeysToList(vfldsInternalKey, vgram00.getInternalkey_flds());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vgram00;
  }

  private Gram00 Gram00Rec02ToGram00(Gram00Rec02 igram00Rec02)
          throws CatException
  {
    Gram00 gram00 = null;
    try
    {
      gram00 = new Gram00();
      OpswReflection.OpswReflectionCopyObjectFields(igram00Rec02, gram00, Gram00.class);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return gram00;
  }

  private Gram00Rec02 Gram00ToGram00Rec02(Gram00 gram00)
          throws CatException
  {
    Gram00Rec02 gram00Rec02 = null;
    try
    {
      gram00Rec02 = new Gram00Rec02();
      OpswReflection.OpswReflectionCopyParentObject(gram00, gram00Rec02, Gram00.class);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return gram00Rec02;
  }

  private void Gram00InternalkeysToList(List<String> ilist, String istrs)
          throws CatException
  {
    try
    {
      String[] vfldsSpl = null;

      if (istrs != null && !istrs.isEmpty())
      {
        vfldsSpl = istrs.split(";");
      }

      if (vfldsSpl != null)
      {
        for (String s : vfldsSpl)
        {
          ilist.add(s);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private String Gram00ListToInternalkeys(List<String> ilist)
          throws CatException
  {
    String res = null;
    try
    {
      if (ilist != null && !ilist.isEmpty())
      {
        int ii = 0;
        for (String s : ilist)
        {
          res = (res == null ? "" : res) + s + ((ilist.size() - 1) == ii ? "" : ";");
        }
        ii++;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  @Override
  public List<Gram00Rec01> Gram00Rec01List01()
          throws CatException
  {
    return this.Gram00Repository.gram00Rec01List01();
  }

  @Override
  public Gram00Rec02 Gram00Rec02Select01(Long gram) throws CatException
  {
    Gram00Rec02 gram00 = null;
    try
    {
      Gram00 vgram00 = this.Gram00Select02(gram);
      gram00 = this.Gram00ToGram00Rec02(vgram00);

      List<String> vintKeysLst = new ArrayList<>();
      gram00.setInternalKeyFlds(vintKeysLst);

      this.Gram00InternalkeysToList(vintKeysLst, vgram00.getInternalkey_flds());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return gram00;
  }

  @Override
  public Gram00Rec02 Gram00Rec02EDSelect02(Long gram, List<CatThmlfObject01> wInternalKeyList) throws CatException
  {
    Gram00Rec02 gram00Rec02 = null;
    try
    {
      gram00Rec02 = this.Gram00Rec02Select01(gram);

      if (wInternalKeyList != null)
      {
        this.Gram00Rec02InternalKeysFieldsED01(wInternalKeyList, gram00Rec02.getInternalKeyFlds());
      }

      if (gram00Rec02 != null)
      {
        this.Gram00Rec02Koina01(gram00Rec02);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return gram00Rec02;
  }

  private void Gram00Rec02InternalKeysFieldsED01(List<CatThmlfObject01> wInternalKeyList, List<String> gram00Rec02Fields)
          throws CatException
  {
    try
    {
      if (gram00Rec02Fields != null)
      {
        Opswconstsv vcost = null;
        CatThmlfObject01 vcat = null;
        for (String fld : gram00Rec02Fields)
        {
          vcost = this.OpswconstvService.OpswconstvSelect02(Opswconstsv.ASSETS00_INTERNALKEY, fld);

          if (vcost != null)
          {
            vcat = new CatThmlfObject01();
            wInternalKeyList.add(vcat);

            vcat.setCode(fld);
            vcat.setDescr(vcost.getValue());
          }
        }
      }

      List<Opswconstsv> vconsts = this.OpswconstvService.OpswconstvList01(Opswconstsv.ASSETS00_INTERNALKEY);

      if (vconsts != null)
      {
        CatThmlfObject01 vcat = null;
        for (Opswconstsv cons : vconsts)
        {
          boolean vtheareIs = false;
          for (int i = 0; i < wInternalKeyList.size(); i++)
          {
            if (wInternalKeyList.get(i).getCode().equals(cons.getField()))
            {
              vtheareIs = true;

              break;
            }
          }

          if (!vtheareIs)
          {
            vcat = new CatThmlfObject01();
            wInternalKeyList.add(vcat);

            vcat.setCode(cons.getField());
            vcat.setDescr(cons.getValue());
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  public Gram00Rec02 Gram00PostED02(Long gram, Gram00Rec02 gram00, OpswLoginVars loginVars,
          List<CatThmlfObject01> wInternalKeyList)
          throws CatException
  {
    Gram00Rec02 gram00Rec02 = null;
    try
    {
      gram00Rec02 = this.Gram00PostED01(gram, gram00, loginVars);

      this.Gram00Rec02InternalKeysFieldsED01(wInternalKeyList, gram00Rec02.getInternalKeyFlds());
      this.Gram00Rec02Koina01(gram00Rec02);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return gram00Rec02;
  }

  private void Gram00Rec02Koina01(Gram00Rec02 gram00Rec02) throws CatException
  {
    try
    {
      String vsamle = null;

      List<String> vflds = gram00Rec02.getInternalKeyFlds();

      if (vflds != null && !vflds.isEmpty())
      {
        vsamle = "";
        int ii = 0;
        for (String fld : vflds)
        {
          vsamle += "{" + fld.toUpperCase() + "}";

          if (ii < (vflds.size() - 1))
          {
            vsamle += "_";
          }

          ii++;
        }
      }

      gram00Rec02.setInternalKeyFldsSample(vsamle);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

}
