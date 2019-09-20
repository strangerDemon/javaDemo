package com.learn.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @description cas 客户端对象
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

  private String manager;

  private String managerTel;

  private Integer isDefaultApp;

  private Integer singleLogout;

  private Integer forceLogout;

  private Integer sortCode;

  private String description;
  @JsonIgnore
  private Integer enabledMark;
  @JsonIgnore
  private Integer deleteMark;

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

  public String getAppLoginUrl() {
    return appLoginUrl;
  }

  public void setAppLoginUrl(String appLoginUrl) {
    this.appLoginUrl = appLoginUrl;
  }

  public String getAppLogoutUrl() {
    return appLogoutUrl;
  }

  public void setAppLogoutUrl(String appLogoutUrl) {
    this.appLogoutUrl = appLogoutUrl;
  }

  public String getAppServerIP() {
    return appServerIP;
  }

  public void setAppServerIP(String appServerIP) {
    this.appServerIP = appServerIP;
  }

  public String getAppIcon() {
    return appIcon;
  }

  public void setAppIcon(String appIcon) {
    this.appIcon = appIcon;
  }

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }

  public String getManagerTel() {
    return managerTel;
  }

  public void setManagerTel(String managerTel) {
    this.managerTel = managerTel;
  }

  public Integer getIsDefaultApp() {
    return isDefaultApp;
  }

  public void setIsDefaultApp(Integer isDefaultApp) {
    this.isDefaultApp = isDefaultApp;
  }

  public Integer getSingleLogout() {
    return singleLogout;
  }

  public void setSingleLogout(Integer singleLogout) {
    this.singleLogout = singleLogout;
  }

  public Integer getForceLogout() {
    return forceLogout;
  }

  public void setForceLogout(Integer forceLogout) {
    this.forceLogout = forceLogout;
  }

  public Integer getSortCode() {
    return sortCode;
  }

  public void setSortCode(Integer sortCode) {
    this.sortCode = sortCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getEnabledMark() {
    return enabledMark;
  }

  public void setEnabledMark(Integer enabledMark) {
    this.enabledMark = enabledMark;
  }

  public Integer getDeleteMark() {
    return deleteMark;
  }

  public void setDeleteMark(Integer deleteMark) {
    this.deleteMark = deleteMark;
  }

}
