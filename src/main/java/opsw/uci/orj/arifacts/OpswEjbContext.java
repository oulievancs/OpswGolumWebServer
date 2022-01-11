/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.orj.arifacts;

/**
 *
 * @author e.oulis
 */
public class OpswEjbContext
{

  private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

  public static String getCurrentTenant()
  {
    return currentTenant.get();
  }

  public static void clear()
  {
    currentTenant.remove();
  }
}
