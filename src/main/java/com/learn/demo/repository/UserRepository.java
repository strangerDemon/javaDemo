package com.learn.demo.repository;

import com.learn.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * BaseUser jpa.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/12 17:14
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

  UserEntity getByAccount(String account);
}
