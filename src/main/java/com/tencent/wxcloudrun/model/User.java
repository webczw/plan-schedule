package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long userId;
    private String userCode;
    private String userName;
    private Date createDate;
    private Date lastUpdateDate;
}
