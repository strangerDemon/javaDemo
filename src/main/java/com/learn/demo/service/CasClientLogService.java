package com.learn.demo.service;

import com.learn.demo.entity.CasClientLogEntity;
import com.learn.demo.repository.CasClientLogRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/*
 * @author demo
 * @date 2019/9/16 14:24
 * @description
 */
@Service
public class CasClientLogService {

  @Resource
  private CasClientLogRepository casClientLogRepository;

  public CasClientLogEntity getOne(String s) {
    return casClientLogRepository.getOne(s);
  }

  public void delete(CasClientLogEntity casClientLogEntity) {
    casClientLogRepository.delete(casClientLogEntity);
  }

  public List<CasClientLogEntity> findAll() {
    return casClientLogRepository.findAll();
  }

  public <S extends CasClientLogEntity> S saveAndFlush(S s) {
    return casClientLogRepository.saveAndFlush(s);
  }
}
