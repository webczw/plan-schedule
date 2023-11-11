package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ActivityFlowMapper;
import com.tencent.wxcloudrun.model.ActivityFlow;
import com.tencent.wxcloudrun.service.ActivityFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ActivityFlowServiceImpl implements ActivityFlowService {

    @Resource
    private ActivityFlowMapper activityFlowMapper;

    @Override
    public ActivityFlow create(ActivityFlow activityFlow) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String currentDate = formatter.format(new Date());
        String codePrefix = "AF" + currentDate + "-";
        Integer count = activityFlowMapper.findByCode(codePrefix);
        String leftPad = String.format("%05d", (count + 1));
        String activityFlowCode = codePrefix + leftPad;
        activityFlow.setActivityFlowCode(activityFlowCode);
        activityFlowMapper.create(activityFlow);
        return activityFlow;
    }

    @Override
    public List<ActivityFlow> findCreateBy(String createBy) {
        return activityFlowMapper.findCreateBy(createBy);
    }

    @Override
    public Integer update(ActivityFlow activityFlow) {
        return activityFlowMapper.update(activityFlow);
    }

    @Override
    public Integer delete(ActivityFlow activityFlow) {
        return activityFlowMapper.delete(activityFlow);
    }
}
