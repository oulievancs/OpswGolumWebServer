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
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Gram00Rec01;
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
}
