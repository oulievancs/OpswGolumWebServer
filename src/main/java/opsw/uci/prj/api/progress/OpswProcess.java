/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.progress;

import opsw.uci.prj.cat.CatException;

/**
 *
 * @author oulis
 */
public interface OpswProcess
{

  public void DoProcess(OpswProcessParams params) throws CatException;
}
