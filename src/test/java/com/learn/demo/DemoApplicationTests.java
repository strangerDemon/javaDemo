package com.learn.demo;

import com.learn.demo.model.MyEvent;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  @Test
  public void contextLoads() {
  }

  @Resource
  ApplicationContext applicationContext;


  @Test
  public void testListener() {
    applicationContext.publishEvent(new TEvent("t-event"));
    applicationContext.publishEvent(new MyEvent("my-event"));
  }
}

class TEvent extends ApplicationEvent {
  TEvent(Object source) {
    super(source);
  }
}