package com.learn.demo.Repository;

import com.learn.demo.Entity.ClientAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author demo
 * @date 2019/9/16 11:10
 * @description
 */
public interface ClientAppRepository extends JpaRepository<ClientAppEntity,String> {
}
