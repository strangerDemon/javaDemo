package com.learn.demo.service;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.repository.CasLogRepository;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
 * @author demo
 * @date 2019/9/16 14:23
 * @description
 */
@Service
public class CasLogService {

  private static final Logger logger = LoggerFactory.getLogger(CasLogService.class);
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

  /**
   * 创建登录日志.
   * @param sessionId 回话id
   * @param user 用户信息
   * @return 日志对象
   */
  public CasLogEntity createCasLog(String sessionId, UserEntity user) {
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
      logger.error("createCasLog error={}", ex.getMessage());
      return null;
    }
  }
}
