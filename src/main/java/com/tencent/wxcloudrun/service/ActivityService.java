package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Activity;

import java.util.List;

public interface ActivityService {
    Activity create(Activity activity);

    List<Activity> findByActivityFlowId(Long activityFlowId);

    Integer update(Activity activity);

    Integer delete(Activity activity);
}
