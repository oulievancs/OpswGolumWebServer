/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import opsw.uci.prj.entity.Sequences;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oulis
 */
public interface SequencesRepository extends JpaRepository<Sequences, String>
{

}
