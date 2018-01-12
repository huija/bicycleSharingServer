package org.bicyclesharing.web.Controller;

import org.bicyclesharing.entities.Recharge;
import org.bicyclesharing.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by HuiJa on 2017/7/31.
 */
@Controller
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @RequestMapping(value="admin-recharge-list-show", method= RequestMethod.GET)
    public String listShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        requestMap.put("nav", "recharge");
        ArrayList<Recharge> recharges = (ArrayList<Recharge>) rechargeService.getAllRecharge();
        requestMap.put("recharges", recharges);

        int pageCount = recharges.size();  //数据条数
        int pageSize = 20;  //分页条数
        int pageMax = pageCount / pageSize;  //最大页数
        int pagePointer = 1;  //当前指向页
        if (pageMax != 0 && pageCount % pageSize != 0) {
            ++pageMax;
        }
        if (pageMax == 0) {
            pageMax = 1;
        }
        if (page < 1 || page > pageMax) {
            pagePointer = 1;
        } else {
            pagePointer = page;
        }
        ArrayList<Recharge> pageRecharges = new ArrayList<>();
        if (pageMax == 1) {
            pageRecharges.addAll(recharges);
        } else if (pagePointer == pageMax) {
            int tmp = pageCount % pageSize;
            if (tmp == 0) {
                tmp = pageSize;
            }
            for (int i = pageSize * (pagePointer - 1); i < pageSize * (pagePointer - 1) + tmp; ++i) {
                pageRecharges.add(recharges.get(i));
            }
        } else {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * pagePointer; ++i) {
                pageRecharges.add(recharges.get(i));
            }
        }
        requestMap.put("pageMax", pageMax);
        requestMap.put("pagePoint", pagePointer);
        requestMap.put("pageRecharges",pageRecharges);

        return "recharge/recharge_list";
    }

}
