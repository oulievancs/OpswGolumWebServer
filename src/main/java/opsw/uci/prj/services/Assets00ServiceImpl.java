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
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.OpswEntityManagerBase;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.entity.Assets00fl;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00Rec02;
import opsw.uci.prj.records.Assets00SearchParams01;
import opsw.uci.prj.repositories.Assets00Repository;
import opsw.uci.prj.utils.OpswDateUtils;
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
public class Assets00ServiceImpl implements Assets00Service
{

  @Autowired
  private OpswEntityManagerBase connection;

  @Autowired
  private Assets00Repository Assets00Repository;

  @Autowired
  private SequencesService SequencesService;

  @Autowired
  private OpswGlobalServices01 OpswGlobalServices01;

  @Autowired
  private Assets00flService Assets00flService;

  @Autowired
  private OpswconstvService OpswconstvService;

  @PostConstruct
  public void init00()
  {
    this.OpswGlobalServices01.setAssets00Service(this);
  }

  @Override
  public List<Assets00> Assets00List01(Byte status)
          throws CatException
  {
    return (List<Assets00>) this.Assets00Repository.Assets00FindByStatus(status);
  }

  @Override
  public List<Assets00> Assets00List02()
          throws CatException
  {
    List<Assets00> assets00List = null;
    EntityManager em = (EntityManager) this.connection.getConnection();
    Query qre = em.createQuery("SELECT a FROM Assets00 a WHERE 1 = 1");
    assets00List = (List<Assets00>) qre.getResultList();
    return (List<Assets00>) assets00List;//this.Assets00Repository.findAll();
  }

  @Override
  public Assets00 Assets00Insert(Assets00 assets00) throws CatException
  {
    return (Assets00) this.Assets00Repository.saveAndFlush(assets00);
  }

