package org.bicyclesharing.dao;

import org.bicyclesharing.entities.Recharge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class RechargeDaoTest {
    //注入DAO实现类依赖(忘记注解是空指针异常,没有注入资源)
    @Resource
    private RechargeDao rechargeDao;

    @Test
    public void insertRecharge() throws Exception {
        Recharge recharge = new Recharge(3, 1, new BigDecimal(20), new BigDecimal(199), new Date());
        rechargeDao.insertRecharge(recharge);
    }

    @Test
    public void deleteRecharge() throws Exception {
        rechargeDao.deleteRecharge(2);
    }

    @Test
    public void selectAllRecharge() throws Exception {
        List<Recharge> rechargeList = rechargeDao.selectAllRecharge();
        for (Recharge recharge : rechargeList) {
            System.out.println(recharge);
        }
    }

    @Test
    public void selectRechargeById() throws Exception {
        System.out.println(rechargeDao.selectRechargeById(1));
    }

    @Test
    public void selectRechargeByUserId() throws Exception {
        List<Recharge> rechargeList=rechargeDao.selectRechargeByUserId(1);
        for (Recharge recharge : rechargeList) {
            System.out.println(recharge);
        }
    }
    @Test
    public void selectRechargeCount() throws Exception {
        System.out.println(rechargeDao.selectRechargeCount());
    }
}