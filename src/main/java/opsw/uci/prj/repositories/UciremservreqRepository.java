/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Uciremservreq;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author e.oulis
 */
@Component
public interface UciremservreqRepository extends CatEjbJpaBase<Uciremservreq, Long>
{

  @Query("SELECT a FROM Uciremservreq a WHERE a.date_create >= ?1 "
          + " ORDER BY a.date_create DESC ")
  public List<Uciremservreq> UciremservreqList01(Calendar date_cr_from);
}
