/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.application.ApplicationProperties;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.globals.OpswErpRecords01;
import opsw.uci.prj.globals.OpswLanguage;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.cat.CatThmlfObject02;
import opsw.uci.prj.utils.OpswSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author oulis
 */
public class OpswMenuDo01
{

  public static List<OpswMenu01> MakeMenu01(HttpServletRequest request, ModelAndView model,
          OpswLoginVars iloginVars, MessageSource ms, ApplicationProperties appProps
  ) throws CatException
  {
    List<OpswMenu01> menu = new ArrayList<>();
    OpswMenu01 choice = null;
    CatThmlfObject02 xrhshObj = null;
    String requstedUrl = request.getRequestURI();

    Authentication vauth = OpswSecurityUtils.OpswSecurityGetAuthentication();

    if (vauth == null || !vauth.isAuthenticated() /**
             * request.isUserInRole("uci-user")
             */
            )
    {
      xrhshObj = OpswErpRecords01.OpswGetXrhshObj((short) 0);

      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.LOGIN", "Log In"));
      choice.setPath("/login");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);
    }
    else
    {
      xrhshObj = OpswErpRecords01.OpswGetXrhshObj(iloginVars.getEtai());

      //Choice for HOME
      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.HOME", "Home"));
      choice.setPath(Ad2(iloginVars, "/home"));
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      choice.setIcon("fas fa-home");
      menu.add(choice);

      //Choice for Gram00
      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.GRAM00", "Gram00"));
      choice.setPath(Ad2(iloginVars, "/gram/gram00/list01"));
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);

