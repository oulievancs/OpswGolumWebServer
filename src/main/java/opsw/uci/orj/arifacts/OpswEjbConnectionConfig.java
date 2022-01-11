/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.orj.arifacts;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import opsw.uci.prj.logging.OpswLogger;
import opsw.uci.prj.system.OpswSystemWebServer01;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author e.oulis
 */
@Configuration
@EnableConfigurationProperties(
        {
          JpaProperties.class
        }
)
//@ImportResource(locations = { "classpath:applicationContent.xml" })
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(
        basePackages =
        {
          "opsw.uci.prj.repositories"
        },
        transactionManagerRef = "transactionManager"
)
public class OpswEjbConnectionConfig
{

  @Autowired
  private DataSourceProperties properties;

  @Autowired
  private JpaProperties jpaProperties;

  @Autowired
  private Environment env;

  @Bean
  public MultiTenantConnectionProvider multiTenantConnectionProvider()
  {
    return new OpswDatasourceConnectionProvider();
  }

  @Bean
  public CurrentTenantIdentifierResolver currentTenantIdentifierResolver()
  {
    return new OpswCurrentDatasourceConnection();
  }

  @Bean(name = "opswDataSources")
  public Map<String, DataSource> opswDataSources()
  {
    Map<String, DataSource> dsMap = new TreeMap<>();
    try
    {
      OpswSystemWebServer01.OpswDataSourcesFill01(dsMap, OpswSystemWebServer01.DetermineWebServer(), env);
    }
    catch (Exception ex)
    {
      OpswLogger.LoggerLogException(ex);
    }
    return dsMap;
  }

  @PersistenceContext
  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(MultiTenantConnectionProvider multiTenantConnectionProvider,
          CurrentTenantIdentifierResolver currentTenantIdentifierResolver)
  {

    Map<String, Object> hibernateProps = new LinkedHashMap<>();
    hibernateProps.putAll(this.jpaProperties.getProperties());
    hibernateProps.put(org.hibernate.cfg.Environment.MULTI_TENANT,
            MultiTenancyStrategy.DATABASE);
    hibernateProps.put(org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER,
            multiTenantConnectionProvider);
    hibernateProps.put(org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER,
            currentTenantIdentifierResolver);
    hibernateProps.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
    hibernateProps.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
    hibernateProps.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
    hibernateProps.put("hibernate.naming.physical-strategy",
            env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));

    // No dataSource is set to resulting entityManagerFactoryBean
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setPackagesToScan("opsw.uci.prj.entity");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setJpaPropertyMap(hibernateProps);

    return em;
  }

  @Bean
  public EntityManagerFactory entityManagerFactory(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean)
  {
    return entityManagerFactoryBean.getObject();
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory)
  {
    JpaTransactionManager jpa = new JpaTransactionManager();
    jpa.setEntityManagerFactory(entityManagerFactory);
    return jpa;
  }

//  private DataSource initialize(DataSource dataSource)
//  {
//    ClassPathResource schemaResource = new ClassPathResource("schema.sql");
//    ClassPathResource dataResource = new ClassPathResource("data.sql");
//    ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schemaResource, dataResource);
//    populator.execute(dataSource);
//    return dataSource;
//  }
}
