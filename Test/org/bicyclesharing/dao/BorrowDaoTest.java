package org.bicyclesharing.dao;

import org.bicyclesharing.entities.Borrow;
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
 * Created by Administrator on 2017/7/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class BorrowDaoTest {
    //注入DAO实现类依赖(忘记注解是空指针异常,没有注入资源)
    @Resource
    private BorrowDao borrowDao;
    @Test
    public void insertBorrow() throws Exception {
        Borrow borrow= new Borrow(2,1,1,new Date(),new Date(),1.00,1.00,2.00,2.00,new BigDecimal(0.1),new BigDecimal(0.2));
        borrowDao.insertBorrow(borrow);

    }

    @Test
    public void deleteBorrow() throws Exception {
        borrowDao.deleteBorrow(2);
    }

    @Test
    public void selectAllBorrow() throws Exception {
        List<Borrow> borrowList=borrowDao.selectAllBorrow();
        for (Borrow borrow:borrowList) {
            System.out.println(borrow);
        }
    }

    @Test
    public void selectBorrowByBorrowId() throws Exception {
        System.out.println(borrowDao.selectBorrowByBorrowId(1));
    }

    @Test
    public void selectBorrowByBicycleId() throws Exception {
        List<Borrow> borrowList=borrowDao.selectBorrowByBicycleId(1);
        for (Borrow borrow:borrowList) {
            System.out.println(borrow);
        }
    }

    @Test
    public void selectBorrowLastByBicycleId() throws Exception {
        System.out.println(borrowDao.selectBorrowLastByBicycleId(1));
    }

    @Test
    public void selectBorrowByUserId() throws Exception {
        List<Borrow> borrowList=borrowDao.selectBorrowByUserId(1);
        for (Borrow borrow:borrowList) {
            System.out.println(borrow);
        }
    }
    @Test
    public void selectBorrowCost()throws Exception{
        System.out.println(borrowDao.selectBorrowCost());
    }

    @Test
    public void updateBorrow() throws Exception {
        //这样修改是有问题的,starttime写null也会改,最好用set的方法,来修改,保留不需要修改的数据,当然其实也无所谓,到后面也可以做
        Borrow borrow=new Borrow(12,1,1,null,new Date(),null,null,118.642371, 32.036997,new BigDecimal(1.00),new BigDecimal(10.00));
        borrowDao.updateBorrow(borrow);
    }
}