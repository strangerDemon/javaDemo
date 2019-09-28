package com.learn.demo.service;

import com.learn.demo.entity.ClientAppAuthEntity;
import com.learn.demo.mapper.ClientAppAuthMapper;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.repository.ClientAppAuthRepository;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 客户端权限service.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:24
 */
@Service
public class ClientAppAuthService {

  @Resource
  private ClientAppAuthRepository clientAppAuthRepository;

  @Resource
  private ClientAppAuthMapper clientAppAuthMapper;

  //region
  public ClientAppAuthEntity getOne(String s) {
    return clientAppAuthRepository.getOne(s);
  }

  //todo：data mapper
  public Page<ClientAppAuthEntity> findAll(Map data, Pageable pageable) {
    return clientAppAuthRepository.findAll(pageable);
  }

  //endregion

  public void delete(ClientAppAuthEntity clientAppAuthEntity) {
    clientAppAuthRepository.delete(clientAppAuthEntity);
  }

  /**
   * 创建用户客户端权限.todo:check
   */
  public ClientAppAuthEntity addClientAppAuth(ClientAppAuthEntity entity) {
    ClientAppAuthEntity auth = clientAppAuthMapper.getClientAuth(entity);
    if (auth != null) {
      throw new MyExceptionModel("用户客户端权限已存在！");
    }
    entity.setAuthId(UUID.randomUUID().toString());
    return clientAppAuthRepository.save(entity);
  }
}
