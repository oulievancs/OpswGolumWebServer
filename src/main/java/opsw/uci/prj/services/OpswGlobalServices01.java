/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author oulis
 */
@Component
@Service
public class OpswGlobalServices01
{

  private Gram00Service Gram00Service;
  private Gram01Service Gram01Service;
  private Assets00Service Assets00Service;
  private SymbService SymbService;

  public OpswGlobalServices01()
  {
    this.Gram00Service = null;
    this.Gram01Service = null;
    this.Assets00Service = null;
    this.SymbService = null;
  }

  public Gram00Service getGram00Service()
  {
    return Gram00Service;
  }

  public void setGram00Service(Gram00Service Gram00Service)
  {
    this.Gram00Service = Gram00Service;
  }

  public Gram01Service getGram01Service()
  {
    return Gram01Service;
  }

  public void setGram01Service(Gram01Service Gram01Service)
  {
    this.Gram01Service = Gram01Service;
  }

  public Assets00Service getAssets00Service()
  {
    return Assets00Service;
  }

  public void setAssets00Service(Assets00Service Assets00Service)
  {
    this.Assets00Service = Assets00Service;
  }

  public SymbService getSymbService()
  {
    return SymbService;
  }

  public void setSymbService(SymbService SymbService)
  {
    this.SymbService = SymbService;
  }
}
