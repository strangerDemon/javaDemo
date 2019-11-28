package com.learn.demo;

import com.learn.demo.task.AsyncCallBackTask;
import com.learn.demo.task.AsyncExecutorTask;
import com.learn.demo.task.AsyncTask;
import com.learn.demo.task.SyncTask;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/28 15:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

  @Resource
  SyncTask syncTask;

  /**
   * 同步测试task.
   *
   * @throws Exception 异常
   */
  @Test
  public void testTaskSync() throws Exception {
    System.out.println("testTaskSync");
    syncTask.doTaskOne();
    syncTask.doTaskTwo();
    syncTask.doTaskThree();
  }

  @Resource
  AsyncTask asyncTask;

  /**
   * 异步测试task. 异步需要@EnableAsync
   *
   * @throws Exception 异常
   */
  @Test
  public void testTaskAsync() throws Exception {
    System.out.println("testTaskAsync");
    asyncTask.doTaskOne();
    asyncTask.doTaskTwo();
    asyncTask.doTaskThree();
  }

  @Resource
  AsyncCallBackTask asyncCallBackTask;

  /**
   * 测试task回调.
   *
   * @throws Exception 异常
   */
  @Test
  public void testAsyncCallBackTask() throws Exception {
    System.out.println("testAsyncCallBackTask");
    Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
    Future<String> task2 = asyncCallBackTask.doTaskTwoCallBack();
    Future<String> task3 = asyncCallBackTask.doTaskThreeCallBack();
    while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
      Thread.sleep(1000);
    }
    System.out.println("all task done.");
  }

  @Resource
  AsyncExecutorTask asyncExecutorTask;

  /**
   * 指定线程池.
   *
   * @throws Exception 异常
   */
  @Test
  public void testAsyncExecutorTask() throws Exception {
    System.out.println("testAsyncExecutorTask");
    Future<String> task1 = asyncExecutorTask.doTaskOneCallback();
    Future<String> task2 = asyncExecutorTask.doTaskTwoCallBack();
    Future<String> task3 = asyncExecutorTask.doTaskThreeCallBack();
    while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
      Thread.sleep(1000);
    }
    System.out.println("all task done.");
  }
}
