package com.learn.demo.Repository;

import com.learn.demo.Entity.ClientAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author demo
 * @date 2019/9/16 11:10
 * @description ClientApp jpa
 */
@Repository
public interface ClientAppRepository extends JpaRepository<ClientAppEntity,String> {
}
