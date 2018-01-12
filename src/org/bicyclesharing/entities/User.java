package org.bicyclesharing.entities;

import java.math.BigDecimal;

/**
 * 用户实体类
 * Created by HuiJa on 2017/7/26.
 */
public class User {
    private Integer userId;
    //用户名,手机号
    private String userName;
    //余额
    private BigDecimal userAccount;
    //信用度
    private Integer userCredit;
    //押金
    private Integer userCash;

    public User() {
    }

    public User(Integer userId, String userName, BigDecimal userAccount, Integer userCredit, Integer userCash) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userCredit = userCredit;
        this.userCash = userCash;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public BigDecimal getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(BigDecimal userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Integer getUserCash() {
        return userCash;
    }

    public void setUserCash(Integer userCash) {
        this.userCash = userCash;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount=" + userAccount +
                ", userCredit=" + userCredit +
                ", userCash=" + userCash +
                '}';
    }
}
