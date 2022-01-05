/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import opsw.uci.prj.entity.Sequences;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
public interface SequencesService
{
  public Sequences SequencesSelect01(String seq_gen);
  
  public Long SequencesGetNextVal(String seq_gen);
}
