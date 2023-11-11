package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ActivityFlow;

import java.util.List;

public interface ActivityFlowService {
    ActivityFlow create(ActivityFlow activityFlow);

    List<ActivityFlow> findCreateBy(String createBy);

    Integer update(ActivityFlow activityFlow);

    Integer delete(ActivityFlow activityFlow);
}
