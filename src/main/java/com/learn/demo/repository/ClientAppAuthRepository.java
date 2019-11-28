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

  /**
   * 获取用户客户端权限.
   * @param userId 用户id
   * @return 权限列表
   */
  List<ClientAppAuthEntity> findByUserId(String userId);

  /**
   * 获取客户端用户列表.
   * @param clientId 客户端id
   * @return 权限列表
   */

  List<ClientAppAuthEntity> findByClientAppId(String clientId);
}
