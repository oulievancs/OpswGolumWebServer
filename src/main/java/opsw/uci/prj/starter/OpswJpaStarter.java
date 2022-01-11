/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.starter;

import java.util.Properties;
import javax.sql.DataSource;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.system.OpswSystemWebServer01;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author oulis
 */
@Configuration
public class OpswJpaStarter
{

  @Autowired
  private Environment env;

//  @Bean("datasource")
//  @Primary
//  public DataSource dataSource() throws Exception
//  {
////    OpswLogger.LoggerLogDebug("ENV Resource: " + env.getProperty("jdbc.url"));
//    DataSource ds = null;
//    try
//    {
//      ds = OpswSystemWebServer01.OpswDataSourceServer(
//              OpswSystemWebServer01.DEFAULT_ORCLH_MINLO, OpswSystemWebServer01.DetermineWebServer(), env);
//    }
//    catch (Exception ex)
//    {
//      OpswLogger.LoggerLogException(ex);
//    }
//    return ds;
//  }

//  @Bean(name = "transactionManager")
//  public JpaTransactionManager jpaTransactionManager() throws Exception
//  {
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//    return transactionManager;
//  }
//
//  //adding for future use
//  private HibernateJpaVendorAdapter vendorAdaptor()
//  {
//    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//    return vendorAdapter;
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception
//  {
//
//    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
//    entityManagerFactoryBean.setDataSource(dataSource());
//    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//    entityManagerFactoryBean.setPackagesToScan("opsw.uci.prj.entity");
//    entityManagerFactoryBean.setJpaProperties(addProperties());
//
//    return entityManagerFactoryBean;
//  }
//
//  private Properties addProperties()
//  {
//    Properties properties = new Properties();
//    properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//    properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//    properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//    properties.setProperty("hibernate.naming.physical-strategy", env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
//    //properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
//    // we can add 
//    return properties;
//  }
}
