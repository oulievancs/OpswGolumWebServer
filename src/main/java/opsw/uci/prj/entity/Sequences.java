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
@Table(name = "SEQUENCES")
public class Sequences implements Serializable
{

  public static final String SEQ_GRAM00 = "SEQ_GRAM00";

  @Id
  private String seq_gen;
  private Long seq_count;

  public Sequences()
  {
    this.seq_gen = null;
    this.seq_count = null;
  }

  public String getSeq_gen()
  {
    return seq_gen;
  }

  public void setSeq_gen(String seq_gen)
  {
    this.seq_gen = seq_gen;
  }

  public Long getSeq_count()
  {
    return seq_count;
  }

  public void setSeq_count(Long seq_count)
  {
    this.seq_count = seq_count;
  }

  @Override
  public int hashCode()
  {
    int hash = 5;
    hash = 29 * hash + Objects.hashCode(this.seq_gen);
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
    final Sequences other = (Sequences) obj;
    if (!Objects.equals(this.seq_gen, other.seq_gen))
    {
      return false;
    }
    return true;
  }
}
