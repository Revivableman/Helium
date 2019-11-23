package com.revivable.user.service;

import com.revivable.service.UserInfo;
import com.revivable.user.vo.CreateUserRequest;
import com.revivable.user.vo.UserCourseInfo;

//用户服务相关接口定义
public interface UserService {

    UserInfo createUser(CreateUserRequest request);

    UserInfo getUserInfo(Long id);

    UserCourseInfo getUserCourseInfo(Long id);
}
