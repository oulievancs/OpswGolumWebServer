/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Assets00;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface Assets00Repository extends CatEjbJpaBase<Assets00, Long>
{

  @Query("SELECT a FROM Assets00 a WHERE a.status = ?1")
  List<Assets00> Assets00FindByStatus(Byte status);

  @Query("SELECT a FROM Assets00 a WHERE a.assfile BETWEEN ?1 AND ?2 ")
  List<Assets00> Assets00FindByDate(Calendar dateFrom, Calendar dateTo);

  @Query("SELECT Count(a) FROM Assets00 a WHERE a.symb_id = ?1")
  long Assets00Count01(Long symb_id);

  @Query("SELECT a FROM Assets00 a WHERE a.intrnlkey = ?1 ")
  Assets00 Assets00Select01(String internal);

  @Modifying
  @Query("DELETE FROM Assets00 a WHERE a.date_create BETWEEN ?1 AND ?2 ")
  void Assets00Delete01(Calendar date_createFrom, Calendar date_createTo);

  @Query("SELECT COUNT(a.asset) FROM Assets00 a WHERE a.date_create BETWEEN ?1 AND ?2 ")
  long Assets00SelectCount01(Calendar date_createFrom, Calendar date_createTo);
}
