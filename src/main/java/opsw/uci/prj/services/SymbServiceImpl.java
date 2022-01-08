/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.OpswEntityManagerBase;
import opsw.uci.prj.entity.Symb;
import opsw.uci.prj.repositories.SymbRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author oulis
 */
public class SymbServiceImpl implements SymbService
{

  @Autowired
  private OpswEntityManagerBase connection;

  @Autowired
  private SymbRepository SymbRepository;

  @Override
  public Symb SymbSelect01(Long id) throws CatException
  {
    return (Symb) this.SymbRepository.findById(id).orElse(null);
  }
}