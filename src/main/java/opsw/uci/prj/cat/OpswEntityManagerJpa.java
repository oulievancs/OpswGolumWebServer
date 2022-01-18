/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.cat;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.oulis
 */
@Service
@Component
public class OpswEntityManagerJpa extends OpswEntityManagerBase
{

  @PersistenceContext
  private EntityManager em;

  public OpswEntityManagerJpa()
  {
    super();
  }

  @PostConstruct
  private void init00()
  {
    this.setConnection(this.em);
  }

  private void transactionBeginEM() throws CatException
  {
    try
    {
      if (!this.em.getTransaction().isActive())
      {
        this.em.getTransaction().begin();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void transactionCommitEM() throws CatException
  {
    try
    {
      this.em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void transactionRollbackEM() throws CatException
  {
    try
    {
      if (this.em.getTransaction().isActive())
      {
        this.em.getTransaction().rollback();
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  private void closeEM() throws CatException
  {
    try
    {
      //this.em.close();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

  @Override
  public void transactionBegin() throws CatException
  {
    if (this.isCheckTransaction())
    {
      this.transactionBeginEM();
    }
  }

  @Override
  public void transactionCommit() throws CatException
  {
    if (this.isCheckTransaction())
    {
      this.transactionCommitEM();
    }
  }

  @Override
  public void transactionRollback() throws CatException
  {
    if (this.isCheckTransaction())
    {
      this.transactionRollbackEM();
    }
  }

  @Override
  public OpswEntityManagerBase cloneConnection() throws CatException
  {
    OpswEntityManagerJpa con = new OpswEntityManagerJpa();
    con.setCheckTransaction(this.isCheckTransaction());
    con.setConnection(this.getConnection());
    return con;
  }

  @Override
  public void close() throws CatException
  {
    this.closeEM();
  }

  @Override
  public void DetachObject(Object obj) throws CatException
  {
    if (obj != null)
    {
      if (this.em.contains(obj))
      {
        this.em.detach(obj);
      }
    }
  }

  @Override
  public void flush() throws CatException
  {
    try
    {
      this.em.flush();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
