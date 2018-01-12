package org.bicyclesharing.dao;

import org.bicyclesharing.entities.Admin;

import java.util.List;

/**
 * Created by HuiJa on 2017/7/20.
 */
public interface AdminDao {

    /**
     * 1.通过管理员id查询管理员信息
     *
     * @param adminId
     * @return 返回一行管理员实例
     */
    Admin selectAdminById(Integer adminId);

    /**
     * 2.通过管理员名字查询管理员信息
     *
     * @param adminName 管理员
     * @return 返回一行管理员实例
     */
    Admin selectAdminByName(String adminName);

    /**
     * 3.查询所有管理员信息
     *
     * @return 返回管理员table
     */
    List<Admin> selectAllAdmin();

    /**
     * 4.插入管理员(inserts)
     *
     * @param admin
     */
    void insertAdmin(Admin admin);

    /**
     * 5.根据管理员id删除管理员
     * 删除数据需谨慎,所以这个方法最好不要用,自增id表示很困扰
     * @param adminId
     */
    void deleteAdmin(Integer adminId);

    /**
     * 6.更新管理员信息(通过id识别哪一行,具体看sql)
     *
     * @param admin
     */
    void updateAdmin(Admin admin);


    /**
     * 7.通过名称模糊(like)查询符合条件管理员
     * @param adminName
     * @return 多行实例组成的table
     */
    List<Admin> selectAdminByNameLike(String adminName);


}
