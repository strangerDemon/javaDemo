package com.learn.demo.Service;

import com.learn.demo.Entity.UserEntity;
import com.learn.demo.Model.MyExceptionModel;
import com.learn.demo.Repository.UserRepository;
import com.learn.demo.Utils.EncryptUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public UserEntity getOne(String s) {
        return userRepository.getOne(s);
    }

    public UserEntity getByAccount(String account) {
        return userRepository.getByAccount(account);
    }

    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity CheckLogin(UserEntity entity) {
        String encryptPS = EncryptUtils.encrypt(entity.getPassword());
        UserEntity user = userRepository.getByAccount(entity.getAccount());
        if (user == null) {
            throw new MyExceptionModel("账号不存在!");
        }
        if (encryptPS.equals(entity.getPassword())) {
            throw new MyExceptionModel("密码不正确!");
        }
        return user;
    }

    public UserEntity AddUser(UserEntity entity) {
        UserEntity user = userRepository.getByAccount(entity.getAccount());
        if (user != null) {
            throw new MyExceptionModel("账号:" + entity.getAccount() + " 已存在！");
        }
        entity.setUserId(UUID.randomUUID().toString());
        entity.setPassword(EncryptUtils.encrypt(entity.getPassword()));
        return userRepository.save(entity);
    }
}
