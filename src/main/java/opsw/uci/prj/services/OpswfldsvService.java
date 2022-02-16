/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaServiceBase;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Opswfldsv;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface OpswfldsvService extends CatEjbJpaServiceBase
{

  public Opswfldsv OpswfldsvSelect01(String code) throws CatException;

  public List<Opswfldsv> OpswfldsvList01() throws CatException;
}
