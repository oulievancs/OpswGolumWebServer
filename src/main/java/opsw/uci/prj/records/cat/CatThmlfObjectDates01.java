/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records.cat;

import java.util.Date;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author oulis
 */
public class CatThmlfObjectDates01
{

  @DateTimeFormat(pattern = OpswDateUtils.OPSW_DATE_THYMLEAF_02)
  private Date dateFrom;
  @DateTimeFormat(pattern = OpswDateUtils.OPSW_DATE_THYMLEAF_02)
  private Date dateTo;

  public CatThmlfObjectDates01()
  {
    this.dateFrom = null;
    this.dateTo = null;
  }

  public Date getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  public Date getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(Date dateTo)
  {
    this.dateTo = dateTo;
  }
}
