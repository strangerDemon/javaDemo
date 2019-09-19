package com.learn.demo.Repository;

import com.learn.demo.Entity.CasLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author demo
 * @date 2019/9/16 11:10
 * @description CasLog jpa
 */
@Repository
public interface CasLogRepository extends JpaRepository<CasLogEntity,String> {
}
