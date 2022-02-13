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
@Table(name = "OPSWFLDSV")
public class Opswfldsv implements Serializable
{

  @Id
  private String code;
  private Byte type;
  private String descr;

  public Opswfldsv()
  {
    this.code = null;
    this.type = null;
    this.descr = null;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public Byte getType()
  {
    return type;
  }

  public void setType(Byte type)
  {
    this.type = type;
  }

  public String getDescr()
  {
    return descr;
  }

  public void setDescr(String descr)
  {
    this.descr = descr;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.code);
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
    final Opswfldsv other = (Opswfldsv) obj;
    if (!Objects.equals(this.code, other.code))
    {
      return false;
    }
    return true;
  }
}
