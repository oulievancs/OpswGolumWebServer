/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00fl;
import opsw.uci.prj.entity.Assets00flKey;
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

}
