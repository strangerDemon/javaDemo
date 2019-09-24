package com.learn.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * cas 客户端日志.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 10:29
 */
@Data
@Entity
@Table(name = "CasClientLog")
@JsonInclude(JsonInclude.Include.NON_NULL) //null不返回
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CasClientLogEntity {

  @Id
  private String appLogId;

  private String casLogId;

  private String appId;

  private String appName;

  private String appUrl;

  private String ticket;

  private Date ticketCreateTime;

  private Date ticketValidateTime;

  private Integer ticketEffectiveTime;

  private Integer ticketValidated;

  private Date loginTime;

  private Date logoutTime;

  private Integer logStatus;

  private String clientSessionId;

  private String description;
}
