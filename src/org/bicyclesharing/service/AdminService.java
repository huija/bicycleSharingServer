package org.bicyclesharing.service;

import org.bicyclesharing.entities.Admin;
import org.bicyclesharing.entities.AdminMessage;

import java.util.List;

/**
 * 业务接口:站在使用者角度设计接口
 * 注意三方面:方法定义粒度,参数,返回类型(..加个exception包就复杂了,懒得搞)
 * 管理员业务逻辑接口
 * Created by HuiJa on 2017/7/21.
 */
public interface AdminService {
    /**
     * 1.管理员登录
     *
     * @param adminName
     * @param adminPassword
     * @return 0失败, 1成功
     */
    int login(String adminName, String adminPassword);

    /**
     * 2.添加管理员(管理员注册)
     *
     * @param adminName
     * @param adminPassword1
     * @param adminPassword2
     * @param adminEmail
     * @return false失败, true成功
     */
    boolean addAdmin( String adminName, String adminPassword1, String adminPassword2, String adminEmail);

    /**
     * 3.删除管理员
     *
     * @param adminId
     * @return
     */
    boolean removeAdmin(Integer adminId);

    /**
     * 4.根据id查询管理员信息
     *
     * @param adminId
     * @return 具体管理员实例
     */
    Admin getAdminById(Integer adminId);

    /**
     * 5.通过管理员名称获得该管理员信息(查询)
     *
     * @param adminName
     * @return 管理员信息(实例)
     */
    Admin getAdminByName(String adminName);


    /**
     * 6.查询所有管理员信息
     *
     * @return 所有管理员实例集合(表格)
     */
    List<Admin> getAllAdmin();


    /**
     * 7.通过管理员名类似进行模糊查询其信息
     *
     * @param name
     * @return 管理员实例集合(n行, n>=0)
     */
    List<Admin> getAdminByNameLike(String name);


    /**
     * 8.修改管理员信息
     *
     * @param adminId
     * @param adminName
     * @param adminPassword
     * @param adminEmail
     * @return false失败, true成功
     */
    boolean editAdmin(Integer adminId, String adminName, String adminPassword, String adminEmail);

   /*---------------------------------------------------------------------------------*/

    /**
     * 1.添加管理员通知
     *
     * @param adminMessageTitle
     * @param adminMessageContent
     * @param adminId
     * @return false失败, true成功
     */
    boolean addAdminMessage( String adminMessageTitle, String adminMessageContent, Integer adminId);

    /**
     * 2.修改管理员通知
     *
     * @param adminMessageId
     * @param adminMessageTitle
     * @param adminMessageContent
     * @return false失败, true成功
     */
    boolean editAdminMessage(Integer adminMessageId, String adminMessageTitle, String adminMessageContent);

    /**
     * 3.通过id获取管理员通知
     *
     * @param adminMessageId
     * @return 通知实例
     */
    AdminMessage getAdminMessageById(Integer adminMessageId);

    /**
     * 4.获取全部的管理员通知
     *
     * @return
     */
    List<AdminMessage> getAllAdminMessage();


    /**
     * 5.通过id删除管理员通知
     *
     * @param adminMessageId
     * @return
     */
    boolean removeAdminMessage(Integer adminMessageId);


    /**
     * 6.通过管理员通知标题类似进行模糊查询其信息
     *
     * @param title
     * @return 通知实例集合(n行, n>=0)
     */
    List<AdminMessage> getAdminMessageByTitleLike(String title);
}
