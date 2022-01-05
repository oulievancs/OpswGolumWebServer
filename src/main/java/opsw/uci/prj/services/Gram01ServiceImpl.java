/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Gram01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class Gram01ServiceImpl implements Gram01Service
{

  @Autowired
  private Gram01Service Gram01Service;

  @Override
  public List<Gram01> Gram01List01(Long gram)
  {
    return (List<Gram01>) this.Gram01Service.Gram01List01(gram);
  }

}
