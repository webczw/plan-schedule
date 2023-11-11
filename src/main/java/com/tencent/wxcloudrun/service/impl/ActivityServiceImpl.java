package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ActivityMapper;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public Activity create(Activity activity) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String currentDate = formatter.format(new Date());
        String codePrefix = "AT" + currentDate + "-";
        Integer count = activityMapper.findByCode(codePrefix);
        String leftPad = String.format("%05d", (count + 1));
        String activityFlowCode = codePrefix + leftPad;
        activity.setActivityCode(activityFlowCode);
        activityMapper.create(activity);
        return activity;
    }

    @Override
    public List<Activity> findByActivityFlowId(Long activityFlowId) {
        return activityMapper.findByActivityFlowId(activityFlowId);
    }

    @Override
    public Integer update(Activity activity) {
        return activityMapper.update(activity);
    }

    @Override
    public Integer delete(Activity activity) {
        return activityMapper.delete(activity);
    }
}
