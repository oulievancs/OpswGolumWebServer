/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Symb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface SymbRepository extends CatEjbJpaBase<Symb, Long>
{

  @Query("SELECT a FROM Symb a "
          + " WHERE "
          + " a.name LIKE %?1% OR a.surename LIKE %?1% OR a.email LIKE %1% ")
  public List<Symb> SymbList01(String param);
}
