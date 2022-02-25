/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.starter;

import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.system.OpswTenants;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public class OpswUciApplicationRunner
{
  public static final String OPSW_UCI_STARTER_BEAN = "opswUciStarterBean";

  @Bean(name = OPSW_UCI_STARTER_BEAN)
  public void invokeMyEntryPoint()
  {
    try
    {

      OpswTenants.OpswJsonTenantsRead();
    }
    catch (Exception ex)
    {
      OpswLogger.LoggerLogException(ex);
    }
  }
}
