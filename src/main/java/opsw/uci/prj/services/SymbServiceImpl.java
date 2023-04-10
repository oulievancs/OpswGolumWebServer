/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import opsw.uci.prj.arifacts.OpswTransactional;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.repositories.SymbRepository;
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
public class SymbServiceImpl implements SymbService
{

  @Autowired
  private SymbRepository SymbRepository;

  @Autowired
  private SequencesService SequenceService;

  @Autowired
  private OpswGlobalServices01 OpswGlobalServices01;

  @PostConstruct
  public void init00()
  {
    this.OpswGlobalServices01.setSymbService(this);
  }

  @Override
  public Symb SymbSelect01(Long id) throws CatException
  {
    return (Symb) this.SymbRepository.findById(id).orElse(null);
  }

  @Override
  public List<Symb> SymbList01(String param) throws CatException
  {
    return (List<Symb>) this.SymbRepository.SymbList01(param);
  }

  @Override
  public Symb SymbPost(Symb symb) throws CatException
  {
    Symb vsymb = symb;
    try
    {
      vsymb = (Symb) this.SymbRepository.saveAndFlush(vsymb);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vsymb;
  }

  @Override
  public Symb SymbPost01(Symb symb) throws CatException
  {
    Symb vsymb = symb;
    try
    {
      if (OpswNumberUtils.OpswGetLong(symb.getId()) == 0)
      {
        symb.setId(this.SequenceService.SequencesGetNextVal(Sequences.SEQ_SYMB));
      }

      if (vsymb.getDate_create() == null)
      {
        vsymb.setDate_create(vsymb.getDate_modify());
      }

      if (vsymb.getUser_create() == null)
      {
        vsymb.setUser_create(vsymb.getUser_modify());
      }

      this.SymbPost(symb);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vsymb;
  }

  @Override
  public List<Symb> SymbList02() throws CatException
  {
    List<Symb> vsymbList = null;
    try
    {
      vsymbList = (List<Symb>) this.SymbRepository.findAll();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vsymbList;
  }

  @Override
  public Symb SymbEDPost01(Long symb_id, Symb symb, OpswLoginVars ilogvar)
          throws CatException
  {
    Symb vsymb = null;
    try
    {
      Calendar vcal = Calendar.getInstance();

      vsymb = this.SymbSelect01(OpswNumberUtils.OpswGetLong(symb_id));

      if (vsymb == null)
      {
        vsymb = new Symb();
        vsymb.setDate_create(vcal);
        vsymb.setUser_create(ilogvar.getLoginUser());
      }

      vsymb.setDate_modify(vcal);
      vsymb.setUser_modify(ilogvar.getLoginUser());

      SymbEDCopy01(vsymb, symb);

      vsymb = this.SymbPost01(vsymb);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vsymb;
  }

  private void SymbEDCopy01(Symb symbDb, Symb symbOrig)
          throws CatException
  {
    try
    {
      symbDb.setName(symbOrig.getName());
      symbDb.setSurename(symbOrig.getSurename());
      symbDb.setTele(symbOrig.getTele());
      symbDb.setEmail(symbOrig.getEmail());
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  public List<Symb> SymbPRDelete01(Long symb_id) throws CatException
  {
    List<Symb> vlistSymb = null;
    try
    {
      Symb vsymb = this.SymbSelect01(symb_id);

      SymbPRDeleteChecks(vsymb);

      if (vsymb != null)
      {
        this.SymbDelete01(vsymb);
      }

      vlistSymb = this.SymbList02();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vlistSymb;
  }

  private void SymbPRDeleteChecks(Symb vsymb)
          throws CatException
  {
    try
    {
      long vdepends = this.OpswGlobalServices01.getAssets00Service().Assets00Count01(vsymb.getId());

      if (vdepends > 0)
      {
        throw new CatExceptionUser("There are Master Files records that depended on this notary!");
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  @OpswTransactional
  public void SymbDelete01(Symb symb) throws CatException
  {
    this.SymbRepository.delete(symb);
  }

  @Override
  public Symb SymbSelect02(Long id) throws CatException
  {
    Symb vsymb = null;
    try
    {
      if (OpswNumberUtils.OpswGetLong(id) > 0)
      {
        vsymb = this.SymbSelect01(id);
      }
      else
      {
        vsymb = new Symb();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vsymb;
  }
}
