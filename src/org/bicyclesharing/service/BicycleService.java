package org.bicyclesharing.service;

import org.bicyclesharing.entities.Bicycle;

import java.util.Date;
import java.util.List;

/**
 * 单车相关用户逻辑接口
 * Created by HuiJa on 2017/7/28.
 */
public interface BicycleService {
    /**
     * 1.根据id查询单车
     * @param id
     * @return
     */
    Bicycle getBicycleById(Integer id);

    /**
     * 2.增加一辆单车
     * @param bicycleCurrentX
     * @param bicycleCurrentY
     * @param bicycleLastTime
     * @param bicycleStatement
     * @return
     */
    Boolean addBicycle(double bicycleCurrentX, double bicycleCurrentY, Date bicycleLastTime,Integer bicycleStatement);

    /**
     * 3.增加n辆单车(某个地点)
     * @return
     */
    Boolean addBicycle1(double bicycleCurrentX, double bicycleCurrentY, Date bicycleLastTime,Integer bicycleStatement,Integer n);

    /**
     *  4.显示单车列表
     * @return
     */
    List<Bicycle> getAllBicycle();

    /**
     * 5.根据id删除单车
     * @param id
     * @return
     */
    Boolean removeBicycle(Integer id);

    /**
     * 6.通过状态查询单车(或者数量)
     * @param bicycleStatement
     * @return
     */
    List<Bicycle> getBicycleByStatement(Integer bicycleStatement);
    Integer getBicycleCountByStatement(Integer bicycleStatement);

    /**
     * 7.通过位置查询单车
     * @param bicycleCurrentX
     * @param bicycleCurrentY
     * @return
     */
    List<Bicycle> getBicycleByLocation(double bicycleCurrentX,double bicycleCurrentY);

    /**
     * 8.修改指定单车信息
     * @return
     */
    Boolean editBicycyle(Integer id,double bicycleCurrentX, double bicycleCurrentY,Date bicycleLastTime,Integer bicycleStatement);

    /**
     * 9.获取单车数量
     * @return
     */
    Integer getBicycleCount();

    /**
     * 11.根据车辆状况获取其经纬度
     * @param bicycleStatement
     * @return
     */
    Double[] getBicycleCurrentXByStatement(Integer bicycleStatement);
    Double[] getBicycleCurrentYByStatement(Integer bicycleStatement);
}
