package com.qul.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String name;
    private String gender;
    private String address;
    private String tel;
    private String email;
    private String username;
    private String password;
    private Date lastLoginTime;        //最后上线时间
    private Date errorPasswordTime;    //密码错误时间
    private int status;                //是否激活，0为未激活，1为激活
    private int errorCount;           //错误次数
    private int freeze;               //是否冻结，0为正常，1为冻结

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getErrorPasswordTime() {
        return errorPasswordTime;
    }

    public void setErrorPasswordTime(Date errorPasswordTime) {
        this.errorPasswordTime = errorPasswordTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", errorPasswordTime=" + errorPasswordTime +
                ", status=" + status +
                ", errorCount=" + errorCount +
                ", freeze=" + freeze +
                '}';
    }
}
