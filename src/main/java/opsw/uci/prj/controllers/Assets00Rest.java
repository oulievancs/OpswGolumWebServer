/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.globals.OpswRolesAllowed;
import opsw.uci.prj.interceptors.OpswCookies01;
import opsw.uci.prj.logic.OpswExceptionHandler;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.validations.OpswValidations01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oulis
 */
@RestController
@RequestMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00)
public class Assets00Rest
{

  @Autowired
  private Assets00Service Assets00Service;

  @DeleteMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_DELETE02)
  public void Assets00Delete02(@PathVariable("asset") Long assetId,
          HttpServletRequest request) throws Exception
  {
    try
    {
      Assers00DeleteAsset02_Internal(assetId, request);
    }
    catch (Exception ex)
    {
      OpswExceptionHandler.HandleCatExceptionRest(ex);
    }
  }

  private void Assers00DeleteAsset02_Internal(Long assetId, HttpServletRequest request)
          throws CatException
  {
    try
    {
      OpswLoginVars vlogV = new OpswLoginVars();
      OpswCookies01.OpswFillLoginVarsFromCookies01(request, vlogV);

      String[] vv =
      {
        OpswRolesAllowed.UCI_ADMIN
      };
      OpswValidations01.MakeAccessValidations(vlogV, vv, true);

      this.Assets00Service.Assets00DeleteAll(assetId);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
