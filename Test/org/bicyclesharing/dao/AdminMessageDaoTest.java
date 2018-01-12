package org.bicyclesharing.dao;

import org.bicyclesharing.entities.AdminMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by HuiJa on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class AdminMessageDaoTest {

    @Resource
    private AdminMessageDao adminMessageDao;

    @Test
    public void getAdminMessage() throws Exception {
        System.out.println(adminMessageDao.getAdminMessage(1));
    }

    @Test
    public void selectAllAdminMessage() throws Exception {
        List<AdminMessage> adminMessageList = adminMessageDao.selectAllAdminMessage();
        for (AdminMessage adminMessage : adminMessageList) {
            System.out.println(adminMessage);
        }
    }

    @Test
    public void insertAdminMessage() throws Exception {
        AdminMessage adminMessage = new AdminMessage("第二套广播体操", "初升的太阳", new Date(), 1);
        adminMessageDao.insertAdminMessage(adminMessage);
    }

    @Test
    public void deleteAdminMessageById() throws Exception {
        adminMessageDao.deleteAdminMessageById(0);
    }

    @Test
    public void updateAdminMessage() throws Exception {
        AdminMessage adminMessage = new AdminMessage( "柴钊是傻吊", "A318都同意", new Date(), 1);
        adminMessageDao.updateAdminMessage(adminMessage);
    }

    @Test
    public void selectAdminMessageByTitleLike() throws Exception {
        System.out.println(adminMessageDao.selectAdminMessageByTitleLike("第二套"));
    }
}
