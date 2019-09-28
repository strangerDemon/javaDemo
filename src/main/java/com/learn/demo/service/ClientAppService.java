package com.learn.demo.service;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.mapper.ClientAppMapper;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.repository.ClientAppRepository;
import java.util.List;
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
public class ClientAppService {

  @Resource
  private ClientAppRepository clientAppRepository;

  @Resource
  private ClientAppMapper clientAppMapper;

  //region 查询

  /**
   * 根据服务地址获取客户端.
   */
  public ClientAppEntity getByAppLoginUrl(String service) {
    return clientAppRepository.getByAppLoginUrl(service);
  }

  /**
   * 获取权限内的客户端.
   */
  public List<ClientAppEntity> findAuthClients(String userId) {
    return clientAppMapper.findAuthClients(userId);
  }

  /**
   * 获取分页列表.
   */
  public Page<ClientAppEntity> findAll(Map data, Pageable pageable) {
    return clientAppRepository.findAll(pageable);
  }

  //endregion

  public void delete(ClientAppEntity clientAppEntity) {
    clientAppRepository.delete(clientAppEntity);
  }

  /**
   * 增加客户端.
   */
  public ClientAppEntity addClientApp(ClientAppEntity entity) {
    ClientAppEntity client = clientAppRepository.getByAppLoginUrl(entity.getAppLoginUrl());
    if (client != null) {
      throw new MyExceptionModel("账号:" + entity.getAppLoginUrl() + " 已存在！");
    }
    entity.setAppId(UUID.randomUUID().toString());
    return clientAppRepository.save(entity);
  }

}
