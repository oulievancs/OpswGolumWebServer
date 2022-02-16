/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.progress;

import opsw.uci.prj.cat.CatException;

/**
 *
 * @author oulis
 */
public class OpswProgressEvent
{

  private OpswProgressEmitter progressEmitter;

  public OpswProgressEvent()
  {
    super();
    this.progressEmitter = null;
  }

  public void SendProgress(double iprogress) throws CatException
  {
    this.progressEmitter.setPercent(iprogress);

    if (iprogress >= 100)
    {
      this.progressEmitter.setCompleted(true);
    }
  }

  public OpswProgressEmitter getProgressEmitter()
  {
    return progressEmitter;
  }

  public void setProgressEmitter(OpswProgressEmitter progressEmitter)
  {
    this.progressEmitter = progressEmitter;
  }
}
