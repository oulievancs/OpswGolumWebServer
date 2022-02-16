/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.api.progress;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import opsw.uci.prj.cat.CatException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 *
 * @author oulis
 */
public class OpswProgressUtils
{

  public static ResponseBodyEmitter OpswCreateResponseBodyEmitter(OpswProcess process)
          throws CatException
  {
    ResponseBodyEmitter responseBodyEmitter = null;
    try
    {
      responseBodyEmitter = new ResponseBodyEmitter();
      ExecutorService service = Executors.newSingleThreadExecutor();

      OpswProgressEmitter opswPrgEmi = new OpswProgressEmitter();
      opswPrgEmi.setResponseBodyEmitter(responseBodyEmitter);

      service.execute(opswPrgEmi);

      OpswProgressEvent progressEvent = new OpswProgressEvent();
      progressEvent.setProgressEmitter(opswPrgEmi);

      OpswProcessParams vprocessParams = new OpswProcessParams();
      vprocessParams.setProgressEvent(progressEvent);

      process.DoProcess(vprocessParams);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return responseBodyEmitter;
  }
}
