package com.learn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author demo
 * @date 2019/9/16 10:28
 * @description cas日志
 */
@Entity
@Table(name = "CasLog")
@JsonInclude(JsonInclude.Include.NON_NULL) //null不返回
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CasLogEntity {
    @Id
    private String casLogId;

    private String userId;

    private String account;

    private String realName;

    private String ip;

    private Date loginTime;

    private Date logoutTime;

    private Integer logStatus;

    private String browserType;

    private String casSessionId;

    private String description;

    public String getCasLogId() {
        return casLogId;
    }

    public void setCasLogId(String casLogId) {
        this.casLogId = casLogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getCasSessionId() {
        return casSessionId;
    }

    public void setCasSessionId(String casSessionId) {
        this.casSessionId = casSessionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CasLog{" +
                "casLogId='" + casLogId + '\'' +
                ", userId='" + userId + '\'' +
                ", account='" + account + '\'' +
                ", realName='" + realName + '\'' +
                ", ip='" + ip + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", logStatus=" + logStatus +
                ", browserType='" + browserType + '\'' +
                ", casSessionId='" + casSessionId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
