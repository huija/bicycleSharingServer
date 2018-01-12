package org.bicyclesharing.web.API;


import org.bicyclesharing.entities.Borrow;
import org.bicyclesharing.entities.Recharge;
import org.bicyclesharing.entities.User;
import org.bicyclesharing.service.BorrowService;
import org.bicyclesharing.service.RechargeService;
import org.bicyclesharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * 用户相关API
 * Created by HuiJa on 2017/7/31.
 */
@Controller
public class UserApi {
    @Autowired
    private UserService userService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private RechargeService rechargeService;

    /**
     * 1.用户登录接口
     *
     * @param userName
     * @param session
     * @return
     */

    @RequestMapping(value = "api-user-login/{userName}")
    @ResponseBody
    public User login(@PathVariable("userName") String userName, HttpSession session) {
        boolean loginSuccess = userService.login(userName);
        User user = null;
        if (loginSuccess) {
            user = userService.getUserByName(userName);
            session.setAttribute("user", user);
        }
        return user;
    }

    /**
     * 2.用户注册接口
     *
     * @param userName
     * @return 1.注册成功 0.注册失败
     */
    @RequestMapping(value = "api-user-register/{userName}")
    @ResponseBody
    public String register(@PathVariable("userName") String userName) {
        boolean registerSuccess = userService.register(userName);
        if (registerSuccess) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 3.退出登录接口
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "api-user-exit")
    @ResponseBody
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "1";
    }

    /**
     * 4.用户租借记录api
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "api-user-queryBorrow/{userName}")
    @ResponseBody
    public ArrayList<Borrow> getBorrowByUserId(@PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        ArrayList<Borrow> borrows = (ArrayList<Borrow>) borrowService.getBorrowByUserId(user.getUserId());
        return borrows;
    }

    /**
     * 6.用户查询充值记录api
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "api-user-queryRecharge/{userName}")
    @ResponseBody
    public ArrayList<Recharge> getRechargeByUserId(@PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return null;
        } else {
            ArrayList<Recharge> recharges = (ArrayList<Recharge>) rechargeService.getRechargeByUserId(user.getUserId());
            return recharges;
        }

    }

    /**
     * 7.用户充值api,修改余额和充值记录
     */
    @RequestMapping(value = "api-user-recharge/{rechargeAmount}/{userName}")
    @ResponseBody
    public String Recharge(@PathVariable("rechargeAmount") BigDecimal rechargeAmount, @PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return "-1";
        } else {
            //修改用户余额
            user.setUserAccount(user.getUserAccount().add(rechargeAmount));
            userService.editUser(user.getUserName(), user.getUserAccount(), user.getUserCredit(), user.getUserCash());
            //记录充值记录
            rechargeService.addRecharge(user.getUserId(), rechargeAmount, user.getUserAccount(), new Date());
            return "1";
        }
    }

    /**
     * 8.用户信息api
     */
    @RequestMapping(value = "api-user-userInfo/{userName}")
    @ResponseBody
    public User getUserInfo(@PathVariable("userName") String userName) {
        return userService.getUserByName(userName);
    }

    /**
     * 9.查看用户押金
     */
    @RequestMapping(value = "api-user-getUserCash/{userName}")
    @ResponseBody
    public Integer getUserCash(@PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return -1;
        } else {
            return user.getUserCash();
        }

    }

    /**
     * 10.用户提交押金
     */
    @RequestMapping(value = "api-user-submitUserCash/{userName}")
    @ResponseBody
    public String submitUserCash(@PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return "-1";
        } else {
            if (user.getUserCash() == 0) {
                user.setUserCash(199);
                userService.editUser(user.getUserName(), user.getUserAccount(), user.getUserCredit(), user.getUserCash());
                return "1";
            } else {
                return "0";
            }
        }
    }

    /**
     * 11.用户退押金
     */
    @RequestMapping(value = "api-user-returnUserCash/{userName}")
    @ResponseBody
    public String returnUserCash(@PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return "-1";
        } else {
            if (user.getUserCash() == 199) {
                user.setUserCash(0);
                userService.editUser(user.getUserName(), user.getUserAccount(), user.getUserCredit(), user.getUserCash());
                return "1";
            } else {
                return "0";
            }
        }
    }

    /**
     * 12.修改用户信用的api
     * @param x
     * @param userName
     * @return
     */
    @RequestMapping(value = "api-user-changeUserCredit/{x}/{userName}")
    @ResponseBody
    public String changeUserCredit(@PathVariable("x") Integer x, @PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return "-1";
        } else {
            userService.editUser(user.getUserName(), user.getUserAccount(), user.getUserCredit(), user.getUserCash());
            return "1";
        }
    }
}
