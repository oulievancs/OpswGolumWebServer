/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Symb;

/**
 *
 * @author oulis
 */
public interface SymbService
{

  public Symb SymbSelect01(Long id) throws CatException;

  public List<Symb> SymbList01(String param) throws CatException;

  public Symb SymbPost01(Symb symb) throws CatException;

  public List<Symb> SymbList02() throws CatException;

  public Symb SymbEDPost01(Symb symb) throws CatException;
}
