package com.learn.demo.service;

import com.learn.demo.entity.ClientAppAuthEntity;
import com.learn.demo.repository.ClientAppAuthRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/*
 * @author demo
 * @date 2019/9/16 14:24
 * @description
 */
@Service
public class ClientAppAuthService {

  @Resource
  private ClientAppAuthRepository clientAppAuthRepository;

  public ClientAppAuthEntity getOne(String s) {
    return clientAppAuthRepository.getOne(s);
  }

  public void delete(ClientAppAuthEntity clientAppAuthEntity) {
    clientAppAuthRepository.delete(clientAppAuthEntity);
  }

  public List<ClientAppAuthEntity> findAll() {
    return clientAppAuthRepository.findAll();
  }

  public List<ClientAppAuthEntity> findByClientAppId(String clientId) {
    return clientAppAuthRepository.findByClientAppId(clientId);
  }

  public List<ClientAppAuthEntity> findByUserId(String userId) {
    return clientAppAuthRepository.findByUserId(userId);
  }

  public <S extends ClientAppAuthEntity> S saveAndFlush(S s) {
    return clientAppAuthRepository.saveAndFlush(s);
  }
}
