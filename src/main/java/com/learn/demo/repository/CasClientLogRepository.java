package com.learn.demo.repository;

import com.learn.demo.entity.CasClientLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CasClientLog jpa.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 11:11
 */
@Repository
public interface CasClientLogRepository extends JpaRepository<CasClientLogEntity, String> {

}
