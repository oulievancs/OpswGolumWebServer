/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.progress;

/**
 *
 * @author oulis
 */
public class OpswProcessParams
{

  private OpswProgressEvent progressEvent;

  public OpswProcessParams()
  {
    this.progressEvent = null;
  }

  public OpswProgressEvent getProgressEvent()
  {
    return progressEvent;
  }

  public void setProgressEvent(OpswProgressEvent progressEvent)
  {
    this.progressEvent = progressEvent;
  }
}
