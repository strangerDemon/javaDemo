package com.learn.demo.model;

import org.springframework.context.ApplicationEvent;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/29 16:59
 */
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {

  public MyEvent(Object source) {
    super(source);
  }
}
