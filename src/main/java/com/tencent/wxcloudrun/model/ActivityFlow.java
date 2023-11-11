package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ActivityFlow implements Serializable {
    private Long activityFlowId;
    private String activityFlowCode;
    private String activityFlowName;
    private String activityFlowDescription;
    private String createBy;
    private LocalDateTime createDate;
    private String lastUpdateBy;
    private LocalDateTime lastUpdateDate;
}
