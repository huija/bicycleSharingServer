package org.bicyclesharing.service.impl;

import org.bicyclesharing.dao.BorrowDao;
import org.bicyclesharing.entities.Borrow;
import org.bicyclesharing.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 租借单车相关逻辑实现类
 * Created by HuiJa on 2017/7/28.
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowDao borrowDao;

    @Override
    public boolean addBorrow(Integer bicycleId, Integer userId, Date borrowStartTime, Date borrowEndTime, Double borrowStartX, Double borrowStartY, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        if ("".equals(bicycleId) || "".equals(userId) || "".equals(borrowStartTime) || "".equals(borrowEndTime) || "".equals(borrowStartX) || "".equals(borrowStartY) || "".equals(borrowEndX) || "".equals(borrowEndY) || "".equals(cost) || "".equals(remaining)) {
            return false;
        } else {
            Borrow borrow = new Borrow(bicycleId, userId, borrowStartTime, borrowEndTime, borrowStartX, borrowStartY, borrowEndX, borrowEndY, cost, remaining);
            borrowDao.insertBorrow(borrow);
            return true;
        }
    }

    @Override
    public void removeBorrow(Integer id) {
        borrowDao.deleteBorrow(id);
    }

    @Override
    public List<Borrow> getAllBorrow() {
        return borrowDao.selectAllBorrow();
    }

    @Override
    public Borrow getBorrowById(Integer id) {
        return borrowDao.selectBorrowByBorrowId(id);
    }

    @Override
    public List<Borrow> getBorrowByBicycleId(Integer bicycleId) {
        return borrowDao.selectBorrowByBicycleId(bicycleId);
    }

    @Override
    public Borrow getBorrowLastByBicycleId(Integer bicycleId) {
        return borrowDao.selectBorrowLastByBicycleId(bicycleId);
    }

    @Override
    public List<Borrow> getBorrowByUserId(Integer userId) {
        return borrowDao.selectBorrowByUserId(userId);
    }

    @Override
    public BigDecimal getBorrowCost() {
        return borrowDao.selectBorrowCost();
    }

    @Override
    public boolean editBorrow(Integer bicycleId, Date borrowEndTime, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        if (bicycleId == null || borrowEndTime == null || borrowEndX == null || borrowEndY == null || cost == null || remaining == null) {
            return false;
        } else {
            Borrow borrow = borrowDao.selectBorrowLastByBicycleId(bicycleId);
            if (borrow == null) {
                return false;
            } else {
                borrow.setBorrowEndTime(borrowEndTime);
                borrow.setBorrowEndX(borrowEndX);
                borrow.setBorrowEndY(borrowEndY);
                borrow.setCost(cost);
                borrow.setRemaining(remaining);
                borrowDao.updateBorrow(borrow);
                return true;
            }
        }
    }


}
