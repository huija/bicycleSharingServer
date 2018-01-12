package org.bicyclesharing.web.API;

import org.bicyclesharing.entities.Bicycle;
import org.bicyclesharing.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * 单车相关api
 * Created by HuiJa on 2017/7/31.
 */
@Controller
public class BicycleApi {
    @Autowired
    private BicycleService bicycleService;

    /**
     * 1.获取附近各状态车辆信息api
     */
    @RequestMapping(value = "api-bicycle-queryByLocation/{bicycleCurrentX}/{bicycleCurrentY}/end")
    @ResponseBody
    public ArrayList<Bicycle> getBicycleByLocation(@PathVariable("bicycleCurrentX") double bicycleCurrentX, @PathVariable("bicycleCurrentY") double bicycleCurrentY) {
        ArrayList<Bicycle> bicycles = (ArrayList<Bicycle>) bicycleService.getBicycleByLocation(bicycleCurrentX, bicycleCurrentY);
        return bicycles;
    }

    /**
     * 2.获取不同状态车辆的经纬度
     */
    @RequestMapping(value = "api-bicycle-getX/{bicycleStatement}")
    @ResponseBody
    public Double[] getXByStatement(@PathVariable("bicycleStatement") Integer bicycleStatement) {
        return bicycleService.getBicycleCurrentXByStatement(bicycleStatement);
    }

    @RequestMapping(value = "api-bicycle-getY/{bicycleStatement}")
    @ResponseBody
    public Double[] getYByStatement(@PathVariable("bicycleStatement") Integer bicycleStatement) {
        return bicycleService.getBicycleCurrentYByStatement(bicycleStatement);
    }
}
