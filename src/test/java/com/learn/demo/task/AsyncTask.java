package com.learn.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/28 15:28
 */
@Component
public class AsyncTask extends AbstractTask {

  @Async
  public void doTaskOne() throws Exception {
    super.doTaskOne();
  }

  @Async
  public void doTaskTwo() throws Exception {
    super.doTaskTwo();
  }

  @Async
  public void doTaskThree() throws Exception {
    super.doTaskThree();
  }
}
