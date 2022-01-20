/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
  private String email;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_create;
  private String user_create;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_modify;
  private String user_modify;

  public Symb()
  {
    this.id = null;
    this.name = null;
    this.surename = null;
    this.tele = null;
    this.email = null;
    this.date_create = null;
    this.user_create = null;
    this.date_modify = null;
    this.user_modify = null;
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

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public Calendar getDate_create()
  {
    return date_create;
  }

  public void setDate_create(Calendar date_create)
  {
    this.date_create = date_create;
  }

  public String getUser_create()
  {
    return user_create;
  }

  public void setUser_create(String user_create)
  {
    this.user_create = user_create;
  }

  public Calendar getDate_modify()
  {
    return date_modify;
  }

  public void setDate_modify(Calendar date_modify)
  {
    this.date_modify = date_modify;
  }

  public String getUser_modify()
  {
    return user_modify;
  }

  public void setUser_modify(String user_modify)
  {
    this.user_modify = user_modify;
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
