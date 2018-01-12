package org.bicyclesharing.service;

import org.bicyclesharing.entities.UserFeedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/8/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class UserFeedbackServiceTest {
    @Autowired
    UserFeedbackService userFeedbackService;
    @Test
    public void addFeedback() throws Exception {
        UserFeedback userFeedback=new UserFeedback("开发者的儿子也很蠢","建议剥夺其结婚权利",1,1,new Date(),0);
        System.out.println(userFeedbackService.addFeedback(userFeedback));
    }

    @Test
    public void getFeedback() throws Exception {
        System.out.println(userFeedbackService.getFeedback(3));
    }

    @Test
    public void getFeedbackByBicycleId() throws Exception {
        List<UserFeedback> userFeedbackList=userFeedbackService.getFeedbackByBicycleId(1);
        for (UserFeedback userFeedback:userFeedbackList) {
            System.out.println(userFeedback);
        }
    }

    @Test
    public void getFeedbackByUserId() throws Exception {
        List<UserFeedback> userFeedbackList=userFeedbackService.getFeedbackByUserId(1);
        for (UserFeedback userFeedback:userFeedbackList) {
            System.out.println(userFeedback);
        }
    }

    @Test
    public void getAllFeedback() throws Exception {
        List<UserFeedback> userFeedbackList=userFeedbackService.getAllFeedback();
        for (UserFeedback userFeedback:userFeedbackList) {
            System.out.println(userFeedback);
        }
    }

    @Test
    public void resolved() throws Exception {
        System.out.println(userFeedbackService.resolved(1));
    }

    @Test
    public void removeFeedback() throws Exception {
        System.out.println(userFeedbackService.removeFeedback(1));
    }
}