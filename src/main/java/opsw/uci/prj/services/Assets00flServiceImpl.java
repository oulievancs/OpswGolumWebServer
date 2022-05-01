/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.Calendar;
import java.util.List;
import opsw.uci.prj.arifacts.OpswTransactional;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00fl;
import opsw.uci.prj.entity.Assets00flKey;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.repositories.Assets00flRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Service
@Component
public class Assets00flServiceImpl implements Assets00flService
{

  @Autowired
  private Assets00flRepository Assets00flRepository;

  @Override
  public Assets00fl Assets00flSelect01(Assets00flKey assets00flKey) throws CatException
  {
    return (Assets00fl) this.Assets00flRepository.findById(assets00flKey).orElse(null);
  }

  @Override
  public Assets00fl Assets00flSelect02(Long asset, String fld) throws CatException
  {
    Assets00flKey assets00flKey = new Assets00flKey();
    assets00flKey.setAsset(asset);
    assets00flKey.setFld(fld);

    return this.Assets00flSelect01(assets00flKey);
  }

  @Override
  public Assets00fl Assets00flInsert01(Assets00fl assets00fl) throws CatException
  {
    Assets00fl vassets00fl = this.Assets00flRepository.saveAndFlush(assets00fl);
    return vassets00fl;
  }

  @Override
  public Assets00fl Assets00flPost01(Assets00fl assets00fl) throws CatException
  {
    Assets00fl vassets00fl = null;

    Assets00flKey assets00flKey = new Assets00flKey();
    assets00flKey.setAsset(assets00fl.getAsset());
    assets00flKey.setFld(assets00fl.getFld());

    if (!this.Assets00flRepository.existsById(assets00flKey))
    {
      vassets00fl = this.Assets00flInsert01(assets00fl);
    }
    else
    {
      vassets00fl = this.Assets00flUpdate01(assets00fl);
    }

    return vassets00fl;
  }

  @Override
  public Assets00fl Assets00flUpdate01(Assets00fl assets00fl) throws CatException
  {
    Assets00fl vassets00fl = this.Assets00flRepository.saveAndFlush(assets00fl);
    return vassets00fl;
  }

  @Override
  public void Assets00flDelete01(Assets00flKey assets00flKey) throws CatException
  {
    Assets00fl vassets00fl = this.Assets00flSelect01(assets00flKey);
    if ((assets00flKey != null) && vassets00fl != null)
    {
      this.Assets00flRepository.delete(vassets00fl);
    }
  }

  @Override
  public List<Assets00fl> Assets00flList01(Long id) throws CatException
  {
    List<Assets00fl> result = null;
    try
    {
      if (id != null)
      {
        result = this.Assets00flRepository.Assets00flFindByAsset(id);
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }

    return result;
  }

  @Override
  public Assets00fl Assets00flPost02(Assets00fl assets00fl) throws CatException
  {
    Assets00fl result = null;
    try
    {
      result = this.Assets00flSelect02(assets00fl.getAsset(), assets00fl.getFld());
      if (result != null)
      {
        Byte vType = result.getType();
        OpswReflection.OpswReflectionCopyObjectFields(assets00fl, result, Assets00fl.class);
        result.setType(vType);
        result = this.Assets00flPost01(result);
      }

    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return result;
  }

  @Override
  @OpswTransactional
  public void Assets00flDelete02(Calendar date_createFrom, Calendar date_createTo) throws CatException
  {
    try
    {
      this.Assets00flRepository.Assets00flDelete01(date_createFrom, date_createTo);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }

}
