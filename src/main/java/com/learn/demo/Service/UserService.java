package com.learn.demo.Service;

import com.learn.demo.Repository.UserRepository;
import com.learn.demo.Entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public UserEntity getOne(String s) {
        return userRepository.getOne(s);
    }

    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public <S extends UserEntity> S saveAndFlush(S s) {
        return userRepository.saveAndFlush(s);
    }
}
