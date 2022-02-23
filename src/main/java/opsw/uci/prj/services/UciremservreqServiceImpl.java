/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Uciremservreq;
import opsw.uci.prj.repositories.UciremservreqRepository;
import opsw.uci.prj.utils.OpswNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.oulis
 */
@Service
@Component
public class UciremservreqServiceImpl implements UciremservreqService
{

  @Autowired
  private UciremservreqRepository UciremservreqRepository;

  @Autowired
  private SequencesService SequencesService;

  @Override
  public List<Uciremservreq> UciremservreqList01(Calendar date_cr_from) throws CatException
  {
    List<Uciremservreq> uciremservreqL = null;
    try
    {
      uciremservreqL = this.UciremservreqRepository.UciremservreqList01(date_cr_from);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return uciremservreqL;
  }

  @Override
  public Uciremservreq UciremservreqPost01(Uciremservreq uciremservreq) throws CatException
  {
    Uciremservreq uciremservreq1 = null;
    try
    {
      boolean vupd = false;
      if (OpswNumberUtils.OpswGetLong(uciremservreq.getId()) > 0)
      {
        if (this.UciremservreqRepository.existsById(uciremservreq.getId()))
        {
          uciremservreq1 = this.UciremservreqUpdate(uciremservreq);
          vupd = true;
        }
      }

      if (!vupd)
      {
        uciremservreq.setDate_create(uciremservreq.getDate_modify());
        uciremservreq.setUser_create(uciremservreq.getUser_modify());

        uciremservreq.setId(this.SequencesService.SequencesGetNextVal(Sequences.SEQ_UCIREMSERVREQ));

        uciremservreq1 = this.UciremservreqInsert(uciremservreq);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return uciremservreq1;
  }

  @Override
  public Uciremservreq UciremservreqInsert(Uciremservreq uciremservreq) throws CatException
  {
    return (Uciremservreq) this.UciremservreqRepository.saveAndFlush(uciremservreq);
  }

  @Override
  public Uciremservreq UciremservreqUpdate(Uciremservreq uciremservreq) throws CatException
  {
    return (Uciremservreq) this.UciremservreqRepository.saveAndFlush(uciremservreq);
  }

  @Override
  public Uciremservreq UciremservreqSelect01(Long id) throws CatException
  {
    Uciremservreq uciremservreq = null;
    try
    {
      uciremservreq = this.UciremservreqRepository.findById(id).orElse(null);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return uciremservreq;
  }

}
