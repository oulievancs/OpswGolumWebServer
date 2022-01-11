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

  public static final String OPSW_LOGIN_VARS = "opsw.loginvars";
  public static final String OPSW_LOGIN_USER_CONST = "opsw.loginvars.loginUser";
  public static final String OPSW_LOGIN_ETAI_CONST = "opsw.loginvars.loginEtai";
  public static final String OPSW_LOGIN_CONNECTION_DS = "opsw.loginvars.opsw_cookie_connection_ds";

  private String loginUser;
  private short etai;
  private String connectionDs;

  public OpswLoginVars()
  {
    super();
    this.loginUser = null;
    this.etai = 0;
    this.connectionDs = null;
  }
  
  public static void copyFrom(OpswLoginVars from, OpswLoginVars to)
  {
    to.setConnectionDs(from.getConnectionDs());
    to.setEtai(from.getEtai());
    to.setLoginUser(from.getLoginUser());
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

  public String getConnectionDs()
  {
    return connectionDs;
  }

  public void setConnectionDs(String connectionDs)
  {
    this.connectionDs = connectionDs;
  }
}
