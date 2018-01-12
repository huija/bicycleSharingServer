package org.bicyclesharing.dao;

import org.bicyclesharing.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void insertUser() throws Exception {
        User user = new User(1, "123", new BigDecimal(200), 90, 0);
        userDao.insertUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        userDao.deleteUser(3);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User(2, "钊儿", new BigDecimal(0), 90, 199);
        userDao.updateUser(user);
    }

    @Test
    public void selectUserByUserNameLike() throws Exception {
        //这里namelike的参数一律使用'%${_parameter}%'这个形式,而不是name_like或者nameLike
        List<User> userList = userDao.selectUserByUserNameLike("儿");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserByName() throws Exception {
        System.out.println(userDao.selectUserByName("钊儿"));
    }

    @Test
    public void selectAllUser() throws Exception {
        List<User> userList=userDao.selectAllUser();
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserById() throws Exception {
        System.out.println(userDao.selectUserById(1));
    }

    @Test
    public void selectUserCount() throws Exception {
        System.out.println(userDao.selectUserCount());
    }

    @Test
    public void selectUserByCredit() throws Exception {
        List<User> userList=userDao.selectUserByCredit(199);
        for (User user:userList) {
            System.out.println(user);
        }
    }

}