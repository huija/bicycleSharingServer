package bicyclesharing.dao;

import org.bicyclesharing.dao.AdminDao;
import org.bicyclesharing.entities.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by HuiJa on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class AdminDaoTest {
    //注入DAO实现类依赖(忘记注解是空指针异常,没有注入资源)
    @Resource
    private AdminDao adminDao;

    @Test
    public void selectAdminById() throws Exception {
        Admin admin = adminDao.selectAdminById(13);
        if (admin != null) {
            System.out.println(admin.toString());
        } else System.out.println("没有这个管理员");

    }

    @Test
    public void selectAdminByName() throws Exception {
        Admin admin = adminDao.selectAdminByName("huija");
        if (admin != null) {
            System.out.println(admin.toString());
        } else System.out.println("没有这个管理员");
    }

    @Test
    public void selectAllAdmin() throws Exception {
        List<Admin> adminList = adminDao.selectAllAdmin();
        //foreach可以分行输出,也可以直接输出adminList只不过在一行
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }

    @Test
    public void insertAdmin() throws Exception {
        Admin admin = new Admin(1, "huija", "123456", "1150555483@qq.com");
        try {
            adminDao.insertAdmin(admin);
        } catch (Exception e) {
            System.out.println("主键冲突");
        }
    }

    @Test
    public void deleteAdmin() throws Exception {
        adminDao.deleteAdmin(0);
    }

    @Test
    public void updateAdmin() throws Exception {
        Admin admin = new Admin(2, "chaidog", "dog123", "929285933@qq.com");
        adminDao.updateAdmin(admin);
    }

    @Test
    public void selectAdminByNameLike() throws Exception {
        System.out.println(adminDao.selectAdminByNameLike("oo"));
    }

}
