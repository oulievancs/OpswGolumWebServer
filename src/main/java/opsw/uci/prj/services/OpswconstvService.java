/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.OpswconstsvKey;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface OpswconstvService
{

  public List<CatThmlfObject01> FieldsList01(String constCode) throws CatException;

  public List<Opswconstsv> OpswconstvList01(String code) throws CatException;

  public Opswconstsv OpswconstvSelect01(OpswconstsvKey opswconstsvKey) throws CatException;

  public Opswconstsv OpswconstvSelect02(String code, String value) throws CatException;
}
