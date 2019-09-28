package com.learn.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.demo.entity.ClientAppAuthEntity;

/**
 * clientAppAuth mapper.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/28 19:30
 */
public interface ClientAppAuthMapper extends BaseMapper<ClientAppAuthEntity> {

  ClientAppAuthEntity getClientAuth(ClientAppAuthEntity entity);
}
