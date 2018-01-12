package org.bicyclesharing.web.API;

import org.bicyclesharing.entities.Bicycle;
import org.bicyclesharing.entities.User;
import org.bicyclesharing.entities.UserFeedback;
import org.bicyclesharing.service.BicycleService;
import org.bicyclesharing.service.UserFeedbackService;
import org.bicyclesharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by HuiJa on 2017/8/7.
 */
@Controller
public class UserFeedbackApi {
    @Autowired
    private UserFeedbackService userFeedbackService;
    @Autowired
    private UserService userService;
    @Autowired
    private BicycleService bicycleService;

    /**
     * 1.插入一条用户反馈
     */
    @RequestMapping(value = "api-userFeedback-add/{feedbackTitle}/{feedbackContent}/{bicycleId}/{userName}")
    @ResponseBody
    public String addUserfeedback(@PathVariable("userName") String userName, @PathVariable("bicycleId") Integer bicycleId,
                                  @PathVariable("feedbackTitle") String feedbackTitle, @PathVariable("feedbackContent") String feedbackContent)
            throws UnsupportedEncodingException {
        if ( "".equals(feedbackTitle)|| "".equals(feedbackContent)) {
            return "-1";//输入为空(虽然输入为空根本传不过来,但还是要写一下的...)
        } else {
            Bicycle bicycle=bicycleService.getBicycleById(bicycleId);
            if (bicycle==null){
                return "-2";//车辆不存在
            }
            User user = userService.getUserByName(userName);
            /*url中文参数传递过来乱码(这样也能解决,但是不知道为什么个别汉字会引发404错误,
			所以弄到这的需要去Tomcat的server.xml修改一下默认编码格式ISO-8859-1,改成utf-8)
            feedbackTitle=new String(feedbackTitle.getBytes("ISO-8859-1"),"UTF-8");
            feedbackContent=new String(feedbackContent.getBytes("ISO-8859-1"),"UTF-8");*/
            UserFeedback userFeedback = new UserFeedback(feedbackTitle, feedbackContent, user.getUserId(), bicycleId, new Date(), 0);
            if (userFeedback == null) {
                return "-3";//反馈对象创建失败
            } else {
                boolean addUserFeedback = userFeedbackService.addFeedback(userFeedback);
                if (addUserFeedback) {
                    return "1";
                } else {
                    return "0";//反馈失败
                }
            }
        }
    }
}
