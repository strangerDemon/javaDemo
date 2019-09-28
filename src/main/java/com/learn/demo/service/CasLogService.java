package com.learn.demo.service;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.mapper.CasLogMapper;
import com.learn.demo.repository.CasLogRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:23
 */
@Slf4j
@Service
public class CasLogService {

  @Resource
  private CasLogRepository casLogRepository;

  @Resource
  private CasLogMapper casLogMapper;
  //region 查询

  /**
   * 获取cas登录日志.
   */
  public CasLogEntity getOne(String casLogId) {
    return casLogRepository.getOne(casLogId);
  }

  /**
   * 查询所有. todo: casLogMapper
   */
  public Page<CasLogEntity> findAll(Map data, Pageable pageable) {
    return casLogRepository.findAll(pageable);
  }

  //endregion

  /**
   * 创建登录日志.
   */
  public CasLogEntity addCasLog(String sessionId, UserEntity user) {
    try {
      CasLogEntity casLogEntity = new CasLogEntity();
      casLogEntity.setCasLogId(UUID.randomUUID().toString());
      casLogEntity.setCasSessionId(sessionId);
      casLogEntity.setUserId(user.getUserId());
      casLogEntity.setAccount(user.getAccount());
      casLogEntity.setRealName(user.getRealName());
      casLogEntity.setLoginTime(new Date());
      casLogEntity.setLogStatus(0);
      //todo
      casLogEntity.setBrowserType("");
      casLogEntity.setIp("");
      casLogEntity.setDescription("");
      casLogRepository.save(casLogEntity);
      return casLogEntity;
    } catch (Exception ex) {
      log.error("createCasLog:{}", ex.getMessage());
      return null;
    }
  }
}
