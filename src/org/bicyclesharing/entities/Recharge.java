package org.bicyclesharing.entities;

import org.bicyclesharing.service.UserService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 充值记录表
 * Created by HuiJa on 2017/7/26.
 */
public class Recharge {
    private Integer rechargeId;
    private Integer userId;
    private BigDecimal rechargeAmount;
    private BigDecimal remaining;
    private Date rechargeTime;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recharge() {
    }

    public Recharge(Integer userId, BigDecimal rechargeAmount, BigDecimal remaining, Date rechargeTime) {
        this.userId = userId;
        this.rechargeAmount = rechargeAmount;
        this.remaining = remaining;
        this.rechargeTime = rechargeTime;
    }

    public Recharge(Integer rechargeId, Integer userId, BigDecimal rechargeAmount, BigDecimal remaining, Date rechargeTime) {
        this.rechargeId = rechargeId;
        this.userId = userId;
        this.rechargeAmount = rechargeAmount;
        this.remaining = remaining;
        this.rechargeTime = rechargeTime;
    }

    public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "rechargeId=" + rechargeId +
                ", userId=" + userId +
                ", rechargeAmount=" + rechargeAmount +
                ", remaining=" + remaining +
                ", rechargeTime=" + rechargeTime +
                '}';
    }
}
