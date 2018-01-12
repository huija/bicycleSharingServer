package org.bicyclesharing.web.Controller;

import org.bicyclesharing.entities.Admin;
import org.bicyclesharing.entities.AdminMessage;
import org.bicyclesharing.entities.Bicycle;
import org.bicyclesharing.entities.Recharge;
import org.bicyclesharing.service.*;
import org.bicyclesharing.util.DateCompareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 后台首页控制器
 * Created by HuiJa on 2017/7/25.
 */
@Controller
public class IndexController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private BicycleService bicycleService;

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private RechargeService rechargeService;

    /**
     * 1.后台管理页面首页显示
     *
     * @return index/index_content.jsp
     */
    @RequestMapping(value = "admin-index-index-show", method = RequestMethod.GET)
    public String indexShow(Map<String, Object> requestMap) {
        //导航栏active
        requestMap.put("nav", "index");
        //用户数量
        requestMap.put("userCount", userService.getUserCount());
        //单车数量
        requestMap.put("bicycleCount", bicycleService.getBicycleCount());
        //当前骑行车辆
        requestMap.put("bicycleCountUsing", bicycleService.getBicycleCountByStatement(0));
        //红色车辆数量
        requestMap.put("bicycleCountRed", bicycleService.getBicycleCountByStatement(-1));
        //绿色车辆数量
        requestMap.put("bicycleCountGreen", bicycleService.getBicycleCountByStatement(1));
        //今日消费金额
        requestMap.put("borrowCost", borrowService.getBorrowCost());
        //今日用户充值金额
        requestMap.put("rechargeCount", rechargeService.getRechargeCount());
        //管理员通知
        ArrayList<AdminMessage> adminMessages = (ArrayList<AdminMessage>) adminService.getAllAdminMessage();
        requestMap.put("adminMessages", adminMessages);
        //修改车辆状况
        ArrayList<Bicycle> bicycles = (ArrayList<Bicycle>) bicycleService.getAllBicycle();
        for (Bicycle bicycle : bicycles) {
            if (DateCompareUtil.differentDaysByMillisecond(bicycle.getBicycleLastTime(), new Date()) > 4 && bicycle.getBicycleStatement() == 1) {
                bicycle.setBicycleStatement(-1);
                bicycleService.editBicycyle(bicycle.getBicycleId(), bicycle.getBicycleCurrentX(), bicycle.getBicycleCurrentY(), bicycle.getBicycleLastTime(), bicycle.getBicycleStatement());
            } else if (DateCompareUtil.differentDaysByMillisecond(bicycle.getBicycleLastTime(), new Date()) <= 4 && bicycle.getBicycleStatement() == -1) {
                bicycle.setBicycleStatement(1);
                bicycleService.editBicycyle(bicycle.getBicycleId(), bicycle.getBicycleCurrentX(), bicycle.getBicycleCurrentY(), bicycle.getBicycleLastTime(), bicycle.getBicycleStatement());
            }
        }
        return "index/index_content";
    }

    /**
     * 2.后台管理登录页面显示
     */
    @RequestMapping(value = "admin-index-login-show", method = RequestMethod.GET)
    public String loginShow() {
        return "index/index_login";
    }

    /**
     * 3.管理员登录执行
     *
     * @return index/index_content.jsp
     */
    @RequestMapping(value = "admin-index-login-execute", method = RequestMethod.POST)
    public String loginExecute(Map<String, Object> requestMap, HttpSession session,
                               @RequestParam("name") String name, @RequestParam("password") String password) {
        int loginSuccess = adminService.login(name, password);
        String view = "redirect:/admin-index-index-show";
        if (loginSuccess == 1) { //登录成功
            Admin admin = adminService.getAdminByName(name);
            requestMap.put("admin", admin);
            session.setAttribute("admin", admin);
        } else { //登录失败
            requestMap.put("adminLoginError", "1");
            view = "index/index_login";
        }
        return view;
    }

    /**
     * 4.修改账户显示
     *
     * @return index/index_edit.jsp
     */
    @RequestMapping(value = "admin-index-edit-show", method = RequestMethod.GET)
    public String editShow() {
        return "index/index_edit";
    }

    /**
     * 5.修改账户信息执行
     *
     * @return
     */
    @RequestMapping(value = "admin-index-edit-execute", method = RequestMethod.POST)
    public String editAdminExecute(@RequestParam("id") Integer id,
                                   @RequestParam("name") String name, @RequestParam("password") String password,
                                   @RequestParam("email") String email, HttpSession session) {
        boolean editSuccess = adminService.editAdmin(id, name, password, email);
        Admin admin = adminService.getAdminById(id);
        session.setAttribute("admin", admin);
        String view = "redirect:/admin-index-index-show";
        if (!editSuccess) {
            view = "redirect:/admin-index-edit-show";
        }
        return view;
    }

    /**
     * 6.退出登录
     *
     * @return index/index_login.jsp
     */
    @RequestMapping(value = "admin-index-exit-execute", method = RequestMethod.GET)
    public String exitExecute(HttpSession session) {
        session.removeAttribute("admin");
        session.removeAttribute("advanced");
        return "redirect:/admin-index-login-show";
    }

    /**
     * 7.显示管理员通知详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-index-message-show/{id}", method = RequestMethod.GET)
    public String adminMessageShow(@PathVariable("id") Integer id, Map<String, Object> requestMap) {
        requestMap.put("nav", "index");
        AdminMessage adminMessage = adminService.getAdminMessageById(id);
        requestMap.put("adminMessage", adminMessage);
        return "index/index_message";
    }

}

