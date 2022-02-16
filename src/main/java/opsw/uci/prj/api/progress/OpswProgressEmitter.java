/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.progress;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 *
 * @author oulis
 */
public class OpswProgressEmitter implements Runnable
{

  private ResponseBodyEmitter responseBodyEmitter;
  private boolean completed;
  private double percent;

  public OpswProgressEmitter()
  {
    super();
    this.responseBodyEmitter = null;
    this.completed = false;
    this.percent = 0;
  }

  @Override
  public void run()
  {
    try
    {
      while (!this.completed)
      {
        this.responseBodyEmitter.send(this.percent + " %", MediaType.TEXT_PLAIN);

        Thread.sleep(30);
      }
    }
    catch (Exception ex)
    {
      this.responseBodyEmitter.completeWithError(ex);
    }
    finally
    {
      this.responseBodyEmitter.complete();
    }
  }

  public ResponseBodyEmitter getResponseBodyEmitter()
  {
    return responseBodyEmitter;
  }

  public void setResponseBodyEmitter(ResponseBodyEmitter responseBodyEmitter)
  {
    this.responseBodyEmitter = responseBodyEmitter;
  }

  public boolean isCompleted()
  {
    return completed;
  }

  public void setCompleted(boolean completed)
  {
    this.completed = completed;
  }

  public double getPercent()
  {
    return percent;
  }

  public void setPercent(double percent)
  {
    this.percent = percent;
  }

}
