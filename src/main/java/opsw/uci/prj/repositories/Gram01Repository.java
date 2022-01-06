/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface Gram01Repository extends CatEjbJpaBase<Gram01, Gram01Key>
{
  @Query("SELECT a FROM Gram01 a WHERE a.gram = ?1")
  public List<Gram01> gram01List01(Long gram);
  
  @Query("SELECT MAX(a.senu) FROM Gram01 a WHERE a.gram = ?1")
  public Long gram01MaxSenu(Long gram);
}