      //Choice for MasterFile
      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.MASTER_FILE", "Maste File"));
      choice.setPath(Ad2(iloginVars, "/assets/assets00/list01"));
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);

      List<OpswMenu01> subMenu = new ArrayList<>();
      OpswMenu01 choice1 = new OpswMenu01();
      //Choice inport File
      choice1.setCaption(Ad1(iloginVars, ms, "MENOU00.IMPORT_FILE", "Import File"));
      choice1.setPath(Ad2(iloginVars, "/actions/inportfile"));
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      choice1 = new OpswMenu01();
      choice1.setCaption(Ad1(iloginVars, ms, "MENOU00.EXPORT_FILE", "Export File"));
      choice1.setPath(Ad2(iloginVars, "/actions/exportfile"));
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      //choice for Actions
      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.ACTIONS", "Actions"));
      choice.setPath("");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(true);
      choice.setSubs(subMenu);
      choice.setId("actionsSub");
      choice.setIcon("fas fa-paper-plane");

      menu.add(choice);

      subMenu = new ArrayList<>();
      choice1 = new OpswMenu01();
      //Choice inport File
      choice1.setCaption(Ad1(iloginVars, ms, "MENOU00.NOTARY_EDIT", "Edit"));
      choice1.setPath(Ad2(iloginVars, "/notary/ed01"));
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      choice1 = new OpswMenu01();
      choice1.setCaption(Ad1(iloginVars, ms, "MENOU00.NOTARY_INDEX", "Index"));
      choice1.setPath(Ad2(iloginVars, "/notary/list01"));
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);

      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.NOTARY", "Notary"));
      choice.setPath("");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(true);
      choice.setSubs(subMenu);
      choice.setId("notarysub");
      choice.setIcon("fas fa-briefcase");

      menu.add(choice);

      /*choice = new OpswMenu01();
      choice.setCaption("Tab Test");
      choice.setPath("/actions/testtab");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);

      menu.add(choice);*/
      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.USAGE", "Usage (Database)"));
      choice.setPath(Ad2(iloginVars, "/init1"));
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      choice.setIcon("fas fa-database");

      menu.add(choice);

      subMenu = new ArrayList<>();
      choice1 = new OpswMenu01();
      //Choice inport File
      choice1.setCaption(iloginVars.getLoginUser());
      choice1.setPath("#");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      choice1 = new OpswMenu01();
      choice1.setCaption(Ad1(iloginVars, ms, "MENOU00.LOGOUT", "Logout"));
      choice1.setPath(Ad2(iloginVars, "/logout"));
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);

      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.ACCOUNT", "Account"));
      choice.setPath(Ad2(iloginVars, ""));
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(true);
      choice.setSubs(subMenu);
      choice.setId("accountsub");
      choice.setIcon("fas fa-user-alt");

      menu.add(choice);

      choice = new OpswMenu01();
      choice.setCaption(Ad1(iloginVars, ms, "MENOU00.CHANGE_LANGUAGE", "Language"));
      choice.setPath(Ad3(iloginVars, request));
      choice.setIsActive(false);
      choice.setHaveSub(false);
      Map<String, String> langImg = new HashMap<>();
      langImg.put(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EN,
              OpswSystemWebServer01.OPSW_SERVLET_CONTEXT_PATH + "/static/assets/icons8-greece-48.png");
      langImg.put(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EL,
              OpswSystemWebServer01.OPSW_SERVLET_CONTEXT_PATH + "/static/assets/icons8-usa-48.png");
      choice.setImage(Ad4(iloginVars, langImg));

      menu.add(choice);

      /*choice = new OpswMenu01();
      choice.setCaption("Logout");
      choice.setPath("/logout");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);

      menu.add(choice);*/
    }

    if (model != null)
    {
      model.addObject("app_prop", appProps);
      model.addObject("menu", menu);
      model.addObject("xrhsh", xrhshObj);
      model.addObject("opsw_path", model.getView());
    }

    return menu;
  }

  private static String Ad1(OpswLoginVars iloginVars, MessageSource ms,
          String icode, String ielse) throws CatException
  {
    String res = null;
    try
    {
      if (ms != null)
      {
        byte ilang = 0;
        if (iloginVars.getLang() != null)
        {
          if (iloginVars.getLang().equals(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EL))
          {
            ilang = 1;
          }
        }

        if (ilang == 0)
        {
          res = ms.getMessage(icode, null, Locale.ENGLISH);
        }
        else if (ilang == 1)
        {
          res = ms.getMessage(icode, null, new Locale("el"));
        }
      }
      else
      {
        res = ielse;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  private static String Ad2(OpswLoginVars iloginVars, String ipath) throws CatException
  {
    String res = null;
    try
    {
      byte ilang = 0;
      if (iloginVars.getLang() != null)
      {
        if (iloginVars.getLang().equals(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EL))
        {
          ilang = 1;
        }
      }

      if (ilang == 0)
      {
        res = ipath;
      }
      else if (ilang == 1)
      {
        res = ipath + "?" + OpswLanguage.OPSW_LANG_PARAMETER + "=" + "el";
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  private static String Ad3(OpswLoginVars iloginVars, HttpServletRequest request) throws CatException
  {
    String res = null;
    String symbol = "?";
    try
    {
      res = request.getRequestURI().substring(request.getContextPath().length());
      byte vlang = 0;
      if (iloginVars.getLang() != null)
      {
        if (iloginVars.getLang().equals(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EL))
        {
          vlang = 1;
        }
      }

      Set<String> keySet = request.getParameterMap().keySet();

      if (keySet != null && !keySet.isEmpty())
      {
        symbol = "&";
        res += "?";

        Iterator<String> vItKey = keySet.iterator();

        int ii = 0;
        while (vItKey.hasNext())
        {
          String vKeyParam = vItKey.next();
          if (!vKeyParam.equals(OpswLanguage.OPSW_LANG_PARAMETER))
          {
            String[] valuesParam = request.getParameterMap().get(vKeyParam);
            String vValParam = valuesParam[0];

            if (ii > 0)
            {
              res += "&";
            }
            res += vKeyParam + "=" + String.valueOf(vValParam);
          }
          ii++;
        }
      }

      if (vlang == 0)
      {
        res = res + symbol + OpswLanguage.OPSW_LANG_PARAMETER + "=" + "el";
      }
      else if (vlang == 1)
      {
        //είναι ελλήνικος και πάει άγγλικος
        res = res + symbol + OpswLanguage.OPSW_LANG_PARAMETER + "=" + "en";
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }

  private static String Ad4(OpswLoginVars iloginVars, Map<String, String> images) throws CatException
  {
    String res = null;
    try
    {
      byte vlang = 0;
      res = images.get(OpswLoginVars.OPSW_LOGIN_VARS_LANG_EN);
      if (iloginVars.getLang() != null)
      {
        res = images.get(iloginVars.getLang());
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return res;
  }
}
