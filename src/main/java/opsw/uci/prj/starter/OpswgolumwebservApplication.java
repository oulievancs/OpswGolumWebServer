package opsw.uci.prj.starter;

import opsw.uci.prj.arifacts.OpswComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Για την ρύθμιση των DataSources στον Tomcat πάμε στο conf/server.xml και
 * βάζουμε στο <GlobalNamingResources/> το εξής:
 *
 *
 * <!--https://examples.javacodegeeks.com/enterprise-java/tomcat/tomcat-connection-pool-configuration-example/-->
 * <Resource auth="Container"
 * type="javax.sql.DataSource"
 * name="ORCLH_MINLO"
 * global="ORCLH_MINLO"
 * factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
 * driverClassName="com.mysql.jdbc.Driver"
 * description="ORCLH MINLO OSS database."
 * url="jdbc:mysql://192.168.1.17:3306/OPSWDB?useSSL=false&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"
 * username="root1"
 * password="rootP"
 * maxTotal="10"
 * maxIdle="10"
 * maxWaitMillis="10000"
 * removeAbandonedTimeout="300"
 * defaultAutoCommit="true"
 * />
 *
 * έπειτα πάμε στο config/context.xml και βάζουμε το εξής:
 *
 *
 * <ResourceLink name="ORCLH_MINLO"
 * global="ORCLH_MINLO"
 * auth="Container"
 * type="javax.sql.DataSource"
 * />
 *
 * .
 *
 * @author oulis
 */
/**
 * Εαν θέλουμε να φτιάξουμε μία transactional διαδικασία πρέπει να φτιάξουμε ένα
 * Service και να το δηλώσουμε στο @OpswComponentScanConfig. Πάνω από τη
 * διαδικασία γράφουμε @OpswTransactional.
 *
 * @author oulis
 */
@SpringBootApplication(
        exclude =
        {
          DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class
        }
)
@OpswComponentScan
//@EnableJpaRepositories(
//        basePackages =
//        {
//          "opsw.uci.prj.repositories"
//        }
//)
//@EntityScan(
//        basePackages =
//        {
//          "opsw.uci.prj.entity"
//        }
//)
public class OpswgolumwebservApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(OpswgolumwebservApplication.class, args);
  }

}
