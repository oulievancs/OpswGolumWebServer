package opsw.uci.prj.starter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.session.HttpSessionEventPublisher;

public class ServletInitializer extends SpringBootServletInitializer
{

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
  {
    return application.sources(OpswgolumwebservApplication.class);
  }

  @Bean
  public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher()
  {
    return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
  }

}
