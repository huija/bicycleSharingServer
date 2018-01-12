package org.bicyclesharing.service;

import org.bicyclesharing.entities.Borrow;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 租借单车相关逻辑
 * Created by HuiJa on 2017/7/28.
 */
public interface BorrowService {
    /**
     * 1.添加租借记录
     * @return
     */
    boolean addBorrow(Integer bicycleId, Integer userId, Date borrowStartTime, Date borrowEndTime, Double borrowStartX, Double borrowStartY, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining);

    /**
     * 2.按照id删除租借记录
     * @param id
     * @return
     */
    void removeBorrow(Integer id);

    /**
     * 3.获取所有租借记录
     * @return
     */
    List<Borrow> getAllBorrow();

    /**
     * 4.根据id查询租借记录
     * @return
     */
    Borrow getBorrowById(Integer id);

    /**
     * 5.根据车id查询租借记录(和最后一条)
     * @return
     */
    List<Borrow> getBorrowByBicycleId(Integer bicycleId);
    Borrow getBorrowLastByBicycleId(Integer bicycleId);

    /**
     * 6.根据用户id查询租借记录
     * @return
     */
    List<Borrow> getBorrowByUserId(Integer userId);

    BigDecimal getBorrowCost();

    /**
     * 7.修改租借记录
     */
    boolean editBorrow(Integer bicycleId,Date borrowEndTime,Double borrowEndX,Double borrowEndY,BigDecimal cost,BigDecimal remaining);

}
