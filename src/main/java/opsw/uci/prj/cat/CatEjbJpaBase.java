/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.cat;

import javax.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oulis
 */
@NoRepositoryBean
@Transactional(rollbackFor =
{
  CatExceptionUser.class,
  CatException.class,
  Exception.class
})
public interface CatEjbJpaBase<T extends Object, ID extends Object> extends JpaRepository<T, ID>
{

}
