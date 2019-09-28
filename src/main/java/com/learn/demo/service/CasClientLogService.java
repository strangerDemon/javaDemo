package com.learn.demo.service;

import com.learn.demo.entity.CasClientLogEntity;
import com.learn.demo.mapper.CasClientLogMapper;
import com.learn.demo.repository.CasClientLogRepository;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:24
 */
@Service
public class CasClientLogService {

  @Resource
  private CasClientLogRepository casClientLogRepository;

  @Resource
  private CasClientLogMapper casClientLogMapper;

  public CasClientLogEntity getOne(String s) {
    return casClientLogRepository.getOne(s);
  }

  public void delete(CasClientLogEntity casClientLogEntity) {
    casClientLogRepository.delete(casClientLogEntity);
  }

  /**
   * 分页查询. todo：casClientLogMapper
   */
  public Page<CasClientLogEntity> findAll(Map data, Pageable pageable) {
    return casClientLogRepository.findAll(pageable);
  }

  public <S extends CasClientLogEntity> S saveAndFlush(S s) {
    return casClientLogRepository.saveAndFlush(s);
  }
}
