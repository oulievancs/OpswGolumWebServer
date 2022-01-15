/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records.cat;

/**
 *
 * @author oulis
 */
public class CatThmlfAssets00List01Params
{

  private CatThmlfObjectDates01 searchDates;
  private Long symb_id;

  public CatThmlfAssets00List01Params()
  {
    this.searchDates = null;
    this.symb_id = null;
  }

  public CatThmlfObjectDates01 getSearchDates()
  {
    return searchDates;
  }

  public void setSearchDates(CatThmlfObjectDates01 searchDates)
  {
    this.searchDates = searchDates;
  }

  public Long getSymb_id()
  {
    return symb_id;
  }

  public void setSymb_id(Long symb_id)
  {
    this.symb_id = symb_id;
  }
}
