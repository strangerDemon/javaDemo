package com.learn.demo.Repository;

import com.learn.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author demo
 * @date 2019/9/12 17:14
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity getByAccount(String account);
}
