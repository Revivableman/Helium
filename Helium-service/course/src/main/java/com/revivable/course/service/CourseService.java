package com.revivable.course.service;

import com.revivable.service.CourseInfo;
import com.revivable.service.CourseInfosRequest;

import java.util.List;

public interface CourseService {

    //通过id获取信息
    CourseInfo getCourseInfo(Long id);

    //获取课程列表
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
