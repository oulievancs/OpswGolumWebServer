/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author oulis
 */
@Entity
@Table(name = "SYMB")
public class Symb implements Serializable
{

  @Id
  private Long id;
  private String name;
  private String surename;
  private String tele;

  public Symb()
  {
    this.id = null;
    this.name = null;
    this.surename = null;
    this.tele = null;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSurename()
  {
    return surename;
  }

  public void setSurename(String surename)
  {
    this.surename = surename;
  }

  public String getTele()
  {
    return tele;
  }

  public void setTele(String tele)
  {
    this.tele = tele;
  }

  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 97 * hash + Objects.hashCode(this.id);
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
    final Symb other = (Symb) obj;
    if (!Objects.equals(this.id, other.id))
    {
      return false;
    }
    return true;
  }
}
