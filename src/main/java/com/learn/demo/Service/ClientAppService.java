package com.learn.demo.Service;

import com.learn.demo.Entity.ClientAppEntity;
import com.learn.demo.Repository.ClientAppRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
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
