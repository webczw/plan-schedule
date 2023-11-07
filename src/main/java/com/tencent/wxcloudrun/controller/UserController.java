package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.dto.UserRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.CounterService;
import com.tencent.wxcloudrun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * counter控制器
 */

@RestController
@RequestMapping(value = "/user/api")
public class UserController {

  final UserService userService;
  final Logger logger;

  public UserController(@Autowired UserService userService) {
    this.userService = userService;
    this.logger = LoggerFactory.getLogger(UserController.class);
  }


  /**
   * 获取当前计数
   * @return API response json
   */
  @PostMapping(value = "/detail")
  ApiResponse get(@RequestBody UserRequest request) {
    logger.info("/api/count get request");
    Optional<User> user = userService.getUser(request.getUserId());
    return user.map(ApiResponse::ok).orElseGet(() -> ApiResponse.error("user is null."));
  }
  
}