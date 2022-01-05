/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.repositories.Gram00Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class Gram00ServiceImpl implements Gram00Service
{

  @Autowired
  private Gram00Repository Gram00Repository;

  @Autowired
  private SequencesService SequencesService;

  @Autowired
  private Gram01Service Gram01Service;

  @Override
  public Gram00 Gram00Select01(Long gram)
  {
    return (Gram00) this.Gram00Repository.getById(gram);
  }

  @Override
  public List<Gram00> Gram00List01()
  {
    return (List<Gram00>) this.Gram00Repository.findAll();
  }

  @Override
  public Gram00 Gram00Select02(Long gram)
  {
    Gram00 gram00 = null;

    gram00 = this.Gram00Select01(gram);
    if (gram00 != null)
    {
      gram00.setGram01List(this.Gram01Service.Gram01List01(gram00.getGram()));
    }

    return gram00;
  }

  @Override
  public Gram00 Gram00Post01(Gram00 gram00)
  {
    if (gram00.getGram() == null || gram00.getGram() <= 0)
    {
      gram00.setGram(this.SequencesService.SequencesGetNextVal(Sequences.SEQ_GRAM00));
    }
    return (Gram00) this.Gram00Repository.save(gram00);
  }

  @Override
  public Gram00 Gram00Post02(Long gram, Gram00 gram00)
  {
    return (Gram00) this.Gram00Post01(gram00);
  }

}
