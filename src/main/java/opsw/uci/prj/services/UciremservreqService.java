/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaServiceBase;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Uciremservreq;

/**
 *
 * @author e.oulis
 */
public interface UciremservreqService extends CatEjbJpaServiceBase
{

  public List<Uciremservreq> UciremservreqList01(Calendar date_cr_from) throws CatException;

  public Uciremservreq UciremservreqPost01(Uciremservreq uciremservreq) throws CatException;

  public Uciremservreq UciremservreqInsert(Uciremservreq uciremservreq) throws CatException;

  public Uciremservreq UciremservreqUpdate(Uciremservreq uciremservreq) throws CatException;

  public Uciremservreq UciremservreqSelect01(Long id) throws CatException;
}
