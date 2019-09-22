package com.learn.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/*
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 10:28
 * @description 客户端权限
 */
@Data
@Entity
@Table(name = "ClientAppAuth")
@JsonInclude(JsonInclude.Include.NON_NULL) //null不返回
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientAppAuthEntity {

  @Id
  private String authId;

  private String userId;

  private String clientAppId;
}
