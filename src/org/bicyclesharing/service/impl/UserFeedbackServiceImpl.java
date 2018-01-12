package org.bicyclesharing.service.impl;

import org.bicyclesharing.dao.UserFeedbackDao;
import org.bicyclesharing.entities.UserFeedback;
import org.bicyclesharing.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by HuiJa on 2017/8/7.
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {
    @Autowired
    private UserFeedbackDao userFeedbackDao;

    @Override
    public boolean addFeedback(UserFeedback userFeedback) {
        userFeedbackDao.insertUserFeedback(userFeedback);
        return true;
    }

    @Override
    public UserFeedback getFeedback(Integer feedbackId) {
        return userFeedbackDao.selectUserFeedbackById(feedbackId);
    }

    @Override
    public List<UserFeedback> getFeedbackByBicycleId(Integer bicycleId) {
        return userFeedbackDao.selectUserFeedbackByUserId(1);
    }

    @Override
    public List<UserFeedback> getFeedbackByUserId(Integer userId) {
        return userFeedbackDao.selectUserFeedbackByBicycleId(1);
    }

    @Override
    public List<UserFeedback> getAllFeedback() {
        return userFeedbackDao.selectAllUserFeedback();
    }

    @Override
    public boolean resolved(Integer feedbackId) {
        if (feedbackId == null) {
            return false;
        } else {
            UserFeedback userFeedback = userFeedbackDao.selectUserFeedbackById(feedbackId);
            userFeedback.setFeedbackStatement(1);
            userFeedbackDao.updateUserFeedback(userFeedback);
            return true;
        }
    }

    @Override
    public boolean removeFeedback(Integer feedbackId) {
        if (feedbackId <= 0 || "".equals(feedbackId)) {
            return false;
        } else {
            userFeedbackDao.deleteUserFeedbackById(feedbackId);
            return true;
        }
    }

}
