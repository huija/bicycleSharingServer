package org.bicyclesharing.service;

import org.bicyclesharing.dao.BorrowDao;
import org.bicyclesharing.entities.Borrow;
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
public class BorrowServiceTest {
    @Autowired
    private BorrowService borrowService;

    @Test
    public void addBorrow() throws Exception {
        System.out.println(borrowService.addBorrow(1, 1, new Date(), new Date(), 34.2, 23.3, 65.4, 45.8, new BigDecimal(8.2), new BigDecimal(89.3)));
    }

    @Test
    public void removeBorrow() throws Exception {
        borrowService.removeBorrow(1);
    }

    @Test
    public void getAllBorrow() throws Exception {
        List<Borrow> borrowList = borrowService.getAllBorrow();
        for (Borrow borrow : borrowList) {
            System.out.println(borrow);
        }
    }

    @Test
    public void getBorrowById() throws Exception {
        System.out.println(borrowService.getBorrowById(10));
    }

    @Test
    public void getBorrowByBicycleId() throws Exception {
        List<Borrow> borrowList = borrowService.getBorrowByBicycleId(1);
        for (Borrow borrow : borrowList) {
            System.out.println(borrow);
        }
    }

    @Test
    public void getBorrowLastByBicycleId() throws Exception {
        System.out.println(borrowService.getBorrowLastByBicycleId(1));
    }

    @Test
    public void getBorrowByUserId() throws Exception {
        List<Borrow> borrowList = borrowService.getBorrowByUserId(1);
        for (Borrow borrow : borrowList) {
            System.out.println(borrow);
        }
    }

    @Test
    public void getBorrowCost() throws Exception {
        System.out.println(borrowService.getBorrowCost());
    }

    @Test
    public void editBorrow() throws Exception {
        System.out.println(borrowService.editBorrow(1,new Date(),118.642373, 32.036999,new BigDecimal(2.00),new BigDecimal(11.00)));
    }
}