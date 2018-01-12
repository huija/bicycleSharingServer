package org.bicyclesharing.service;

import org.bicyclesharing.entities.Admin;
import org.bicyclesharing.entities.AdminMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2017/7/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    //换一下测试顺序,先进行插入
    @Test
    public void addAdmin() throws Exception {
        boolean b = adminService.addAdmin("yanghao", "123456", "123456", "1150555483@qq.com");
        System.out.println(b);
    }

    @Test
    public void login() throws Exception {
        System.out.println(adminService.login("huija", "123456"));
    }

    @Test
    public void removeAdmin() throws Exception {
        System.out.println(adminService.removeAdmin(1));
    }

    @Test
    public void getAdminById() throws Exception {
        System.out.println(adminService.getAdminById(1).toString());
    }

    @Test
    public void getAdminByName() throws Exception {
        System.out.println(adminService.getAdminByName("huija").toString());
    }

    @Test
    public void getAllAdmin() throws Exception {
        List<Admin> adminList = adminService.getAllAdmin();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }

    @Test
    public void getAdminByNameLike() throws Exception {
        System.out.println(adminService.getAdminByNameLike("ui").toString());
    }

    @Test
    public void editAdmin() throws Exception {
        boolean b = adminService.editAdmin(1, "huija", "123456", "1150555483@qq.com");
        System.out.println(b);
    }

    /*---------------------------------------------------------------------*/
    @Test
    public void addAdminMessage() throws Exception {
        boolean b = adminService.addAdminMessage("the second广播体操", "初升的太阳", 1);
        System.out.println(b);
    }

    @Test
    public void editAdminMessage() throws Exception {
        boolean b = adminService.editAdminMessage(1, "第二套全国中学生广播体操", "初升的太阳");
        System.out.println(b);
    }

    @Test
    public void getAdminMessageById() throws Exception {
        System.out.println(adminService.getAdminMessageById(1));
    }

    @Test
    public void getAllAdminMessage() throws Exception {
        List<AdminMessage> adminMessageList = adminService.getAllAdminMessage();
        for (AdminMessage adminMessage : adminMessageList) {
            System.out.println(adminMessage);
        }
    }

    @Test
    public void removeAdminMessage() throws Exception {
        boolean b = adminService.removeAdminMessage(2);
        System.out.println(b);
    }

    @Test
    public void getAdminMessageByTitleLike() throws Exception {
        System.out.println(adminService.getAdminMessageByTitleLike("第二套"));
    }

}