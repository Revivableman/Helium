package com.revivable.user.controller;

import com.alibaba.fastjson.JSON;
import com.revivable.service.UserInfo;
import com.revivable.user.service.UserService;
import com.revivable.user.vo.CreateUserRequest;
import com.revivable.user.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        log.info("create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/get/user/{id}")
    public UserInfo getUserInfo(@PathVariable Long id){
        log.info("get user -> {}",id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/course/{id}")
    public UserCourseInfo getUserCourseInfo(@PathVariable Long id){
        log.info("get user course info -> {}",id);
        return userService.getUserCourseInfo(id);
    }
}
