package com.learn.demo;

import com.learn.demo.schedule.ScheduleJob;
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
 * @date 2019/11/28 16:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleTest {
  @Resource
  ScheduleJob scheduleJob;

  @Test
  public void testScheduleJob() throws  Exception{
    scheduleJob.cronJob();
    scheduleJob.fixedDelayJob();
    scheduleJob.fixedRateJob();
  }
}
