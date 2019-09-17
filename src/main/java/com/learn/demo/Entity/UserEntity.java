package com.learn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author demo
 * @date 2019/9/10 16:42
 */
@Entity
@Table(name = "BaseUser")
@JsonInclude(JsonInclude.Include.NON_NULL) //null不返回
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) //类注解，作用是json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
public class UserEntity {

    @Id
    private String userId;
    private String account;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String realName;
    private String headIcon;
    private int gender;
    private Date birthday;
    private String mobile;
    private String telephone;
    private String email;
    private String weChat;
    private String description;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", weChat='" + weChat + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
