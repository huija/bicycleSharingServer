package org.bicyclesharing.dao;

import org.bicyclesharing.entities.Recharge;

import java.math.BigDecimal;
import java.util.List;

/**
 * 充值记录表
 * Created by HuiJa on 2017/7/26.
 */
public interface RechargeDao {

    /**
     * 1.插入一条充值记录
     *
     * @param recharge
     */
    void insertRecharge(Recharge recharge);

    /**
     * 2.按id删除一条充值记录
     *
     * @param rechargeId
     */
    void deleteRecharge(Integer rechargeId);


    /**
     * 3.查询所有充值记录
     *
     * @return
     */
    List<Recharge> selectAllRecharge();

    /**
     * 4.根据id查询一条租借充值记录
     *
     * @param rechargeId
     * @return
     */
    Recharge selectRechargeById(Integer rechargeId);

    /**
     * 5.查询指定用户的充值记录
     * @param userId
     * @return
     */
    List<Recharge> selectRechargeByUserId(Integer userId);

    /**
     * 6.获取当天充值金总数
     * @return
     */
    BigDecimal selectRechargeCount();
}
