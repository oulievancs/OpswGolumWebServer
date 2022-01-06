/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.starter;

import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;

/**
 *
 * @author oulis
 */
@Configuration
public class OpswJpaStarter
{

  @Autowired
  private Environment env;

  @Bean("datasource")
  @Primary
  public DataSource dataSource() throws NamingException
  {
    System.out.println("ENV Resource: " + env.getProperty("jdbc.url"));
    return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
  }
}
