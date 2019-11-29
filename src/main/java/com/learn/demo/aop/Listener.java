package com.learn.demo.aop;

import com.learn.demo.model.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 监听器.
 * 只监听MyEvent事件
 * @author demo
 * @version 1.0.0
 * @date 2019/11/29 16:56
 */
@Component
@Slf4j
public class Listener {

  @EventListener
  public void onListener(MyEvent event) {
    System.out.println(String.format("%s监听器监听到：%s", Listener.class.getName(), event.getSource()));
  }
}
