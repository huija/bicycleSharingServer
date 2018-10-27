package org.bicyclesharing.service.impl;

import org.bicyclesharing.dao.BicycleDao;
import org.bicyclesharing.entities.Bicycle;
import org.bicyclesharing.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 单车逻辑实现类
 * Created by HuiJa on 2017/7/28.
 */
@Service
public class BicycleServiceImpl implements BicycleService {
    @Autowired
    private BicycleDao bicycleDao;

    @Override
    public Bicycle getBicycleById(Integer id) {
        return bicycleDao.selectBicycleById(id);
    }

    @Override
    public Boolean addBicycle(double bicycleCurrentX, double bicycleCurrentY, Date bicycleLastTime, Integer bicycleStatement) {
        if ("".equals(bicycleCurrentX) || "".equals(bicycleCurrentY) || "".equals(bicycleLastTime) || "".equals(bicycleStatement)) {
            return false;
        } else {
            Bicycle bicycle = new Bicycle(bicycleCurrentX, bicycleCurrentY, bicycleLastTime, bicycleStatement);
            bicycleDao.insertBicycle(bicycle);
            return true;
        }
    }

    @Override
    public Boolean addBicycle1(double bicycleCurrentX, double bicycleCurrentY, Date bicycleLastTime, Integer bicycleStatement, Integer n) {
        if ("".equals(bicycleCurrentX) || "".equals(bicycleCurrentY) || "".equals(bicycleLastTime) || "".equals(bicycleStatement) || "".equals(n)) {
            return false;
        } else {
            for (int i = 0; i < n; i++) {
                Bicycle bicycle = new Bicycle(bicycleCurrentX, bicycleCurrentY, bicycleLastTime, bicycleStatement);
                bicycleDao.insertBicycle(bicycle);
            }
            return true;
        }
    }

    @Override
    public List<Bicycle> getAllBicycle() {
        return bicycleDao.selectAllBicycle();
    }

    @Override
    public Boolean removeBicycle(Integer id) {
        if ("".equals(id)) {
            return false;
        } else {
            bicycleDao.deleteBicycle(id);
            return true;
        }
    }

    @Override
    public List<Bicycle> getBicycleByStatement(Integer bicycleStatement) {
        return bicycleDao.selectBicycleByStatement(bicycleStatement);
    }

    @Override
    public Integer getBicycleCountByStatement(Integer bicycleStatement) {
        return bicycleDao.selectBicycleCountByStatement(bicycleStatement);
    }

    @Override
    public List<Bicycle> getBicycleByLocation(double bicycleCurrentX, double bicycleCurrentY) {
        return bicycleDao.selectBicycleByLocation(bicycleCurrentX, bicycleCurrentY);
    }

    @Override
    public Boolean editBicycyle(Integer id, double bicycleCurrentX, double bicycleCurrentY,Date bicycleLastTime, Integer bicycleStatement) {
        if (id == null || "".equals(bicycleCurrentX) || "".equals(bicycleCurrentY) ||bicycleLastTime==null|| "".equals(bicycleStatement)) {
            return false;
        } else {
            Bicycle bicycle = bicycleDao.selectBicycleById(id);
            if (bicycle == null) {
                return false;
            } else {
                bicycle.setBicycleCurrentX(bicycleCurrentX);
                bicycle.setBicycleCurrentY(bicycleCurrentY);
                bicycle.setBicycleLastTime(bicycleLastTime);
                bicycle.setBicycleStatement(bicycleStatement);
                bicycleDao.updateBicycle(bicycle);
                return true;
            }
        }
    }

    @Override
    public Integer getBicycleCount() {
        return bicycleDao.selectBicycleCount();
    }

    @Override
    public Double[] getBicycleCurrentXByStatement(Integer bicycleStatement) {
        List<Bicycle> bicycleList= bicycleDao.selectBicycleByStatement(bicycleStatement);
        Double[] dx=new Double[bicycleList.size()];
        for (int i = 0; i < bicycleList.size(); i++) {
            dx[i]=bicycleList.get(i).getBicycleCurrentX();//逐个获取经度
        }
        return dx;
    }

    @Override
    public Double[] getBicycleCurrentYByStatement(Integer bicycleStatement) {
        List<Bicycle> bicycleList= bicycleDao.selectBicycleByStatement(bicycleStatement);
        Double[] dy=new Double[bicycleList.size()];
        for (int i = 0; i < bicycleList.size(); i++) {
            dy[i]=bicycleList.get(i).getBicycleCurrentY();//逐个获取纬度
        }
        return dy;
    }
}
