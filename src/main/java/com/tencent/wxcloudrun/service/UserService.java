package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.User;

import java.util.Optional;

public interface UserService {

  Optional<User> getUser(Long userId);

}
