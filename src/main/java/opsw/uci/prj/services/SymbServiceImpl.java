/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.OpswEntityManagerBase;
import opsw.uci.prj.entity.Sequences;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.repositories.SymbRepository;
import opsw.uci.prj.utils.OpswNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class SymbServiceImpl implements SymbService
{

  @Autowired
  private OpswEntityManagerBase connection;

  @Autowired
  private SymbRepository SymbRepository;

  @Autowired
  private SequencesService SequenceService;

  @Override
  public Symb SymbSelect01(Long id) throws CatException
  {
    return (Symb) this.SymbRepository.findById(id).orElse(null);
  }

  @Override
  public List<Symb> SymbList01(String param) throws CatException
  {
    return (List<Symb>) this.SymbRepository.SymbList01(param);
  }

  @Override
  public Symb SymbPost01(Symb symb) throws CatException
  {
    Symb vsymb = symb;
    try
    {
      if (OpswNumberUtils.OpswGetLong(symb.getId()) == 0)
      {
        symb.setId(this.SequenceService.SequencesGetNextVal(Sequences.SEQ_SYMB));
      }
      
      vsymb = (Symb) this.SymbRepository.save(symb);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return vsymb;
  }
}
