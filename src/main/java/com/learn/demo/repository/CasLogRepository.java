package com.learn.demo.repository;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.model.PageModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * @author demo
 * @date 2019/9/16 11:10
 * @description CasLog jpa
 */
@Repository
public interface CasLogRepository extends JpaRepository<CasLogEntity, String> {

  List<CasLogEntity> findPage(PageModel page);
}
