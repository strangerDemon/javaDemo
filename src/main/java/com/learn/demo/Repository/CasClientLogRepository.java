package com.learn.demo.Repository;

import com.learn.demo.Entity.CasClientLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author demo
 * @date 2019/9/16 11:11
 * @description
 */
public interface CasClientLogRepository extends JpaRepository<CasClientLogEntity,String> {
}
