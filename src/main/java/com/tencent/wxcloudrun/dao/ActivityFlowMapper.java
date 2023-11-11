package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ActivityFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityFlowMapper {
    Integer create(ActivityFlow activityFlow);

    List<ActivityFlow> findCreateBy(String createBy);

    Integer update(ActivityFlow activityFlow);

    Integer delete(ActivityFlow activityFlow);

    Integer findByCode(String codePrefix);
}
