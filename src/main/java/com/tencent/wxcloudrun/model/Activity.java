package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Activity implements Serializable {
    private Long activityId;
    private String activityCode;
    private String activityName;
    private String activityDescription;
    private LocalDateTime planStartDate;
    private LocalDateTime planEndDate;
    private Long activityFlowId;
    private String createBy;
    private LocalDateTime createDate;
    private String lastUpdateBy;
    private LocalDateTime lastUpdateDate;
}
