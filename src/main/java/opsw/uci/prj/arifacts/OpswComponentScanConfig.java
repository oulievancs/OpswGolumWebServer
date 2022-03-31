/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.arifacts;

import opsw.uci.prj.application.ApplicationProperties;
import opsw.uci.prj.assetsapi.logic.LcOpswAssetsApi;
import opsw.uci.prj.cat.OpswEntityManagerJpa;
import opsw.uci.prj.gramexcel.logic.OpswExcelUtilsAA;
import opsw.uci.prj.importExport.OpswImportExport;
import opsw.uci.prj.interceptors.OpswWebMvcConfig;
import opsw.uci.prj.security.config.OpswKeycloakSecurityConfig;
import opsw.uci.prj.starter.OpswUciApplicationRunner;
import opsw.uci.prj.starter.OpswExecutorConfig;
import opsw.uci.prj.starter.OpswJpaStarter;
import opsw.uci.prj.starter.OpswLocalResolver;
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
          OpswUciApplicationRunner.class,
          OpswJpaStarter.class,
          OpswEntityManagerJpa.class,
          ServletInitializer.class,
          OpswKeycloakSecurityConfig.class,
          OpswEjbConnectionConfig.class,
          OpswDatasourceConnectionProvider.class,
          OpswWebMvcConfig.class,
          OpswExecutorConfig.class,
          OpswLocalResolver.class,
          ApplicationProperties.class,
          //---OWN SERVICES-----//
          OpswExcelUtilsAA.class,
          LcOpswAssetsApi.class,
          OpswImportExport.class
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
