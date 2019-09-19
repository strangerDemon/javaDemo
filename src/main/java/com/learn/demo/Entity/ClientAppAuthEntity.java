package com.learn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author demo
 * @date 2019/9/16 10:28
 * @description 客户端权限
 */
@Entity
@Table(name = "ClientAppAuth")
@JsonInclude(JsonInclude.Include.NON_NULL) //null不返回
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ClientAppAuthEntity {
    @Id
    private String authId;

    private String userId;

    private String clientAppId;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientAppId() {
        return clientAppId;
    }

    public void setClientAppId(String clientAppId) {
        this.clientAppId = clientAppId;
    }

    @Override
    public String toString() {
        return "ClientAppAuthEntity{" +
                "authId='" + authId + '\'' +
                ", userId='" + userId + '\'' +
                ", clientAppId='" + clientAppId + '\'' +
                '}';
    }
}