  @Override
  public Assets00 Assets00Post01(Assets00 assets00) throws CatException
  {
    Assets00 vassets00 = assets00;
    try
    {
      if (assets00.getAsset() == null || assets00.getAsset() < 1)
      {
        assets00.setAsset(this.SequencesService.SequencesGetNextVal(Sequences.SEQ_ASSETS00));
        assets00.setUser_create(assets00.getUser_modify());
        assets00.setDate_create(assets00.getDate_modify());
      }

      vassets00 = this.Assets00Insert(assets00);

      if (assets00.getAssets00fl() != null)
      {
        for (Assets00fl assfl : assets00.getAssets00fl())
        {
          assfl.setAsset(assets00.getAsset());
          this.Assets00flService.Assets00flPost01(assfl);
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vassets00;
  }

  @Override
  public Assets00 Assets00Post02(Assets00 assets00, boolean postSymb) throws CatException
  {
    Assets00 vassets00 = assets00;
    try
    {
      if (postSymb && vassets00.getSymb() != null)
      {
        Symb vsymb = this.OpswGlobalServices01.getSymbService().SymbPost01(vassets00.getSymb());

        vassets00.setSymb(vsymb);
      }
      vassets00 = this.Assets00Post01(assets00);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vassets00;
  }

  @Override
  public List<Assets00Rec01> Assets00Rec01List01() throws CatException
  {
    List<Assets00Rec01> vlist = null;

    try
    {
      List<Assets00> vlist1 = this.Assets00List02();
      vlist = this.Assets00Rec01FromAssets00(vlist1);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vlist;
  }

  private List<Assets00Rec01> Assets00Rec01FromAssets00(List<Assets00> assets) throws CatException
  {
    List<Assets00Rec01> result = null;
    try
    {
      result = new ArrayList<>();
      if (assets != null && !assets.isEmpty())
      {
        for (Assets00 asset : assets)
        {
          Assets00Rec01 rec = new Assets00Rec01();
          result.add(rec);
          Assets00Rec01.CopyAssets00Rec01FromAssents00(asset, (Assets00) rec);
          if (OpswNumberUtils.OpswGetLong(asset.getSymb_id()) > 0)
          {
            Symb vsymb = this.OpswGlobalServices01.getSymbService().SymbSelect01(asset.getSymb_id());

            if (vsymb != null)
            {
              rec.setSymb_name(vsymb.getName());
              rec.setSymb_surename(vsymb.getSurename());
              rec.setSymb_tele(vsymb.getTele());
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  @Override
  public List<Assets00Rec01> Assets00List02(Calendar dateFrom, Calendar dateTo) throws CatException
  {
    List<Assets00Rec01> resultList = null;
    try
    {
      List<Assets00> vlist = this.Assets00Repository.Assets00FindByDate(dateFrom, dateTo);
      resultList = this.Assets00Rec01FromAssets00(vlist);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return resultList;
  }

  @Override
  public List<Assets00Rec01> Assets00List03(Assets00SearchParams01 iparams) throws CatException
  {
    List<Assets00Rec01> vlist = null;
    try
    {
      EntityManager em = (EntityManager) this.connection.getConnection();

      String vsql = "SELECT a FROM Assets00 a ";

      vsql += " WHERE a.assfile BETWEEN :dateFrom AND :dateTo ";

      if (iparams.getSymb_id() > 0)
      {
        vsql += " AND a.symb_id = :symb_id ";
      }

      Query q = em.createQuery(vsql);
      q.setParameter("dateFrom", iparams.getDateFrom());
      q.setParameter("dateTo", iparams.getDateTo());

      if (iparams.getSymb_id() > 0)
      {
        q.setParameter("symb_id", iparams.getSymb_id());
      }

      List<Assets00> vlist00 = (List<Assets00>) q.getResultList();

      vlist = this.Assets00Rec01FromAssets00(vlist00);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vlist;
  }

  @Override
  public Assets00Rec01 Assets00Select01(Long id) throws CatException
  {
    Assets00Rec01 result = null;
    try
    {
      Assets00 asset = this.Assets00Select02(id);
      result = this.Assets00Rec01FromAssets00Record(asset);
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);

    }
    return result;
  }

  private Assets00Rec01 Assets00Rec01FromAssets00Record(Assets00 asset) throws CatException
  {
    Assets00Rec01 result = null;
    try
    {
      result = new Assets00Rec01();
      Assets00Rec01.CopyAssets00Rec01FromAssents00(asset, (Assets00) result);
      if (OpswNumberUtils.OpswGetLong(asset.getSymb_id()) > 0)
      {
        Symb vsymb = this.OpswGlobalServices01.getSymbService().SymbSelect01(asset.getSymb_id());

        if (vsymb != null)
        {
          result.setSymb_name(vsymb.getName());
          result.setSymb_surename(vsymb.getSurename());
          result.setSymb_tele(vsymb.getTele());
          result.setSymb_mail(vsymb.getEmail());
        }
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  @Override
  public long Assets00Count01(Long symb_id) throws CatException
  {
    long vcount = 0;
    try
    {
      vcount = OpswNumberUtils.OpswGetLong(this.Assets00Repository.Assets00Count01(symb_id));
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vcount;
  }

  @Override
  public Assets00Rec02 Assets00PostEd01(Long assetId, Assets00Rec02 asset, OpswLoginVars logvars) throws CatException
  {
    Assets00Rec02 result = null;
    try
    {
      Assets00 assetdb = this.Assets00Select02(assetId);
      if (assetdb == null)
      {
        assetdb = new Assets00();
      }
      //OpswReflection.OpswReflectionCopyObjectFields(asset, assetdb, Assets00Rec02.class);
      //assetdb.setAuction_date(OpswDateUtils.DateToCalendarElseNow(asset.getAuction_datedate()));
      Assets00Rec02.Assets00Rec02ToAssets00(asset, assetdb);
      assetdb = this.Assets00Post01(assetdb);
      result = asset;
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  @Override
  public Assets00Rec02 Assets00Rec02Select01(Long id) throws CatException
  {
    Assets00Rec02 result = null;

    try
    {
      Assets00 asset = this.Assets00Select02(id);
      result = new Assets00Rec02();
      //OpswReflection.OpswReflectionCopyObjectFields(asset, result, Assets00.class);
      //result.setAuction_datedate(OpswDateUtils.CalendarToDateElseNow(asset.getAuction_date()));
      Assets00Rec02.Assets00ToAssets00Rec02(asset, result);
      OpswReflection.OpswReflectionCopyObjectFields(asset, result, Assets00.class);
      result.setAuction_datedate(OpswDateUtils.CalendarToDateElseNow(asset.getAuction_date()));
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }

    return result;
  }

  @Override
  public Assets00 Assets00Select02(Long id) throws CatException
  {
    return this.Assets00Repository.findById(id).orElse(null);
  }

  @Override
  public List<Assets00> Assets00List03() throws CatException
  {
    List<Assets00> vlistAssets00 = this.Assets00List02();

    if (vlistAssets00 != null)
    {
      for (Assets00 ass : vlistAssets00)
      {
        List<Opswconstsv> vlistconst = this.OpswconstvService.OpswconstvList01(Opswconstsv.ASSETS00_FLDS);

        List<Assets00fl> vfllist = null;
        if (vlistconst != null)
        {
          vfllist = new ArrayList<>();
          for (Opswconstsv con : vlistconst)
          {

            vfllist.add(this.Assets00flService.Assets00flSelect02(ass.getAsset(), con.getValue()));
          }
        }
        ass.setAssets00fl(vfllist);
      }
    }

    return vlistAssets00;
  }

}
