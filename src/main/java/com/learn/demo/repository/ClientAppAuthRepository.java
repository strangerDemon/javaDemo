package com.learn.demo.repository;

import com.learn.demo.entity.ClientAppAuthEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author demo
 * @date 2019/9/16 11:11
 * @description ClientAppAuth jpa
 */
@Repository
public interface ClientAppAuthRepository extends JpaRepository<ClientAppAuthEntity, String> {

  //
  List<ClientAppAuthEntity> findByUserId(String userId);

  //
  List<ClientAppAuthEntity> findByClientAppId(String clientId);
}
