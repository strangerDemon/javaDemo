package com.learn.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * cas 客户端对象.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 10:28
 */
@Data
@Entity
@Table(name = "ClientApp")
@JsonInclude(JsonInclude.Include.NON_NULL) //null不返回
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//类注解，作用是json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
public class ClientAppEntity {

  @Id
  private String appId;

  private String appName;

  private String appLoginUrl;

  private String appLogoutUrl;

  private String appServerIP;

  private String appIcon;

  private String appPlatform;

  private String manager;

  private String managerTel;

  private Integer isDefaultApp = 0;

  private Integer singleLogout = 1;

  private Integer forceLogout = 0;

  private Integer sortCode = 0;

  private String description;

  @JsonIgnore
  private Integer enabledMark = 1;
  @JsonIgnore
  private Integer deleteMark = 0;
}
