/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.repositories;

import opsw.uci.prj.cat.CatEjbJpaBase;
import opsw.uci.prj.entity.Sequences;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface SequencesRepository extends CatEjbJpaBase<Sequences, String>
{

}
