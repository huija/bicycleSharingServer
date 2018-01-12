package org.bicyclesharing.service;

import org.bicyclesharing.entities.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户相关业务逻辑接口
 * Created by HuiJa on 2017/7/28.
 */
public interface UserService {
    /**
     * 1.用户登录(客户端验证码)
     * @param username
     * @return
     */
    boolean login(String username);

    /**
     * 2.根据用户名(手机号)获取信息
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 3.用户注册(手机号)
     * @param username
     * @return
     */
    boolean register(String username);

    /**
     * 4.获取所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 5.删除某个用户
     * @param id
     * @return
     */
    boolean removeUser(Integer id);

    /**
     * 6.通过用户名模糊查询用户(手机号码段)
     * @param username
     * @return
     */
    List<User> getUserByNameLike(String username);

    /**
     * 7.编辑用户信息
     * @param userName
     * @param userAccount
     * @param userCredit
     * @param userCash
     * @return
     */
    boolean editUser(String userName,BigDecimal userAccount, Integer userCredit, Integer userCash);

    /**
     * 8.获取用户数量
     * @return
     */
    Integer getUserCount();

    /**
     * 9.重置某个用户的信用
     * @param userId
     */
    void resetCredit(Integer userId);

    /**
     * 10.用户提交押金
     * @param userId
     */
    void changeCashOne(Integer userId);
    /**
     * 11.用户撤回押金
     * @param userId
     */
    void changeCashTwo(Integer userId);
}
