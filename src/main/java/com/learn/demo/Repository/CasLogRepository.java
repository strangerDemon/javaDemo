package com.learn.demo.Repository;

import com.learn.demo.Entity.CasLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author demo
 * @date 2019/9/16 11:10
 * @description
 */
public interface CasLogRepository extends JpaRepository<CasLogEntity,String> {
}
