package org.bicyclesharing.dao;

import org.bicyclesharing.entities.User;

import java.util.List;

/**
 * 用户接口访问层
 * Created by HuiJa on 2017/7/26.
 */
public interface UserDao {
    /**
     * 1.插入一个用户
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 2.按id删除一个用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 3.修改一个用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 4.查询名字含有某个字段的用户
     *
     * @param nameLike
     * @return
     */
    List<User> selectUserByUserNameLike(String nameLike);

    /**
     * 5.根据名字查询用户
     *
     * @param userName
     * @return
     */
    User selectUserByName(String userName);

    /**
     * 6.查询所有用户
     *
     * @return
     */
    List<User> selectAllUser();

    /**
     * 7.根据id查询用户
     *
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

    /**
     * 8.计算用户数量
     *
     * @return
     */
    Integer selectUserCount();

    /**
     * 9.根据信用度(低于userCredit)查询用户
     *
     * @param userCredit
     * @return
     */
    List<User> selectUserByCredit(Integer userCredit);

    /**
     * 10.根据押金查询用户(限定为0/199)
     * @param userCash
     * @return
     */
    List<User> selectUserByCash(Integer userCash);
}
