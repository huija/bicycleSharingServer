package org.bicyclesharing.web.Controller;

import org.bicyclesharing.entities.UserFeedback;
import org.bicyclesharing.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

/**
 * 用户反馈页面控制器
 * Created by HuiJa on 2017/8/7.
 */
@Controller
public class UserFeedbackController {
    @Autowired
    private UserFeedbackService userFeedbackService;

    /**
     * 1.列表页
     *
     * @param requestMap
     * @param page
     * @return
     */
    @RequestMapping(value = "admin-feedback-list-show", method = RequestMethod.GET)
    public String listShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        //映射
        requestMap.put("nav", "userFeedback-list");
        //获取列表
        ArrayList<UserFeedback> userFeedbacks = (ArrayList<UserFeedback>) userFeedbackService.getAllFeedback();
        requestMap.put("userFeedbacks", userFeedbacks);
        int pageCount = userFeedbacks.size();  //数据条数
        int pageSize = 10;  //分页条数
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
        ArrayList<UserFeedback> pageUserFeedbacks = new ArrayList<>();
        if (pageMax == 1) {
            pageUserFeedbacks.addAll(userFeedbacks);
        } else if (pagePointer == pageMax) {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * (pagePointer - 1) + (pageCount % pageSize); ++i) {
                pageUserFeedbacks.add(userFeedbacks.get(i));
            }
        } else {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * pagePointer; ++i) {
                pageUserFeedbacks.add(userFeedbacks.get(i));
            }
        }
        requestMap.put("pageMax", pageMax);
        requestMap.put("pagePoint", pagePointer);
        requestMap.put("pageUserFeedbacks", pageUserFeedbacks);
        return "feedback/userFeedback_list";
    }

    /**
     * 2.修改状态为已读
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-userFeedback-resolved-execute/{id}", method = RequestMethod.GET)
    public String resolved(@PathVariable("id") Integer id) {
        userFeedbackService.resolved(id);
        return "redirect:/admin-feedback-list-show?page=1";
    }
    /**
     * 3.根据id删除用户反馈
     */
    @RequestMapping(value="admin-userFeedback-removeuser-execute/{feedbackId}",method=RequestMethod.GET)
    public String removeUserFeedbackExecute(@PathVariable Integer feedbackId){
        UserFeedback userFeedback=userFeedbackService.getFeedback(feedbackId);
        if (userFeedback.getFeedbackStatement()==1){
            userFeedbackService.removeFeedback(feedbackId);
        }
        return "redirect:/admin-feedback-list-show?page=1";
    }
}
