package org.bicyclesharing.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 租借记录实体类
 * Created by HuiJa on 2017/7/26.
 */
public class Borrow {
    private Integer borrowId;
    private Integer bicycleId;
    private Integer userId;
    //借车时间段
    private Date borrowStartTime;
    private Date borrowEndTime;
    //借车位置
    private Double borrowStartX;
    private Double borrowStartY;
    //还车位置
    private Double borrowEndX;
    private Double borrowEndY;
    //消费
    private BigDecimal cost;
    //余额
    private BigDecimal remaining;

    private Bicycle bicycle;
    private User user;

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Borrow() {
    }

    public Borrow(Integer bicycleId, Integer userId, Date borrowStartTime, Date borrowEndTime, Double borrowStartX, Double borrowStartY, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        this.bicycleId = bicycleId;
        this.userId = userId;
        this.borrowStartTime = borrowStartTime;
        this.borrowEndTime = borrowEndTime;
        this.borrowStartX = borrowStartX;
        this.borrowStartY = borrowStartY;
        this.borrowEndX = borrowEndX;
        this.borrowEndY = borrowEndY;
        this.cost = cost;
        this.remaining = remaining;
    }

    public Borrow(Integer borrowId, Integer bicycleId, Integer userId, Date borrowStartTime, Date borrowEndTime, Double borrowStartX, Double borrowStartY, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        this.borrowId = borrowId;
        this.bicycleId = bicycleId;
        this.userId = userId;
        this.borrowStartTime = borrowStartTime;
        this.borrowEndTime = borrowEndTime;
        this.borrowStartX = borrowStartX;
        this.borrowStartY = borrowStartY;
        this.borrowEndX = borrowEndX;
        this.borrowEndY = borrowEndY;
        this.cost = cost;
        this.remaining = remaining;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getBorrowStartTime() {
        return borrowStartTime;
    }

    public void setBorrowStartTime(Date borrowStartTime) {
        this.borrowStartTime = borrowStartTime;
    }

    public Date getBorrowEndTime() {
        return borrowEndTime;
    }

    public void setBorrowEndTime(Date borrowEndTime) {
        this.borrowEndTime = borrowEndTime;
    }

    public Double getBorrowStartX() {
        return borrowStartX;
    }

    public void setBorrowStartX(Double borrowStartX) {
        this.borrowStartX = borrowStartX;
    }

    public Double getBorrowStartY() {
        return borrowStartY;
    }

    public void setBorrowStartY(Double borrowStartY) {
        this.borrowStartY = borrowStartY;
    }

    public Double getBorrowEndX() {
        return borrowEndX;
    }

    public void setBorrowEndX(Double borrowEndX) {
        this.borrowEndX = borrowEndX;
    }

    public Double getBorrowEndY() {
        return borrowEndY;
    }

    public void setBorrowEndY(Double borrowEndY) {
        this.borrowEndY = borrowEndY;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", bicycleId=" + bicycleId +
                ", userId=" + userId +
                ", borrowStartTime=" + borrowStartTime +
                ", borrowEndTime=" + borrowEndTime +
                ", borrowStartX=" + borrowStartX +
                ", borrowStartY=" + borrowStartY +
                ", borrowEndX=" + borrowEndX +
                ", borrowEndY=" + borrowEndY +
                ", cost=" + cost +
                ", remaining=" + remaining +
                '}';
    }
}
