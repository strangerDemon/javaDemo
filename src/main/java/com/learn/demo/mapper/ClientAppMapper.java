package com.learn.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.demo.entity.ClientAppEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * clientApp mapper.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/27 15:53
 */
public interface ClientAppMapper extends BaseMapper<ClientAppEntity> {

  /**
   * 获取脱衣服权限类的客户端.
   */
  List<ClientAppEntity> findAuthClients(@Param("userId") String userId);
}
