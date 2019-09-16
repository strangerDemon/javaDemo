package com.learn.demo.Repository;

import com.learn.demo.Entity.ClientAppAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author demo
 * @date 2019/9/16 11:11
 * @description
 */
public interface ClientAppAuthRepository extends JpaRepository<ClientAppAuthEntity,String> {
    //
    List<ClientAppAuthEntity> findByUserId(String userId);
    //
    List<ClientAppAuthEntity> findByClientAppId(String clientId);
}
