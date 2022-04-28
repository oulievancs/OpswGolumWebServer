/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.controllers;

import javax.annotation.security.RolesAllowed;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.constants.OpswWebConst;
import opsw.uci.prj.globals.OpswRolesAllowed;
import opsw.uci.prj.logic.OpswExceptionHandler;
import opsw.uci.prj.services.Assets00Service;
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

  @RolesAllowed(value =
  {
    OpswRolesAllowed.UCI_ADMIN
  })
  @DeleteMapping(OpswWebConst.OPSW_CONTROLLER_ASSETS00_DELETE02)
  public void Assets00Delete02(@PathVariable("asset") Long assetId) throws Exception
  {
    try
    {
      this.Assets00Service.Assets00DeleteAll(assetId);
    }
    catch (Exception ex)
    {
      OpswExceptionHandler.HandleCatExceptionRest(ex);
    }
  }
}
