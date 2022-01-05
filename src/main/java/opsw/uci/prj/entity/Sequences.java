/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author oulis
 */
@Entity
public class Sequences implements Serializable
{

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
}
