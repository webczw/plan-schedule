package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private Long userId;
    private String userCode;
    private String userName;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
}
