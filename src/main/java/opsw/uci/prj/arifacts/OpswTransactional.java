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
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oulis
 */
@Target(
{
  ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(rollbackFor =
{
  CatExceptionUser.class,
  CatException.class,
  Exception.class
})
@Documented
public @interface OpswTransactional
{

}
