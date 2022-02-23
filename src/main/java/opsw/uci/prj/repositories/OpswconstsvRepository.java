/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.OpswconstsvKey;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface OpswconstsvRepository extends CatEjbJpaBase<Opswconstsv, OpswconstsvKey>
{

  @Query("SELECT new"
          + " opsw.uci.prj.records.cat.CatThmlfObject01(a.field, a.value) "
          + " FROM Opswconstsv a "
          + " WHERE a.code=?1")
  public List<CatThmlfObject01> FieldsList01(String constCode);

  @Query("SELECT a FROM Opswconstsv a WHERE a.code = ?1 ")
  public List<Opswconstsv> OpswconstsvList01(String code);
}
