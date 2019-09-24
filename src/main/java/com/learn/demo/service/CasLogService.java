package com.learn.demo.service;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.repository.CasLogRepository;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 * @author demo
 * @date 2019/9/16 14:23
 * @description
 */
@Slf4j
@Service
public class CasLogService {

  @Resource
  private CasLogRepository casLogRepository;

  /**
   * 获取cas登录日志.
   *
   * @param casLogId 日志id
   * @return 日志对象
   */
  public CasLogEntity getOne(String casLogId) {
    return casLogRepository.getOne(casLogId);
  }

  /**
   * 查询所有.
   *
   * @return 所有cas登录日志
   */
  public List<CasLogEntity> findAll() {
    return casLogRepository.findAll();
  }

  /**
   * 创建登录日志.
   *
   * @param sessionId 回话id
   * @param user      用户信息
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
      log.error("createCasLog:{}", ex.getMessage());
      return null;
    }
  }
}
