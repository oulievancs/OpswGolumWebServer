/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.records.Gram00Rec01;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface Gram00Repository extends CatEjbJpaBase<Gram00, Long>
{
  @Query("SELECT new"
          + " opsw.uci.prj.records.Gram00Rec01(a.gram, a.descr) "
          + " FROM Gram00 a ")
  public List<Gram00Rec01> gram00Rec01List01();
}
