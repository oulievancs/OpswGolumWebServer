package opsw.uci.prj.starter;

import opsw.uci.prj.controllers.Gram00Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
    Gram00Controller.class
},
        basePackages = {
            "opsw.uci.prj.repositories",
            "opsw.uci.prj.services"
        })
@Component
public class OpswgolumwebservApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpswgolumwebservApplication.class, args);
    }

}
