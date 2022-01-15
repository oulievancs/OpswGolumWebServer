/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;

import java.util.Calendar;

/**
 *
 * @author oulis
 */
public class Assets00SearchParams01
{

  private Calendar dateFrom;
  private Calendar dateTo;
  private long symb_id;

  public Assets00SearchParams01()
  {
    this.dateFrom = null;
    this.dateTo = null;
    this.symb_id = 0;
  }

  public Calendar getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(Calendar dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  public Calendar getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(Calendar dateTo)
  {
    this.dateTo = dateTo;
  }

  public long getSymb_id()
  {
    return symb_id;
  }

  public void setSymb_id(long symb_id)
  {
    this.symb_id = symb_id;
  }
}
