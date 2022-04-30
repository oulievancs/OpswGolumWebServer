/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.constants;

/**
 *
 * @author oulis
 */
public class OpswWebConst
{

  /**
   * MAIN
   */
  public static final String OPSW_CONTROLLER_MAIN = "/";
  public static final String OPSW_CONTROLLER_MAIN_HOME = "/home";
  public static final String OPSW_CONTROLLER_MAIN_LOGOUT = "/logout";
  public static final String OPSW_CONTROLLER_MAIN_LOGIN = "/login";
  public static final String OPSW_CONTROLLER_MAIN_INIT1 = "/init1";
  public static final String OPSW_CONTROLLER_MAIN_INIT1_POST = "/init1/post";

  /**
   * ACTIONS
   */
  public static final String OPSW_CONTROLLER_ACTIONS = "/actions";
  public static final String OPSW_CONTROLLER_ACTIONS_INPORT_FILE = "/inportfile";
  public static final String OPSW_CONTROLLER_ACTIONS_INPORT_FILE_POST = "/inportfile/post";
  public static final String OPSW_CONTROLLER_ACTIONS_EXPORT_FILE_POST02 = "/exportfile/post02";
  public static final String OPSW_CONTROLLER_ACTIONS_EXPORT_FILE = "/exportfile";
  public static final String OPSW_CONTROLLER_ACTIONS_EXPORT_FILE_POST = "/exportfile/post";

  /**
   * ASSETS00
   */
  public static final String OPSW_CONTROLLER_ASSETS00 = "/assets";
  public static final String OPSW_CONTROLLER_ASSETS00_LIST01 = "/assets00/list01";
  public static final String OPSW_CONTROLLER_ASSETS00_LIST01_POST = "/assets00/list01";
  public static final String OPSW_CONTROLLER_ASSETS00_ED01 = "/assets00/ed01";
  public static final String OPSW_CONTROLLER_ASSETS00_ED01_POST01 = "/assets00/ed01/post01";
  public static final String OPSW_CONTROLLER_ASSETS00_FILLFROMCRM = "/assets00/fillfromcrm";
  public static final String OPSW_CONTROLLER_ASSETS00_DELETE01 = "/assets00/delete01/{asset}";
  public static final String OPSW_CONTROLLER_ASSETS00_DELETE02 = "/assets00/delete02/{asset}";
  public static final String OPSW_CONTROLLER_ASSETS00_REMOVE_NOTARY = "/assets00/removeNotary/{asset}";

  /**
   * GRAM00
   */
  public static final String OPSW_CONTROLLER_GRAM = "/gram";
  public static final String OPSW_CONTROLLER_GRAM_LIST01 = "/gram00/list01";
  public static final String OPSW_CONTROLLER_GRAM_ED01 = "/gram00/ed01";
  public static final String OPSW_CONTROLLER_GRAM_ED01_POST01 = "/gram00/ed01/post01";
  public static final String OPSW_CONTROLLER_GRAM_GRAM01_ED01 = "/gram01/ed01/{gram}";
  public static final String OPSW_CONTROLLER_GRAM_GRAM01_ED01_POST01 = "/gram01/ed01/post01/{gram}";
  public static final String OPSW_CONTROLLER_GRAM_GRAM00_DELETE01 = "/gram00/delete01/{gram}";
  public static final String OPSW_CONTROLLER_GRAM_GRAM01_DELETE01 = "/gram01/delete01/{gram}/{senu}";

  /**
   * NOTARY
   */
  public static final String OPSW_CONTROLLER_NOTARY = "/notary";
  public static final String OPSW_CONTROLLER_NOTARY_LIST01 = "/list01";
  public static final String OPSW_CONTROLLER_NOTARY_ED01 = "/ed01";
  public static final String OPSW_CONTROLLER_NOTARY_ED01_POST01 = "/ed01/post01";
  public static final String OPSW_CONTROLLER_NOTARY_DELETE01 = "/delete01/{symb_id}";

  /**
   * MODALS
   */
  public static final String OPSW_CONTROLLER_MODAL = "/modals";
  public static final String OPSW_CONTROLLER_MODAL_SYMB_MODAL01 = "/symb/modal01";
  public static final String OPSW_CONTROLLER_MODAL_SYMB_MODAL01_POST = "/symb/modalpost/{asset}";

  /**
   *
   */
  public static final String OPSW_CONTROLLER_IMPORT_EXPORT = "/import_export";
  public static final String OPSW_CONTROLLER_IMPORT_EXPORT_IMPORT = "/import/{file}";
  public static final String OPSW_CONTROLLER_IMPORT_EXPORT_EXPORT = "/export/{file}/{iid1}";
}
