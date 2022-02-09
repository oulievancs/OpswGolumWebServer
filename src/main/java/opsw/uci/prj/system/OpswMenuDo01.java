/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.system;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.globals.OpswErpRecords01;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.records.cat.CatThmlfObject02;
import opsw.uci.prj.utils.OpswSecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author oulis
 */
public class OpswMenuDo01
{

  public static List<OpswMenu01> MakeMenu01(HttpServletRequest request, ModelAndView model) throws CatException
  {
    List<OpswMenu01> menu = new ArrayList<>();
    OpswMenu01 choice = null;
    OpswLoginVars logivars = null;
    CatThmlfObject02 xrhshObj = null;
    String requstedUrl = request.getRequestURI();

    Authentication vauth = OpswSecurityUtils.OpswSecurityGetAuthentication();

    if (vauth == null || !vauth.isAuthenticated() /**
             * request.isUserInRole("uci-user")
             */
            )
    {
      choice = new OpswMenu01();
      choice.setCaption("Log in");
      choice.setPath("/login");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);
    }
    else
    {
      //Choice for HOME
      choice = new OpswMenu01();
      choice.setCaption("Home");
      choice.setPath("/home");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);

      //Choice for Gram00
      choice = new OpswMenu01();
      choice.setCaption("Gram00");
      choice.setPath("/gram/gram00/list01");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);

      //Choice for MasterFile
      choice = new OpswMenu01();
      choice.setCaption("Maste File");
      choice.setPath("/assets/assets00/list01");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);
      menu.add(choice);

      List<OpswMenu01> subMenu = new ArrayList<>();
      OpswMenu01 choice1 = new OpswMenu01();
      //Choice inport File
      choice1.setCaption("Inport File");
      choice1.setPath("/actions/inportfile");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      choice1 = new OpswMenu01();
      choice1.setCaption("Export File");
      choice1.setPath("/actions/exportfile");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      //choice for Actions
      choice = new OpswMenu01();
      choice.setCaption("Actions");
      choice.setPath("");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(true);
      choice.setSubs(subMenu);
      choice.setId("actionsSub");

      menu.add(choice);
      
      subMenu = new ArrayList<>();
      choice1 = new OpswMenu01();
      //Choice inport File
      choice1.setCaption("Edit");
      choice1.setPath("/notary/ed01");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      choice1 = new OpswMenu01();
      choice1.setCaption("Index");
      choice1.setPath("/notary/list01");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      
      choice = new OpswMenu01();
      choice.setCaption("Notary");
      choice.setPath("");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(true);
      choice.setSubs(subMenu);
      choice.setId("notarysub");

      menu.add(choice);

      choice = new OpswMenu01();
      choice.setCaption("Tab Test");
      choice.setPath("/actions/testtab");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);

      menu.add(choice);
      
      choice = new OpswMenu01();
      choice.setCaption("Usage (Database)");
      choice.setPath("/init1");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);

      menu.add(choice);
      
      
      subMenu = new ArrayList<>();
      choice1 = new OpswMenu01();
      //Choice inport File
      choice1.setCaption("Edit");
      choice1.setPath("/notary/ed01");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      choice1 = new OpswMenu01();
      choice1.setCaption("Index");
      choice1.setPath("/notary/list01");
      choice1.setIsActive(requstedUrl.contains(choice.getPath()));
      choice1.setHaveSub(false);
      subMenu.add(choice1);
      
      choice = new OpswMenu01();
      choice.setCaption("Notary");
      choice.setPath("");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(true);
      choice.setSubs(subMenu);
      choice.setId("notarysub");

      menu.add(choice);
      
      choice = new OpswMenu01();
      choice.setCaption("Logout");
      choice.setPath("/logout");
      choice.setIsActive(requstedUrl.contains(choice.getPath()));
      choice.setHaveSub(false);

      menu.add(choice);
      
      logivars = new OpswLoginVars();
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, logivars);
      xrhshObj = OpswErpRecords01.OpswGetXrhshObj(logivars.getEtai());
      
    }

    if (model != null)
    {
      model.addObject("menu", menu);
      model.addObject("xrhsh", xrhshObj);
      model.addObject("opsw_path", model.getView());
    }

    return menu;
  }
}
