/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import opsw.uci.prj.entity.Sequences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface SequencesRepository extends JpaRepository<Sequences, String>
{

  @Query("SELECT a FROM Sequences a WHERE a.seq_gen = ?1")
  public Sequences getSequenceById(String seq_gen);
}
