package com.learn.demo.service;

import com.learn.demo.entity.CasClientLogEntity;
import com.learn.demo.mapper.CasClientLogMapper;
import com.learn.demo.model.RedisClientModel;
import com.learn.demo.model.SystemConfigModel;
import com.learn.demo.repository.CasClientLogRepository;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
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

  //region

  /**
   * 颁发ticket时创建的日志.
   */
  public void createOfTicket(RedisClientModel client) {
    CasClientLogEntity entity = new CasClientLogEntity();
    entity.setAppLogId(UUID.randomUUID().toString());

    entity.setAppUrl(client.getAppLoginUrl());
    entity.setAppName(client.getAppName());
    entity.setAppId(client.getAppId());

    entity.setTicket(client.getTicket());
    entity.setTicketEffectiveTime(client.getTicketEffectiveTime());
    entity.setTicketCreateTime(client.getTicketCreateTime());
    entity.setTicketValidated(-1);

    entity.setCasLogId(client.getClientLogId());

    casClientLogRepository.save(entity);
  }

  /**
   * 验证ticket时修改日志.
   */
  public CasClientLogEntity updateOfVerifyTicket(String sessionId,RedisClientModel client,
      String description) {
    CasClientLogEntity entity = casClientLogRepository.getByTicket(client.getTicket());

    entity.setDescription(description);
    entity.setTicketValidateTime(new Date());
    entity.setLogStatus(1);
    entity.setClientSessionId(sessionId);

    return casClientLogRepository.save(entity);
  }

  /**
   * 登出时修改日志.
   */
  public CasClientLogEntity updateOfLogout() {
    return new CasClientLogEntity();
  }
  //endregion
}
