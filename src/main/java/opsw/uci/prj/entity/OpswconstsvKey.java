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
public class OpswconstsvKey implements Serializable
{

  private String code;
  private String field;

  public OpswconstsvKey()
  {
    this.code = null;
    this.field = null;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getField()
  {
    return field;
  }

  public void setField(String field)
  {
    this.field = field;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.code);
    hash = 79 * hash + Objects.hashCode(this.field);
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
    final OpswconstsvKey other = (OpswconstsvKey) obj;
    if (!Objects.equals(this.code, other.code))
    {
      return false;
    }
    if (!Objects.equals(this.field, other.field))
    {
      return false;
    }
    return true;
  }

}
