package com.learn.demo.task;

import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/28 15:59
 */
@Component
public class AsyncExecutorTask extends AbstractTask {

  @Async("taskExecutor")
  public Future<String> doTaskOneCallback() throws Exception {
    super.doTaskOne();
    System.out.println(Thread.currentThread().getName());
    return new AsyncResult<>("任务一完成");
  }

  @Async("taskExecutor")
  public Future<String> doTaskTwoCallBack() throws Exception {
    super.doTaskTwo();
    System.out.println(Thread.currentThread().getName());
    return new AsyncResult<>("任务二完成");
  }

  @Async("taskExecutor")
  public Future<String> doTaskThreeCallBack() throws Exception {
    super.doTaskThree();
    System.out.println(Thread.currentThread().getName());
    return new AsyncResult<>("任务三完成");
  }
}
