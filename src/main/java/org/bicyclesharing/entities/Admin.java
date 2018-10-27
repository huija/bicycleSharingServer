package org.bicyclesharing.entities;

/**
 * 管理员实体类
 * Created by HuiJa on 2017/7/20.
 */
public class Admin {
    //如果实体类(一般在dto类里面)里面有state+stateInfo这样的属性,可以将两者摘出来,弄个枚举类,美化代码
    //管理员id,因为是主键,设置了自增,用Integer部分功能将没法使用
    private Integer adminId;
    //管理员名
    private String adminName;
    //管理员密码
    private String adminPassword;
    //管理员邮箱
    private String adminEmail;

    /**
     * 当建立一个带参覆盖的构造方法后,必须显式声明出无参的构造函数
     * 后面就因此出现了No constructor found in ...matching ...
     */
    public Admin() {
    }

    public Admin(String adminName, String adminPassword, String adminEmail) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
    }

    public Admin(int adminId, String adminName, String adminPassword, String adminEmail) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                '}';
    }
}
