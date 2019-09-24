package com.learn.demo.repository;

import com.learn.demo.entity.CasLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CasLog jpa.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 11:10
 */
@Repository
public interface CasLogRepository extends JpaRepository<CasLogEntity, String> {

}
