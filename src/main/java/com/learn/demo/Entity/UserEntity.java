package com.learn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.ir.annotations.Ignore;

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
public class UserEntity {

    @Id
    private String UserId;
    private String Account;
    @JsonIgnore
    private String Password;
    private String RealName;
    private String HeadIcon;
    private int Gender;
    private Date Birthday;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String Mobile;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String Telephone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String Email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String WeChat;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String Description;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getHeadIcon() {
        return HeadIcon;
    }

    public void setHeadIcon(String headIcon) {
        HeadIcon = headIcon;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWeChat() {
        return WeChat;
    }

    public void setWeChat(String weChat) {
        WeChat = weChat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "UserId='" + UserId + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", RealName='" + RealName + '\'' +
                ", HeadIcon='" + HeadIcon + '\'' +
                ", Gender=" + Gender +
                ", Birthday=" + Birthday +
                ", Mobile='" + Mobile + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Email='" + Email + '\'' +
                ", WeChat='" + WeChat + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
