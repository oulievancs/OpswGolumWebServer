/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.arifacts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

/**
 *
 * @author oulis
 */
@Target(
        {
          ElementType.TYPE
        })
@Retention(RetentionPolicy.RUNTIME)
@Import(OpswComponentScanConfig.class)
@Documented
public @interface OpswComponentScan
{

  @AliasFor(annotation = Import.class, attribute = "value")
  Class<?>[] value() default 
  {
    OpswComponentScanConfig.class
  };
}
