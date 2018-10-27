package org.bicyclesharing.entities;

import java.util.Date;

/**
 * 单车实体类
 * Created by HuiJa on 2017/7/26.
 */
public class Bicycle {
    private Integer bicycleId;
    //经纬度
    private double bicycleCurrentX;
    private double bicycleCurrentY;
    //最终归还时间
    private Date bicycleLastTime;
    //车辆状况
    private Integer bicycleStatement;

    public Bicycle() {
    }

    public Bicycle(double bicycleCurrentX, double bicycleCurrentY, Date bicycleLastTime, Integer bicycleStatement) {
        this.bicycleCurrentX = bicycleCurrentX;
        this.bicycleCurrentY = bicycleCurrentY;
        this.bicycleLastTime = bicycleLastTime;
        this.bicycleStatement = bicycleStatement;
    }

    public Bicycle(Integer bicycleId, double bicycleCurrentX, double bicycleCurrentY, Integer bicycleStatement) {
        this.bicycleId = bicycleId;
        this.bicycleCurrentX = bicycleCurrentX;
        this.bicycleCurrentY = bicycleCurrentY;
        this.bicycleStatement = bicycleStatement;
    }

    public Bicycle(Integer bicycleId, double bicycleCurrentX, double bicycleCurrentY, Date bicycleLastTime, Integer bicycleStatement) {
        this.bicycleId = bicycleId;
        this.bicycleCurrentX = bicycleCurrentX;
        this.bicycleCurrentY = bicycleCurrentY;
        this.bicycleLastTime = bicycleLastTime;
        this.bicycleStatement = bicycleStatement;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public double getBicycleCurrentX() {
        return bicycleCurrentX;
    }

    public void setBicycleCurrentX(double bicycleCurrentX) {
        this.bicycleCurrentX = bicycleCurrentX;
    }

    public double getBicycleCurrentY() {
        return bicycleCurrentY;
    }

    public void setBicycleCurrentY(double bicycleCurrentY) {
        this.bicycleCurrentY = bicycleCurrentY;
    }

    public Date getBicycleLastTime() {
        return bicycleLastTime;
    }

    public void setBicycleLastTime(Date bicycleLastTime) {
        this.bicycleLastTime = bicycleLastTime;
    }

    public Integer getBicycleStatement() {
        return bicycleStatement;
    }

    public void setBicycleStatement(Integer bicycleStatement) {
        this.bicycleStatement = bicycleStatement;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "bicycleId=" + bicycleId +
                ", bicycleCurrentX=" + bicycleCurrentX +
                ", bicycleCurrentY=" + bicycleCurrentY +
                ", bicycleLastTime=" + bicycleLastTime +
                ", bicycleStatement='" + bicycleStatement + '\'' +
                '}';
    }
}
