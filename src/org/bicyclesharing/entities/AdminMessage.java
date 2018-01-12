package org.bicyclesharing.entities;

import java.util.Date;

/**
 * 管理员通知
 * Created by HuiJa on 2017/7/20.
 */
public class AdminMessage {
    //管理员通知的id
    private Integer adminMessageId;
    //管理员通知的标题
    private String adminMessageTitle;
    //管理员通知的内容
    private String adminMessageContent;
    //发布时间
    private Date adminMessageTime;
    //发布信息的管理员id
    private Integer adminId;


    //映射多对一关联关系,发布消息的管理员实体类
    private Admin admin;

    public AdminMessage() {
    }

    public AdminMessage(String adminMessageTitle, String adminMessageContent, Date adminMessageTime, Integer adminId) {
        this.adminMessageTitle = adminMessageTitle;
        this.adminMessageContent = adminMessageContent;
        this.adminMessageTime = adminMessageTime;
        this.adminId = adminId;
    }

    public AdminMessage(Integer adminMessageId, String adminMessageTitle, String adminMessageContent, Date adminMessageTime, Integer adminId) {
        this.adminMessageId = adminMessageId;
        this.adminMessageTitle = adminMessageTitle;
        this.adminMessageContent = adminMessageContent;
        this.adminMessageTime = adminMessageTime;
        this.adminId = adminId;
    }

    public Integer getAdminMessageId() {
        return adminMessageId;
    }

    public void setAdminMessageId(Integer adminMessageId) {
        this.adminMessageId = adminMessageId;
    }

    public String getAdminMessageTitle() {
        return adminMessageTitle;
    }

    public void setAdminMessageTitle(String adminMessageTitle) {
        this.adminMessageTitle = adminMessageTitle;
    }

    public String getAdminMessageContent() {
        return adminMessageContent;
    }

    public void setAdminMessageContent(String adminMessageContent) {
        this.adminMessageContent = adminMessageContent;
    }

    public Date getAdminMessageTime() {
        return adminMessageTime;
    }

    public void setAdminMessageTime(Date adminMessageTime) {
        this.adminMessageTime = adminMessageTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "AdminMessage{" +
                "adminMessageId=" + adminMessageId +
                ", adminMessageTitle='" + adminMessageTitle + '\'' +
                ", adminMessageContent='" + adminMessageContent + '\'' +
                ", adminMessageTime=" + adminMessageTime +
                ", adminId=" + adminId +
                '}';
    }
}
