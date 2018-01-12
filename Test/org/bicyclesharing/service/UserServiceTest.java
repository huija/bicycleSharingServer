package org.bicyclesharing.service;

import org.bicyclesharing.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void login() throws Exception {
        System.out.println(userService.login("chai"));
    }

    @Test
    public void getUserByName() throws Exception {
        System.out.println(userService.getUserByName("钊儿").toString());
    }

    @Test
    public void register() throws Exception {
        System.out.println(userService.register("汇嘉"));
    }

    @Test
    public void getAllUser() throws Exception {
        List<User> userList = userService.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void removeUser() throws Exception {
        userService.removeUser(10);
    }

    @Test
    public void getUserByNameLike() throws Exception {
        System.out.println(userService.getUserByNameLike("ui").toString());
    }

    @Test
    public void editUser() throws Exception {
        boolean b = userService.editUser("chai",new BigDecimal(5.0),90,199);
        System.out.println(b);
    }

    @Test
    public void getUserCount() throws Exception {
        System.out.println(userService.getUserCount());
    }

    @Test
    public void resetCredit() throws Exception {
        userService.resetCredit(1);
    }

    @Test
    public void changeCashOne() throws Exception {
        userService.changeCashOne(1);
    }

    @Test
    public void changeCashTwo() throws Exception {
        userService.changeCashTwo(1);
    }

}