/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaServiceBase;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram01;
import opsw.uci.prj.entity.Gram01Key;
import opsw.uci.prj.records.Gram01Rec01;
import opsw.uci.prj.records.cat.CatThmlfObject01;

/**
 *
 * @author oulis
 */
public interface Gram01Service extends CatEjbJpaServiceBase
{

  public List<Gram01> Gram01List01(Long gram) throws CatException;

  public Long Gram01MaxSenu(Long gram) throws CatException;

  public Gram01 Gram01Select01(Long gram, Long senu) throws CatException;

  public Gram01 Gram01Post01(Gram01 gram01) throws CatException;

  public Gram01 Gram01Post02(Long gram, Long senu, Gram01 gram01) throws CatException;

  public void Gram01Delete01(Long gram, Long senu) throws CatException;

  public void Gram01Delete02(Gram01Key key) throws CatException;

  public List<Gram01Rec01> Gram01Rec01List01(Long gram) throws CatException;

  public List<CatThmlfObject01> FieldsList01(String constCode) throws CatException;

  public List<Gram01> Gram01List02(Long gram) throws CatException;
}
