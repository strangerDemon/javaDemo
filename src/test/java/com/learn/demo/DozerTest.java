package com.learn.demo;

import com.learn.demo.dozer.Animal;
import com.learn.demo.dozer.Dog;
import com.learn.demo.dozer.Person;
import com.learn.demo.dozer.Student;
import javax.annotation.Resource;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/29 11:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DozerTest {

  @Resource
  DozerBeanMapper dozerBeanMapper;

  @Test
  public void dozerTest() {
    Person p = new Person();
    p.setAge(5);
    p.setSex(1);
    p.setHeight(177);
    p.setName("person");

    System.out.println(p.toString());

    Student s = dozerBeanMapper.map(p, Student.class);
    System.out.println(s.toString());

    Animal a = dozerBeanMapper.map(p, Animal.class);
    System.out.println(a.toString());

    Dog d = dozerBeanMapper.map(p, Dog.class);
    System.out.println(d.toString());
  }
}
