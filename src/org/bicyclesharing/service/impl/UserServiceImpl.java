package org.bicyclesharing.service.impl;

import org.bicyclesharing.dao.UserDao;
import org.bicyclesharing.entities.User;
import org.bicyclesharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户相关逻辑实现
 * Created by HuiJa on 2017/7/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String username) {
        if ("".equals(username)) {
            return false;
        }
        User user = userDao.selectUserByName(username);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User getUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    @Override
    public boolean register(String username) {
        if ("".equals(username)) {
            return false;
        }
        User user = userDao.selectUserByName(username);
        if (user == null) {
            user = new User(username);
            user.setUserCash(0);
            user.setUserCredit(80);
            user.setUserAccount(new BigDecimal(0.00));
            userDao.insertUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public boolean removeUser(Integer id) {
        if (id <= 0 || "".equals(id)) {
            return false;
        } else {
            userDao.deleteUser(id);
            return true;
        }
    }

    @Override
    public List<User> getUserByNameLike(String username) {
        return userDao.selectUserByUserNameLike(username);
    }

    @Override
    public boolean editUser(String userName, BigDecimal userAccount, Integer userCredit, Integer userCash) {
        if ("".equals(userName) || "".equals(userAccount) || "".equals(userCredit) || "".equals(userCash)) {
            return false;
        } else {
            User user = userDao.selectUserByName(userName);
            if (user == null) {
                return false;
            } else {
                int id = user.getUserId();
                user = new User(id, userName, userAccount, userCredit, userCash);
                userDao.updateUser(user);
                return true;
            }
        }
    }

    @Override
    public Integer getUserCount() {
        return userDao.selectUserCount();
    }

    @Override
    public void resetCredit(Integer userId) {
        User user=userDao.selectUserById(userId);
        user.setUserCredit(80);
        userDao.updateUser(user);
    }

    @Override
    public void changeCashOne(Integer userId) {
        User user=userDao.selectUserById(userId);
        user.setUserCash(199);
        userDao.updateUser(user);
    }

    @Override
    public void changeCashTwo(Integer userId) {
        User user=userDao.selectUserById(userId);
        user.setUserCash(0);
        userDao.updateUser(user);
    }

}
