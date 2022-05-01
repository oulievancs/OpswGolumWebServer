/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Assets00fl;
import opsw.uci.prj.entity.Assets00flKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface Assets00flRepository extends CatEjbJpaBase<Assets00fl, Assets00flKey>
{

  @Query("SELECT a FROM Assets00fl a WHERE a.asset = ?1")
  List<Assets00fl> Assets00flFindByAsset(Long id);

  @Modifying
  @Query("DELETE FROM Assets00fl a LEFT JOIN Assets00 b ON a.asset = b.asset "
          + "WHERE b.date_create BETWEEN ?1 AND ?2 ")
  void Assets00flDelete01(Calendar date_createFrom, Calendar date_createTo);

}
