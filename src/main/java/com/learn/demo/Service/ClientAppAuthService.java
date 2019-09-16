package com.learn.demo.Service;

import com.learn.demo.Entity.ClientAppAuthEntity;
import com.learn.demo.Repository.ClientAppAuthRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
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
