package org.bicyclesharing.service;

import org.bicyclesharing.entities.Recharge;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 充值相关逻辑
 * Created by HuiJa on 2017/7/28.
 */
public interface RechargeService {
    /**
     * 1.添加一条充值记录
     * @param userId
     * @param rechargeAmount
     * @param remaining
     * @param rechargeTime
     * @return
     */
    boolean addRecharge(Integer userId, BigDecimal rechargeAmount, BigDecimal remaining, Date rechargeTime);

    /**
     * 2.删除一条充值记录
     * @param id
     */
    void removeRecharge(Integer id);

    /**
     * 3.查看所有充值记录
     * @return
     */
    List<Recharge> getAllRecharge();

    /**
     * 4.通过id查询充值记录
     * @param id
     * @return
     */
    Recharge getRechargeById(Integer id);

    /**
     * 5.通过用户id查询充值记录
     * @param userId
     * @return
     */
    List<Recharge> getRechargeByUserId(Integer userId);

    /**
     * 6.查询当天用户充值总额
     * @return
     */
    BigDecimal getRechargeCount();
}
