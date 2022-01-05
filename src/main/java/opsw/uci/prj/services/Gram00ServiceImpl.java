/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.repositories.Gram00Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author oulis
 */
public class Gram00ServiceImpl implements Gram00Service
{

  @Autowired
  private Gram00Repository Gram00Repository;

  @Override
  public Gram00 Gram00Select01(Long gram)
  {
    return (Gram00) this.Gram00Repository.getById(gram);
  }

}
