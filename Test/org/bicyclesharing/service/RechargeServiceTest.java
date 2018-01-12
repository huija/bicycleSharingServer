package org.bicyclesharing.service;

import org.bicyclesharing.entities.Recharge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class RechargeServiceTest {
    @Autowired
    private RechargeService rechargeService;

    @Test
    public void addRecharge() throws Exception {
        System.out.println(rechargeService.addRecharge(1,new BigDecimal(32.2),new BigDecimal(88.8),new Date()));
    }

    @Test
    public void removeRecharge() throws Exception {
        rechargeService.removeRecharge(10);
    }

    @Test
    public void getAllRecharge() throws Exception {
        List<Recharge> rechargeList=rechargeService.getAllRecharge();
        for (Recharge recharge:rechargeList) {
            System.out.println(recharge);
        }
    }

    @Test
    public void getRechargeById() throws Exception {
        System.out.println(rechargeService.getRechargeById(11));
    }

    @Test
    public void getRechargeByUserId() throws Exception {
        List<Recharge> rechargeList=rechargeService.getRechargeByUserId(1);
        for (Recharge recharge:rechargeList) {
            System.out.println(recharge);
        }
    }

    @Test
    public void getRechargeCount() throws Exception {
        System.out.println(rechargeService.getRechargeCount());
    }
}