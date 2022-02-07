/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.arifacts;

import opsw.uci.prj.cat.OpswEntityManagerJpa;
import opsw.uci.prj.gramexcel.logic.LcGramAssetsExcel01;
import opsw.uci.prj.interceptors.OpswWebMvcConfig;
import opsw.uci.prj.security.config.OpswKeycloakSecurityConfig;
import opsw.uci.prj.starter.OpswJpaStarter;
import opsw.uci.prj.starter.ServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author oulis
 */
@Configuration
@ComponentScan(
        basePackageClasses =
        {
          //Gram00Controller.class,
          OpswJpaStarter.class,
          OpswEntityManagerJpa.class,
          ServletInitializer.class,
          OpswKeycloakSecurityConfig.class,
          OpswEjbConnectionConfig.class,
          OpswDatasourceConnectionProvider.class,
          OpswWebMvcConfig.class,
          //---OWN SERVICES-----//
          LcGramAssetsExcel01.class
        },
        basePackages =
        {
          "opsw.uci.prj.services",
          "opsw.uci.prj.controllers",
          "opsw.uci.prj.exception.controllers"
        }
)
public class OpswComponentScanConfig
{

}
