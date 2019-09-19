package com.learn.demo.Repository;

import com.learn.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author demo
 * @date 2019/9/12 17:14
 * @description BaseUser jpa
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity getByAccount(String account);
}
