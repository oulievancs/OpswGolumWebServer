/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author n.oulis
 */
@Component
@Service
public class ApplicationProperties
{
  @Value("${application.version}")
  private String appVersion;

  public ApplicationProperties()
  {
  }
 
  
  public String getAppVersion()
  {
    return appVersion;
  }

  public void setAppVersion(String appVersion)
  {
    this.appVersion = appVersion;
  }
  
  
  
}
