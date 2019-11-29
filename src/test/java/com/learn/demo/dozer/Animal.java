package com.learn.demo.dozer;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/29 11:42
 */
@Data
@Component
public class Animal {

  private int age;

  private int sex;
}
