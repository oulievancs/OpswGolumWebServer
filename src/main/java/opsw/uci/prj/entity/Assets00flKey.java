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
 * @author oulis
 */
public class Assets00flKey implements Serializable
{

  private Long asset;
  private String fld;

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

  @Override
  public int hashCode()
  {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.asset);
    hash = 83 * hash + Objects.hashCode(this.fld);
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
    final Assets00flKey other = (Assets00flKey) obj;
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
