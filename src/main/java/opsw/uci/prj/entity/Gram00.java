/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author n.oulis
 */
@Entity
@Table(name = "GRAM00")
public class Gram00 implements Serializable
{

  public static final String GRAM00_INTERNALKEY_AAUCI = "AAUCI";
  public static final String GRAM00_INTERNALKEY_ASSFILE = "ASSFILE";
  public static final String GRAM00_INTERNALKEY_UNIQCODE = "UNIQCODE";
  public static final String GRAM00_INTERNALKEY_DOV = "DOV";

  @Id
  private Long gram;
  private String descr;
  private String descr_sea;
  private Short start_line;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_create;
  private String user_create;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_modify;
  private String user_modify;
  private String internalkey_flds;

  @Transient
  private List<Gram01> gram01List;

  public Gram00()
  {
    super();
    this.gram = null;
    this.descr = null;
    this.descr_sea = null;
    this.date_create = null;
    this.user_create = null;
    this.date_modify = null;
    this.user_modify = null;
    this.internalkey_flds = null;
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

  public String getDescr_sea()
  {
    return descr_sea;
  }

  public void setDescr_sea(String descr_sea)
  {
    this.descr_sea = descr_sea;
  }

  public Short getStart_line()
  {
    return start_line;
  }

  public void setStart_line(Short start_line)
  {
    this.start_line = start_line;
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

  public List<Gram01> getGram01List()
  {
    return gram01List;
  }

  public void setGram01List(List<Gram01> gram01List)
  {
    this.gram01List = gram01List;
  }

  public String getInternalkey_flds()
  {
    return internalkey_flds;
  }

  public void setInternalkey_flds(String internalkey_flds)
  {
    this.internalkey_flds = internalkey_flds;
  }

  @Override
  public int hashCode()
  {
    int hash = 5;
    hash = 59 * hash + Objects.hashCode(this.gram);
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
    final Gram00 other = (Gram00) obj;
    if (!Objects.equals(this.gram, other.gram))
    {
      return false;
    }
    return true;
  }

}
