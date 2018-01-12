package org.bicyclesharing.service;

import org.bicyclesharing.entities.Bicycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class BicycleServiceTest {
    @Autowired
    private BicycleService bicycleService;
    @Test
    public void getBicycleById() throws Exception {
        System.out.println(bicycleService.getBicycleById(1));
    }

    @Test
    public void addBicycle() throws Exception {
        bicycleService.addBicycle(118.642471, 32.036097,new Date(),1);
    }

    @Test
    public void addBicycle1() throws Exception {
        bicycleService.addBicycle1(118.643371,32.037997,new Date(),1,1);
    }

    @Test
    public void getAllBicycle() throws Exception {
        List<Bicycle> bicyclelist = bicycleService.getAllBicycle();
        for (Bicycle bicycle : bicyclelist) {
            System.out.println(bicycle);
        }
    }

    @Test
    public void removeBicycle() throws Exception {
        bicycleService.removeBicycle(1);
    }

    @Test
    public void getBicycleByStatement() throws Exception {
        List<Bicycle> bicyclelist = bicycleService.getBicycleByStatement(1);
        for (Bicycle bicycle : bicyclelist) {
            System.out.println(bicycle);
        }
    }

    @Test
    public void getBicycleByLocation() throws Exception {
        List<Bicycle> bicyclelist = bicycleService.getBicycleByLocation(34.2,32.2);
        for (Bicycle bicycle : bicyclelist) {
            System.out.println(bicycle);
        }
    }

    @Test
    public void editBicycyle() throws Exception {
        System.out.println(bicycleService.editBicycyle(15,23.2,43.2,new Date(),1));
    }

    @Test
    public void getBicycleCount() throws Exception {
        System.out.println(bicycleService.getBicycleCount());
    }

    @Test
    public void getBicycleCountByStatement() throws Exception {
        System.out.println(bicycleService.getBicycleCountByStatement(1));
    }

    @Test
    public void getBicycleCurrentXByStatement() throws Exception {
        Double[] x=bicycleService.getBicycleCurrentXByStatement(1);
        for (int i = 0; i <x.length ; i++) {
            System.out.println(x[i]);
        }
    }
    @Test
    public void getBicycleCurrentYByStatement() throws Exception {
        Double[] y=bicycleService.getBicycleCurrentYByStatement(1);
        for (double m:y) {
            System.out.println(m);
        }
    }
}