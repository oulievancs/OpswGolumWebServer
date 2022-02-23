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
 * @author e.oulis
 */
@Entity
@Table(name = "UCIREMSERVREQ")
public class Uciremservreq implements Serializable
{

  @Id
  private Long id;
  private String urlreq;
  private String rema;
  private byte[] respbody;
  private String user_create;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_create;
  private String user_modify;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_modify;

  public Uciremservreq()
  {
    super();
    this.id = null;
    this.urlreq = null;
    this.rema = null;
    this.respbody = null;
    this.user_create = null;
    this.date_create = null;
    this.user_modify = null;
    this.date_modify = null;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getUrlreq()
  {
    return urlreq;
  }

  public void setUrlreq(String urlreq)
  {
    this.urlreq = urlreq;
  }

  public String getRema()
  {
    return rema;
  }

  public void setRema(String rema)
  {
    this.rema = rema;
  }

  public byte[] getRespbody()
  {
    return respbody;
  }

  public void setRespbody(byte[] respbody)
  {
    this.respbody = respbody;
  }

  public String getUser_create()
  {
    return user_create;
  }

  public void setUser_create(String user_create)
  {
    this.user_create = user_create;
  }

  public Calendar getDate_create()
  {
    return date_create;
  }

  public void setDate_create(Calendar date_create)
  {
    this.date_create = date_create;
  }

  public String getUser_modify()
  {
    return user_modify;
  }

  public void setUser_modify(String user_modify)
  {
    this.user_modify = user_modify;
  }

  public Calendar getDate_modify()
  {
    return date_modify;
  }

  public void setDate_modify(Calendar date_modify)
  {
    this.date_modify = date_modify;
  }

  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.id);
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
    final Uciremservreq other = (Uciremservreq) obj;
    if (!Objects.equals(this.id, other.id))
    {
      return false;
    }
    return true;
  }
}
