/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author n.oulis
 */
public class Gram01Key implements Serializable
{

  private Long gram;
  private Long senu;

  public Gram01Key()
  {
    super();
    this.gram = null;
    this.senu = null;
  }

  public Gram01Key(Long gram, Long senu)
  {
    this.gram = gram;
    this.senu = senu;
  }

  public Long getGram()
  {
    return gram;
  }

  public void setGram(Long gram)
  {
    this.gram = gram;
  }

  public Long getSenu()
  {
    return senu;
  }

  public void setSenu(Long senu)
  {
    this.senu = senu;
  }
  

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.gram);
    hash = 97 * hash + Objects.hashCode(this.senu);
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    final Gram01Key other = (Gram01Key) obj;
    if (!Objects.equals(this.gram, other.gram))
    {
      return false;
    }
    if (!Objects.equals(this.senu, other.senu))
    {
      return false;
    }
    return true;
  }

}
