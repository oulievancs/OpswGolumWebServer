/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author e.oulis
 */
@Configuration
public class OpswWebMvcConfig implements WebMvcConfigurer
{

  @Override
  public void addInterceptors(InterceptorRegistry registry)
  {
    registry.addInterceptor(new OpswInterceptorServ01());
  }
}
