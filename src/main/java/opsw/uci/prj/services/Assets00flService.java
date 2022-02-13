/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatEjbJpaServiceBase;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00fl;
import opsw.uci.prj.entity.Assets00flKey;

/**
 *
 * @author oulis
 */
public interface Assets00flService extends CatEjbJpaServiceBase
{

  public Assets00fl Assets00flSelect01(Assets00flKey assets00flKey) throws CatException;

  public Assets00fl Assets00flSelect02(Long asset, String fld) throws CatException;
  
  public List<Assets00fl> Assets00flList01(Long id) throws CatException;

  public Assets00fl Assets00flInsert01(Assets00fl assets00fl) throws CatException;

  public Assets00fl Assets00flPost01(Assets00fl assets00fl) throws CatException;
  
  public Assets00fl Assets00flPost02(Assets00fl assets00fl) throws CatException;

  public Assets00fl Assets00flUpdate01(Assets00fl assets00fl) throws CatException;

  public void Assets00flDelete01(Assets00flKey assets00flKey) throws CatException;
}
