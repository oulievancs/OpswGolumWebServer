/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.interceptors;

import opsw.uci.prj.application.ApplicationProperties;
import opsw.uci.prj.globals.OpswLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 *
 * @author e.oulis
 */
@Configuration
public class OpswWebMvcConfig implements WebMvcConfigurer
{

  @Autowired
  private ApplicationProperties appProp;

  @Override
  public void addInterceptors(InterceptorRegistry registry)
  {
    OpswInterceptorServ01 o = new OpswInterceptorServ01();
    o.setMessageSource(this.messageSource());
    o.setAppProp(this.appProp);

    registry.addInterceptor(o)
            .addPathPatterns("/**")
            .excludePathPatterns("/resources/**", "/static/**");
    registry.addInterceptor(localeChangeInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/resources/**", "/static/**");
  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer)
  {
    configurer.setTaskExecutor(mvcTaskExecutor());
    configurer.setDefaultTimeout(30_000);
  }

  @Bean
  public ThreadPoolTaskExecutor mvcTaskExecutor()
  {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setThreadNamePrefix("mvc-task-");
    return taskExecutor;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor()
  {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName(OpswLanguage.OPSW_LANG_PARAMETER);
    return lci;
  }

  @Bean
  public MessageSource messageSource()
  {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("i18n/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
