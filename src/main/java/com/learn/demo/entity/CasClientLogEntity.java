package com.learn.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/*
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 10:29
 * @description cas 客户端日志
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

  public String getAppLogId() {
    return appLogId;
  }

  public void setAppLogId(String appLogId) {
    this.appLogId = appLogId;
  }

  public String getCasLogId() {
    return casLogId;
  }

  public void setCasLogId(String casLogId) {
    this.casLogId = casLogId;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public String getAppUrl() {
    return appUrl;
  }

  public void setAppUrl(String appUrl) {
    this.appUrl = appUrl;
  }

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public Date getTicketCreateTime() {
    return ticketCreateTime;
  }

  public void setTicketCreateTime(Date ticketCreateTime) {
    this.ticketCreateTime = ticketCreateTime;
  }

  public Date getTicketValidateTime() {
    return ticketValidateTime;
  }

  public void setTicketValidateTime(Date ticketValidateTime) {
    this.ticketValidateTime = ticketValidateTime;
  }

  public Integer getTicketEffectiveTime() {
    return ticketEffectiveTime;
  }

  public void setTicketEffectiveTime(Integer ticketEffectiveTime) {
    this.ticketEffectiveTime = ticketEffectiveTime;
  }

  public Integer getTicketValidated() {
    return ticketValidated;
  }

  public void setTicketValidated(Integer ticketValidated) {
    this.ticketValidated = ticketValidated;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public Date getLogoutTime() {
    return logoutTime;
  }

  public void setLogoutTime(Date logoutTime) {
    this.logoutTime = logoutTime;
  }

  public Integer getLogStatus() {
    return logStatus;
  }

  public void setLogStatus(Integer logStatus) {
    this.logStatus = logStatus;
  }

  public String getClientSessionId() {
    return clientSessionId;
  }

  public void setClientSessionId(String clientSessionId) {
    this.clientSessionId = clientSessionId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
