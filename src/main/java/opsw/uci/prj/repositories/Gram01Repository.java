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
import opsw.uci.prj.records.Gram01Rec01;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface Gram01Repository extends CatEjbJpaBase<Gram01, Gram01Key>
{

  @Query("SELECT a FROM Gram01 a WHERE a.gram = ?1 ORDER BY a.excel_index")
  public List<Gram01> gram01List01(Long gram);

  @Query("SELECT MAX(a.senu) FROM Gram01 a WHERE a.gram = ?1")
  public Long gram01MaxSenu(Long gram);

  @Query("SELECT new "
          + " opsw.uci.prj.records.Gram01Rec01(a.gram, a.senu, b.value, a.field_name, a.value_str, a.value_num, a.excel_index)  "
          + " FROM Gram01 a "
          + " LEFT JOIN Opswconstsv b ON b.field = a.field_type "
          + " WHERE a.gram = ?1 AND b.code = ?2"
          + " ORDER BY a.excel_index")
  public List<Gram01Rec01> gram01Rec01List01(Long gram, String const_Code);

  @Query("SELECT a FROM Gram01 a WHERE a.gram = ?1 ORDER BY a.concatOrder")
  public List<Gram01> gram01List02(Long gram);
}
