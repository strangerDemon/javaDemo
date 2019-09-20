package com.learn.demo.service;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.repository.CasLogRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/*
 * @author demo
 * @date 2019/9/16 14:23
 * @description
 */
@Service
public class CasLogService {

  @Resource
  private CasLogRepository casLogRepository;

  public CasLogEntity getOne(String s) {
    return casLogRepository.getOne(s);
  }

  public void delete(CasLogEntity casLogEntity) {
    casLogRepository.delete(casLogEntity);
  }

  public List<CasLogEntity> findAll() {
    return casLogRepository.findAll();
  }

  public <S extends CasLogEntity> S saveAndFlush(S s) {
    return casLogRepository.saveAndFlush(s);
  }
}
