package com.learn.demo.repository;

import com.learn.demo.entity.ClientAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author demo
 * @date 2019/9/16 11:10
 * @description ClientApp jpa
 */
@Repository
public interface ClientAppRepository extends JpaRepository<ClientAppEntity, String> {

}
