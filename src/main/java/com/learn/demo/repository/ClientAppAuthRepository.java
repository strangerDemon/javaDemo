package com.learn.demo.repository;

import com.learn.demo.entity.ClientAppAuthEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClientAppAuth jpa.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 11:11
 */
@Repository
public interface ClientAppAuthRepository extends JpaRepository<ClientAppAuthEntity, String> {

  //
  List<ClientAppAuthEntity> findByUserId(String userId);

  //
  List<ClientAppAuthEntity> findByClientAppId(String clientId);
}
