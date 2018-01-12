package org.bicyclesharing.dao;

import org.bicyclesharing.entities.Bicycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class BicycleDaoTest {
    @Resource
    private BicycleDao bicycleDao;

    @Test
    public void insertBicycle() throws Exception {
        Bicycle bicycle = new Bicycle(1, 10.0, 10.0, new Date(), 1);
        bicycleDao.insertBicycle(bicycle);
    }

    @Test
    public void deleteBicycle() throws Exception {
        bicycleDao.deleteBicycle(1);
    }

    @Test
    public void updateBicycle() throws Exception {
        Bicycle bicycle = new Bicycle(1, 20.0, 20.0, 1);
        bicycleDao.updateBicycle(bicycle);
    }

    @Test
    public void selectAllBicycle() throws Exception {
        List<Bicycle> bicycleList = bicycleDao.selectAllBicycle();
        for (Bicycle bicycle : bicycleList) {
            System.out.println(bicycle);
        }
    }

    @Test
    public void selectBicycleById() throws Exception {
        System.out.println( bicycleDao.selectBicycleById(1).toString());
    }

    @Test
    public void selectBicycleCount() throws Exception {
        System.out.println(bicycleDao.selectBicycleCount());
    }

    @Test
    public void selectBicycleByLocation() throws Exception {
        System.out.println(bicycleDao.selectBicycleByLocation(10.0,10.0).toString());
    }

    @Test
    public void selectBicycleByStatement() throws Exception {
        System.out.println(bicycleDao.selectBicycleByStatement(1).toString());
    }

    @Test
    public void selectBicycleCountByStatement() throws Exception {
        System.out.println(bicycleDao.selectBicycleCountByStatement(1));
    }
}