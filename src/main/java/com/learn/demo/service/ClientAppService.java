package com.learn.demo.service;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.mapper.ClientAppMapper;
import com.learn.demo.repository.ClientAppRepository;
import java.util.List;
import javax.annotation.Resource;
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

  /**
   * 根据服务地址获取客户端.
   *
   * @param service 登录地址
   * @return 客户端
   */
  public ClientAppEntity getByAppLoginUrl(String service) {
    return clientAppRepository.getByAppLoginUrl(service);
  }

  /**
   * 获取权限内的客户端.
   *
   * @param userId 用户id
   * @return 客户端列表
   */
  public List<ClientAppEntity> findAuthClients(String userId) {
    return clientAppMapper.findAuthClients(userId);
  }

  public List<ClientAppEntity> findAll() {
    return clientAppRepository.findAll();
  }

  public void delete(ClientAppEntity clientAppEntity) {
    clientAppRepository.delete(clientAppEntity);
  }

  public ClientAppEntity addClientApp(ClientAppEntity client) {
    return clientAppRepository.save(client);
  }

}
