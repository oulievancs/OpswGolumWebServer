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
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author oulis
 */
@Entity
@Table(name = "ASSETS00FL")
@IdClass(Assets00flKey.class)
public class Assets00fl implements Serializable
{

  public static final byte ASSETS_FLD_STRING = 1;
  public static final byte ASSETS_FLD_NUMBER = 2;

  @Id
  private Long asset;
  @Id
  private String fld;
  private String valstr;
  private Double valnum;
  private Byte type;
  private String fldescr;

  public Assets00fl()
  {
    super();
    this.asset = null;
    this.fld = null;
    this.valstr = null;
    this.valnum = null;
    this.type = null;
    this.fldescr = null;
  }

  public Long getAsset()
  {
    return asset;
  }

  public void setAsset(Long asset)
  {
    this.asset = asset;
  }

  public String getFld()
  {
    return fld;
  }

  public void setFld(String fld)
  {
    this.fld = fld;
  }

  public String getValstr()
  {
    return valstr;
  }

  public void setValstr(String valstr)
  {
    this.valstr = valstr;
  }

  public Double getValnum()
  {
    return valnum;
  }

  public void setValnum(Double valnum)
  {
    this.valnum = valnum;
  }

  public Byte getType()
  {
    return type;
  }

  public void setType(Byte type)
  {
    this.type = type;
  }

  public String getFldescr()
  {
    return fldescr;
  }

  public void setFldescr(String fldescr)
  {
    this.fldescr = fldescr;
  }

  @Override
  public int hashCode()
  {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.asset);
    hash = 37 * hash + Objects.hashCode(this.fld);
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
    final Assets00fl other = (Assets00fl) obj;
    if (!Objects.equals(this.fld, other.fld))
    {
      return false;
    }
    if (!Objects.equals(this.asset, other.asset))
    {
      return false;
    }
    return true;
  }
}
