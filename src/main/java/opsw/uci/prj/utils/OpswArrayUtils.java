/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.utils;

import java.util.List;
import opsw.uci.prj.cat.CatException;

/**
 *
 * @author oulis
 */
public class OpswArrayUtils
{

  public static boolean OpswArrayContainsAtLeastOne(List<?> ilist)
          throws CatException
  {
    boolean res = false;
    try
    {
      if (ilist != null && !ilist.isEmpty())
      {
        res = true;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return res;
  }
}
