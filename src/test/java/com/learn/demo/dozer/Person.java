package com.learn.demo.dozer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/29 11:36
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Component
@Data
public class Person extends Animal {

  private String name;

  private int height;

  private int weight;
}
