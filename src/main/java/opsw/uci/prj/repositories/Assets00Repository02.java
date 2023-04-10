/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opsw.uci.prj.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.OpswEntityManagerBase;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.records.Assets00Rec01;
import opsw.uci.prj.records.Assets00SearchParams01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oulis
 */
@Repository
public class Assets00Repository02
{

  @Autowired
  private OpswEntityManagerBase connection;

  public List<Assets00> Assets00List02() throws CatException
  {
    EntityManager em = (EntityManager) this.connection.getConnection();
    Query qre = em.createQuery("SELECT a FROM Assets00 a WHERE 1 = 1");
    List<Assets00> assets00List = (List<Assets00>) qre.getResultList();
    return (List<Assets00>) assets00List;//this.Assets00Repository.findAll();
  }

  public List<Assets00> Assets00List03(Assets00SearchParams01 iparams) throws CatException
  {
    List<Assets00> vlist00 = null;
    try
    {
      EntityManager em = (EntityManager) this.connection.getConnection();

      String vsql = "SELECT a FROM Assets00 a ";

      vsql += " WHERE a.assfile BETWEEN :dateFrom AND :dateTo ";

      if (iparams.getSymb_id() > 0)
      {
        vsql += " AND a.symb_id = :symb_id ";
      }

      Query q = em.createQuery(vsql);
      q.setParameter("dateFrom", iparams.getDateFrom());
      q.setParameter("dateTo", iparams.getDateTo());

      if (iparams.getSymb_id() > 0)
      {
        q.setParameter("symb_id", iparams.getSymb_id());
      }

      vlist00 = (List<Assets00>) q.getResultList();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vlist00;
  }
}
