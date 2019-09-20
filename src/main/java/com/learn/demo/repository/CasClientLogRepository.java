package com.learn.demo.repository;

import com.learn.demo.entity.CasClientLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author demo
 * @date 2019/9/16 11:11
 * @description CasClientLog jpa
 */
@Repository
public interface CasClientLogRepository extends JpaRepository<CasClientLogEntity, String> {

}
