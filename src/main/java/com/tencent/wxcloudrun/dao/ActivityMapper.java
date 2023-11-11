package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {

    Integer create(Activity activity);

    List<Activity> findByActivityFlowId(Long activityFlowId);

    Integer update(Activity activity);

    Integer delete(Activity activity);

    Integer findByCode(String codePrefix);

}
