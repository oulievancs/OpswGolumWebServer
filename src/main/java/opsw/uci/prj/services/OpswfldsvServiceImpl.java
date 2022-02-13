/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Opswfldsv;
import opsw.uci.prj.repositories.OpswfldsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class OpswfldsvServiceImpl implements OpswfldsvService
{

  @Autowired
  private OpswfldsvRepository OpswfldsvRepository;

  @Override
  public Opswfldsv OpswfldsvSelect01(String code) throws CatException
  {
    Opswfldsv opswfldsv = null;
    try
    {
      opswfldsv = this.OpswfldsvRepository.findById(code).orElse(null);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return opswfldsv;
  }

  @Override
  public List<Opswfldsv> OpswfldsvList01() throws CatException
  {
    List<Opswfldsv> vlist = null;
    try
    {
      vlist = (List<Opswfldsv>) this.OpswfldsvRepository.findAll();
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vlist;
  }

}
