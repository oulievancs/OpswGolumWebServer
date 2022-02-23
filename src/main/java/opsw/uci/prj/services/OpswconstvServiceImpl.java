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
import opsw.uci.prj.repositories.OpswconstsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class OpswconstvServiceImpl implements OpswconstvService
{

  @Autowired
  private OpswconstsvRepository OpswconstsvRepository;

  @Override
  public List<CatThmlfObject01> FieldsList01(String constCode)
          throws CatException
  {
    return (List<CatThmlfObject01>) this.OpswconstsvRepository.FieldsList01(constCode);
  }

  @Override
  public List<Opswconstsv> OpswconstvList01(String code) throws CatException
  {
    return (List<Opswconstsv>) this.OpswconstsvRepository.OpswconstsvList01(code);
  }

  @Override
  public Opswconstsv OpswconstvSelect01(OpswconstsvKey opswconstsvKey) throws CatException
  {
    return (Opswconstsv) this.OpswconstsvRepository.findById(opswconstsvKey).orElse(null);
  }

  @Override
  public Opswconstsv OpswconstvSelect02(String code, String value) throws CatException
  {
    OpswconstsvKey opswconstsvKey = new OpswconstsvKey();
    opswconstsvKey.setCode(code);
    opswconstsvKey.setField(value);
    return this.OpswconstvSelect01(opswconstsvKey);
  }
}
