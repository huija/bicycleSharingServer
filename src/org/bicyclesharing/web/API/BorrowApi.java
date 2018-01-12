package org.bicyclesharing.web.API;


import org.bicyclesharing.entities.Bicycle;
import org.bicyclesharing.entities.Borrow;
import org.bicyclesharing.entities.User;
import org.bicyclesharing.service.BicycleService;
import org.bicyclesharing.service.BorrowService;
import org.bicyclesharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * 借车相关api
 * Created by HuiJa on 2017/8/1.
 */
@Controller
public class BorrowApi {
    @Autowired
    BorrowService borrowService;
    @Autowired
    UserService userService;
    @Autowired
    BicycleService bicycleService;


    /**
     * 1.借车开始api,修改单车状况
     */
    @RequestMapping(value = "api-borrow-borrowBicycle/{bicycleId}/{userName}")
    @ResponseBody
    public String borrowBicycle(@PathVariable("bicycleId") Integer bicycleId, @PathVariable("userName") String userName) {
        User user = userService.getUserByName(userName);
        Bicycle bicycle = bicycleService.getBicycleById(bicycleId);
        if (user == null || bicycle == null) {
            //-1表示找不到该车或者该用户不存在
            return "-1";
        } else {
            if (bicycle.getBicycleStatement() == 1 || bicycle.getBicycleStatement() == -1) {
                if (user.getUserCash() == 199) {
                    //添加借车记录(车id,用户名,当前时间,开始地址)
                    borrowService.addBorrow(bicycleId, userService.getUserByName(userName).getUserId(), new Date(), new Date(), bicycle.getBicycleCurrentX(), bicycle.getBicycleCurrentY(), bicycle.getBicycleCurrentX(), bicycle.getBicycleCurrentY(), new BigDecimal(0), user.getUserAccount());
                    //修改单车状况
                    bicycle.setBicycleStatement(0);
                    bicycleService.editBicycyle(bicycleId, bicycle.getBicycleCurrentX(), bicycle.getBicycleCurrentY(), bicycle.getBicycleLastTime(), bicycle.getBicycleStatement());
                    return "1";
                } else return "-2";//未交押金
            } else {
                return "0";//该车正在使用中
            }
        }


    }

    /**
     * 2.借车结束相关api,添加借车记录,修改用户余额,修改单车状况为1(还有地址)
     *
     * @return
     */
    @RequestMapping(value = "api-borrow-returnBicycle/{bicycleId}/{userName}/{ex}/{ey}/{cost}/end")
    @ResponseBody
    public String returnBicycle(@PathVariable("bicycleId") Integer bicycleId, @PathVariable("userName") String userName,
                                @PathVariable("ex") double ex, @PathVariable("ey") double ey,
                                @PathVariable("cost") double cost) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            return "-1";//用户不存在
        } else {
            if (user.getUserAccount().subtract(new BigDecimal(cost)).compareTo(new BigDecimal(0)) < 0) {
                return "0";//用户余额不足,请充值后还车
            } else { //用户的余额减少
                BigDecimal remaining = user.getUserAccount();
                user.setUserAccount(remaining.subtract(new BigDecimal(cost)));
                userService.editUser(user.getUserName(), user.getUserAccount(), user.getUserCredit(), user.getUserCash());
                //完善租借记录
                borrowService.editBorrow(bicycleId, new Date(), ex, ey, new BigDecimal(cost), remaining.subtract(new BigDecimal(cost)));
                //修改车辆状况(最终归还时间地点)
                bicycleService.editBicycyle(bicycleId, ex, ey, new Date(), 1);
                return "1";
            }
        }

    }

    /**
     * 3.查询当前(最后一条)借车记录api(真的蠢,当初为什么要根据车id查询最后一条记录)
     */
    @RequestMapping(value = "api-borrow-currentBorrow/{userName}")
    @ResponseBody
    public Borrow currentBorrow(@PathVariable("userName") String userName) {
        ArrayList<Borrow> borrows = (ArrayList<Borrow>) borrowService.getBorrowByUserId(userService.getUserByName(userName).getUserId());
        if (borrows.size() >= 1) {
            return borrows.get(borrows.size() - 1);
        } else return null;
    }
}
