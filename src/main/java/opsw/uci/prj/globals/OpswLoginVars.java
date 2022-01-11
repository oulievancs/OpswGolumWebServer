/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.globals;

/**
 *
 * @author oulis
 */
public class OpswLoginVars
{

  public static final String LOGIN_USER_CONST = "opsw.loginvars.loginUser";
  public static final String LOGIN_ETAI_CONST = "opsw.loginvars.loginEtai";

  private String loginUser;
  private short etai;

  public OpswLoginVars()
  {
    super();
    this.loginUser = null;
    this.etai = 0;
  }

  public String getLoginUser()
  {
    return loginUser;
  }

  public void setLoginUser(String loginUser)
  {
    this.loginUser = loginUser;
  }

  public short getEtai()
  {
    return etai;
  }

  public void setEtai(short etai)
  {
    this.etai = etai;
  }
}
