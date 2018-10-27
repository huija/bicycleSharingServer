package org.bicyclesharing.dao;

import org.bicyclesharing.entities.AdminMessage;

import java.util.List;

/**
 * Created by HuiJa on 2017/7/21.
 */
public interface AdminMessageDao {
    /**
     * 1.通过通知id获取管理员通知
     *
     * @param adminMessageId
     * @return 返回一行通知实例
     */
    AdminMessage getAdminMessage(Integer adminMessageId);

    /**
     * 2.获取所有的管理员通知
     *
     * @return 返回管理员通知table
     */
    List<AdminMessage> selectAllAdminMessage();

    /**
     * 3.添加管理员通知
     *
     * @param adminMessage
     */
    void insertAdminMessage(AdminMessage adminMessage);

    /**
     * 4.通过通知id删除管理员通知
     *
     * @param adminMessageId
     */
    void deleteAdminMessageById(Integer adminMessageId);

    /**
     * 5.更新管理员通知(单行直接替换)
     *
     * @param adminMessage
     */
    void updateAdminMessage(AdminMessage adminMessage);


    /**
     * 6.通过通知名称模糊(like)查询符合条件通知
     *
     * @param adminMessageTitle
     * @return 多行实例组成的table
     */
    List<AdminMessage> selectAdminMessageByTitleLike(String adminMessageTitle);
}
