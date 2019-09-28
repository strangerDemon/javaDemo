package com.learn.demo.service;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.mapper.UserMapper;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.repository.UserRepository;
import com.learn.demo.utils.EncryptUtils;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author demo
 * @version 1.0.0
 * @date
 */
@Service
public class UserService {

  @Resource
  private UserRepository userRepository;
  @Resource
  private UserMapper userMapper;

  public UserEntity getOne(String s) {
    return userRepository.getOne(s);
  }

  public UserEntity getByAccount(String account) {
    return userRepository.getByAccount(account);
  }

  public void delete(UserEntity userEntity) {
    userRepository.delete(userEntity);
  }

  /**
   * 分页查询. todo: requestParam,userMapper
   */
  public Page<UserEntity> findAll(Map data, Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  /**
   * 用户登录.
   */
  public UserEntity userLogin(UserEntity entity) {
    String encryptPS = EncryptUtils.encrypt(entity.getPassword());
    UserEntity user = userRepository.getByAccount(entity.getAccount());
    if (user == null) {
      throw new MyExceptionModel("账号不存在!");
    }
    if (!encryptPS.equals(user.getPassword())) {
      throw new MyExceptionModel("密码不正确!");
    }
    return user;
  }

  /**
   * 添加用户.
   */
  public UserEntity addUser(UserEntity entity) {
    UserEntity user = userRepository.getByAccount(entity.getAccount());
    if (user != null) {
      throw new MyExceptionModel("账号:" + entity.getAccount() + " 已存在！");
    }
    entity.setUserId(UUID.randomUUID().toString());
    entity.setPassword(EncryptUtils.encrypt(entity.getPassword()));
    return userRepository.save(entity);
  }
}
