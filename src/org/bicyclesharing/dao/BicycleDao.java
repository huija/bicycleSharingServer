package org.bicyclesharing.dao;

import org.apache.ibatis.annotations.Param;
import org.bicyclesharing.entities.Bicycle;

import java.util.List;

/**
 * 单车Dao接口
 * Created by HuiJa on 2017/7/26.
 */
public interface BicycleDao {
    /**
     * 1.插入一辆单车
     *
     * @param bicycle
     */
    void insertBicycle(Bicycle bicycle);

    /**
     * 2.按id删除一辆单车
     *
     * @param bicycleId
     */
    void deleteBicycle(Integer bicycleId);

    /**
     * 3.修改单车实例
     *
     * @param bicycle
     */
    void updateBicycle(Bicycle bicycle);

    /**
     * 4.查询所有单车
     *
     * @return
     */
    List<Bicycle> selectAllBicycle();

    /**
     * 5.根据id查询单车
     *
     * @param bicycleId
     * @return
     */
    Bicycle selectBicycleById(Integer bicycleId);

    /**
     * 6.计算单车数量
     *
     * @return
     */
    Integer selectBicycleCount();

    /**
     * 7.根据车辆位置信息查询单车
     *
     * @param bicycleCurrentX
     * @param bicycleCurrentY
     * @return
     */
    List<Bicycle> selectBicycleByLocation(@Param("bicycleCurrentX") double bicycleCurrentX, @Param("bicycleCurrentY") double bicycleCurrentY);

    /**
     * 8.根据车辆状况查询单车
     *
     * @param bicycleStatement
     * @return
     */
    List<Bicycle> selectBicycleByStatement(Integer bicycleStatement);
    /**
     * 9.根据车辆状况查询单车数量
     *
     * @param bicycleStatement
     * @return
     */
    Integer selectBicycleCountByStatement(Integer bicycleStatement);
}
