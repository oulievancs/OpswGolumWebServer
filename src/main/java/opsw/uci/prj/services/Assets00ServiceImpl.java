/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.repositories.Assets00Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author oulis
 */
public class Assets00ServiceImpl implements Assets00Service
{

  @Autowired
  private Assets00Repository Assets00Repository;

  @Override
  public List<Assets00> Assets00List01(Byte status)
  {
    return (List<Assets00>) this.Assets00Repository.Assets00FindByStatus(status);
  }

}
