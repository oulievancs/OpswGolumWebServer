/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;

/**
 *
 * @author n.oulis
 */
public class Gram00Rec01
{
  private Long gram;
  private String descr;

  public Gram00Rec01()
  {
    this.gram = null;
    this.descr = null;
  }
  
  public Gram00Rec01(Long gram, String descr)
  {
    this.gram = gram;
    this.descr = descr;
  }

  public Long getGram()
  {
    return gram;
  }

  public void setGram(Long gram)
  {
    this.gram = gram;
  }

  public String getDescr()
  {
    return descr;
  }

  public void setDescr(String descr)
  {
    this.descr = descr;
  }
  
}
