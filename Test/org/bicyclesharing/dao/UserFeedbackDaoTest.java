package org.bicyclesharing.dao;

import org.bicyclesharing.entities.UserFeedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class UserFeedbackDaoTest {
    @Resource
    UserFeedbackDao userFeedbackDao;

    @Test
    public void addUserFeedback() throws Exception {
        UserFeedback userFeedback=new UserFeedback(2,"开发者的伙伴太蠢","建议剥夺他的结婚权利",1,1,new Date(),0);
        System.out.println(userFeedbackDao.insertUserFeedback(userFeedback));
    }

    @Test
    public void deleteUserFeedbackById() throws Exception {
        System.out.println(userFeedbackDao.deleteUserFeedbackById(2));
    }

    @Test
    public void updateUserFeedback() throws Exception {
        UserFeedback userFeedback=userFeedbackDao.selectUserFeedbackById(1);
        userFeedback.setFeedbackStatement(1);
        System.out.println(userFeedbackDao.updateUserFeedback(userFeedback));
    }

    @Test
    public void selectUserFeedbackById() throws Exception {
        System.out.println(userFeedbackDao.selectUserFeedbackById(1).toString());
    }

    @Test
    public void selectUserFeedbackByUserId() throws Exception {
        List<UserFeedback> userFeedbackList=userFeedbackDao.selectUserFeedbackByUserId(1);
        for (UserFeedback userFeedback:userFeedbackList) {
            System.out.println(userFeedback);
        }
    }
    @Test
    public void selectUserFeedbackByBicycleId() throws Exception {
        List<UserFeedback> userFeedbackList=userFeedbackDao.selectUserFeedbackByBicycleId(1);
        for (UserFeedback userFeedback:userFeedbackList) {
            System.out.println(userFeedback);
        }
    }@Test
    public void selectAllUserFeedback() throws Exception {
        List<UserFeedback> userFeedbackList=userFeedbackDao.selectAllUserFeedback();
        for (UserFeedback userFeedback:userFeedbackList) {
            System.out.println(userFeedback);
        }
    }
}