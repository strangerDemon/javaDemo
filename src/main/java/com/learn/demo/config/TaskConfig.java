package com.learn.demo.config;

import com.learn.demo.model.ThreadConfigModel;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/28 14:45
 */
@Configuration
@EnableAsync
public class TaskConfig {

  @Resource
  ThreadConfigModel threadConfigModel;


  /**
   * 线程池.
   *
   * @return executor
   */
  @Bean("taskExecutor")
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(threadConfigModel.getCorePoolSize());
    executor.setMaxPoolSize(threadConfigModel.getQueueCapacity());
    executor.setQueueCapacity(threadConfigModel.getQueueCapacity());
    executor.setKeepAliveSeconds(threadConfigModel.getKeepAliveSeconds());
    executor.setThreadNamePrefix(threadConfigModel.getNamePrefix());
    executor.setRejectedExecutionHandler(new CallerRunsPolicy());
    executor.setWaitForTasksToCompleteOnShutdown(
        threadConfigModel.getWaitForTasksToCompleteOnShutdown());
    executor.setAwaitTerminationSeconds(threadConfigModel.getWaitTerminationSeconds());
    return executor;
  }
}
