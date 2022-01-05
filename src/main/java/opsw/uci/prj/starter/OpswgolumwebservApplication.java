package opsw.uci.prj.starter;

import opsw.uci.prj.controllers.Gram00Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan(
        basePackageClasses =
        {
          Gram00Controller.class
        },
        basePackages =
        {
          "opsw.uci.prj.services"
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
