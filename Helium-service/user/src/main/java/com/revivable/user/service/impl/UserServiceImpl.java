package com.revivable.user.service.impl;

import com.revivable.service.CourseInfo;
import com.revivable.service.CourseInfosRequest;
import com.revivable.service.UserInfo;
import com.revivable.user.client.CourseClient;
import com.revivable.user.dao.UserCourseDao;
import com.revivable.user.dao.UserDao;
import com.revivable.user.entity.User;
import com.revivable.user.entity.UserCourse;
import com.revivable.user.service.UserService;
import com.revivable.user.vo.CreateUserRequest;
import com.revivable.user.vo.UserCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserCourseDao userCourseDao;
    @Autowired
    private CourseClient courseClient;

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if(!request.validate())
            return UserInfo.inValid();
        User oldUser = userDao.findByUsername(request.getUsername());
        if(null != oldUser){
            //说明当前用户名已经被注册了
            return UserInfo.inValid();
        }

        User newUser = userDao.save(new User(request.getUsername(),request.getEmail()));
        return new UserInfo(newUser.getId(),newUser.getUsername(),newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<User> user = userDao.findById(id);
        if(!user.isPresent())
            return UserInfo.inValid();
        User currentUser = user.get();
        return new UserInfo(currentUser.getId(),currentUser.getUsername(),currentUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        Optional<User> user = userDao.findById(id);
        if(!user.isPresent())
            return UserCourseInfo.inValid();
        User currentInfo = user.get();
        UserInfo userInfo = new UserInfo(currentInfo.getId(),currentInfo.getUsername(),currentInfo.getEmail());
        List<UserCourse> userCourses = userCourseDao.findAllByUserId(id);
        if(CollectionUtils.isEmpty(userCourses)){
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }
        List<CourseInfo> courseInfos = courseClient.getCourseInfos(new CourseInfosRequest(userCourses.stream()
                .map(UserCourse::getCourseId).collect(Collectors.toList())));
        return new UserCourseInfo(userInfo,courseInfos);
    }
}
