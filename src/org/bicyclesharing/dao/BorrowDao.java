package org.bicyclesharing.dao;

import org.bicyclesharing.entities.Borrow;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 租借记录Dao
 * Created by HuiJa on 2017/7/26.
 */
public interface BorrowDao {

    /**
     * 1.插入一条租借记录
     *
     * @param borrow
     */
    void insertBorrow(Borrow borrow);

    /**
     * 2.按id删除一条租借记录
     *
     * @param borrowId
     */
    void deleteBorrow(Integer borrowId);

/* void updateBorrow(Borrow borrow);*/

    /**
     * 4.查询所有租借记录
     *
     * @return
     */
    List<Borrow> selectAllBorrow();

    /**
     * 5.根据id查询一条租借记录
     *
     * @param borrowId
     * @return
     */
    Borrow selectBorrowByBorrowId(Integer borrowId);

    /**
     * 6.根据车id查询其租借记录(和最后一条)
     *
     * @param bicycleId
     * @return
     */
    List<Borrow> selectBorrowByBicycleId(Integer bicycleId);
    Borrow selectBorrowLastByBicycleId(Integer bicycleId);

    /**
     * 7.根据用户id查询其租借记录
     *
     * @param userId
     * @return
     */
    List<Borrow> selectBorrowByUserId(Integer userId);

    /**
     * 8.获取当天消费总额
     *
     * @return
     */
    BigDecimal selectBorrowCost();
    /**
     * 9.修改租借记录
     */
    void updateBorrow(Borrow borrow);
}
