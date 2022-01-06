/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.repositories.SequencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class SequencesServiceImpl implements SequencesService
{

  @Autowired
  private SequencesRepository SequencesRepository;

  @Override
  public Sequences SequencesSelect01(String seq_gen)
  {
    return (Sequences) this.SequencesRepository.findById(seq_gen).orElse(null);
  }

  @Override
  public Long SequencesGetNextVal(String seq_gen)
  {
    long nextVal = -1;

    Sequences sequences = this.SequencesSelect01(seq_gen);

    if (sequences == null)
    {
      sequences = new Sequences();
      sequences.setSeq_gen(seq_gen);
      nextVal = 1;
    } else
    {
      nextVal = sequences.getSeq_count() + 1;
    }

    sequences.setSeq_count(++nextVal);

    this.SequencesRepository.saveAndFlush(sequences);

    return nextVal;
  }

}
