package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long userId;
    private String userCode;
    private String userName;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
}
