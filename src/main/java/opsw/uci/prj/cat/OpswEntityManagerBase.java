/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.cat;

/**
 *
 * @author e.oulis
 */
public abstract class OpswEntityManagerBase
{

  private Object connection;
  private boolean checkTransaction;

  public OpswEntityManagerBase()
  {
    super();
    this.checkTransaction = true;
  }

  public boolean isCheckTransaction()
  {
    return checkTransaction;
  }

  public void setCheckTransaction(boolean checkTransaction)
  {
    this.checkTransaction = checkTransaction;
  }

  public Object getConnection()
  {
    return this.connection;
  }

  public void setConnection(Object connection)
  {
    this.connection = connection;
  }

  public abstract void transactionBegin() throws CatException;

  public abstract void transactionCommit() throws CatException;

  public abstract void transactionRollback() throws CatException;

  public abstract OpswEntityManagerBase cloneConnection() throws CatException;

  public abstract void close() throws CatException;

  public void RollbackAndCatException(OpswEntityManagerBase con, Throwable ex)
          throws CatException
  {
    this.transactionRollback();
    throw new CatException(ex);
  }

  public abstract void DetachObject(Object obj) throws CatException;
}
