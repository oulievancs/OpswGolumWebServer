/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
public interface Assets00Service
{

  public List<Assets00> Assets00List01(Byte status);

  public List<Assets00> Assets00List02() throws CatException;

  public Assets00 Assets00Insert(Assets00 assets00) throws CatException;

  public Assets00 Assets00Post01(Assets00 assets00) throws CatException;

  public Assets00 Assets00Post02(Assets00 assets00, boolean postSymb)
          throws CatException;
}
