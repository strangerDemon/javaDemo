package com.learn.demo.schedule;

import java.util.Date;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/28 16:48
 */
@Component
public class ScheduleJob {

  //表示方法执行完成后5秒再开始执行
  @Async("taskExecutor")
  @Scheduled(fixedDelay = 5000)
  public void fixedDelayJob() throws InterruptedException {
    System.out.println("=========== fixedDelay ===========");
  }

  //表示每隔3秒
  @Async("taskExecutor")
  @Scheduled(fixedRate = 10000)
  public void fixedRateJob() throws InterruptedException {
    System.out.println("=========== fixedRate ===========");
  }

  //表示每隔10秒执行一次
  @Async("taskExecutor")
  @Scheduled(cron = "0/10 * * * * ? ")
  public void cronJob() {
    System.out.println("=========== cron ===========");
  }
}
