package opsw.uci.prj.starter;

import opsw.uci.prj.cat.OpswEntityManagerJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Για την ρύθμιση των DataSources στον Tomcat πάμε στο conf/server.xml και βάζουμε
 * στο <GlobalNamingResources/> το εξής:
 * 
 * 
 * <!--https://examples.javacodegeeks.com/enterprise-java/tomcat/tomcat-connection-pool-configuration-example/-->
  <Resource auth="Container"
            type="javax.sql.DataSource"
            name="ORCLH_MINLO"
            global="ORCLH_MINLO"
            factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
            driverClassName="com.mysql.jdbc.Driver"
            description="ORCLH MINLO OSS database."
            url="jdbc:mysql://192.168.1.17:3306/OPSWDB?useSSL=false&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"
            username="root1"
            password="rootP"
            maxTotal="10"
            maxIdle="10"
            maxWaitMillis="10000"
            removeAbandonedTimeout="300"
            defaultAutoCommit="true"
  />
 *
 * έπειτα πάμε στο config/context.xml και βάζουμε το εξής:
 * 
 *  
 * <ResourceLink name="ORCLH_MINLO"
               global="ORCLH_MINLO"
               auth="Container"
               type="javax.sql.DataSource"
   />
 * 
 * .
 * @author oulis
 */
@SpringBootApplication
@ComponentScan(
        basePackageClasses =
        {
          //Gram00Controller.class,
          OpswJpaStarter.class,
          OpswEntityManagerJpa.class
        },
        basePackages =
        {
          "opsw.uci.prj.services",
          "opsw.uci.prj.controllers",
          "opsw.uci.prj.exception.controllers"
        }
)
@EnableJpaRepositories(
        basePackages =
        {
          "opsw.uci.prj.repositories"
        }
)
@EntityScan(
        basePackages =
        {
          "opsw.uci.prj.entity"
        }
)
public class OpswgolumwebservApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(OpswgolumwebservApplication.class, args);
  }

}
