package com.learn.demo.repository;

import com.learn.demo.entity.ClientAppEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * ClientApp jpa.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 11:10
 */
@Repository
public interface ClientAppRepository extends JpaRepository<ClientAppEntity, String> {

  ClientAppEntity getByAppLoginUrl(String loginUrl);

  //todo
  //List<ClientAppEntity> findAuthClients(String userId);
}
