/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.starter;

import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 *
 * @author oulis
 */
@Configuration
@EnableAsync
public class OpswExecutorConfig implements AsyncConfigurer
{

  @Value("${config.threadpool.corepool.size}")
  private Integer corePoolSize;

  @Value("${config.threadpool.maxpool.size}")
  private Integer maxPoolSize;
  //name of below method should not be changed.

  @Bean
  public Executor taskExecutor()
  {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    //other proeprties to be set here
    executor.setThreadNamePrefix("ASYNC-");
    executor.initialize();
    return executor;
  }
}
