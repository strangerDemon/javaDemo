package com.learn.demo.service;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.repository.ClientAppRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/*
 * @author demo
 * @date 2019/9/16 14:24
 * @description
 */
@Service
public class ClientAppService {

  @Resource
  private ClientAppRepository clientAppRepository;

  public ClientAppEntity getOne(String s) {
    return clientAppRepository.getOne(s);
  }

  public void delete(ClientAppEntity clientAppEntity) {
    clientAppRepository.delete(clientAppEntity);
  }

  public List<ClientAppEntity> findAll() {
    return clientAppRepository.findAll();
  }

  public <S extends ClientAppEntity> S saveAndFlush(S s) {
    return clientAppRepository.saveAndFlush(s);
  }
}
