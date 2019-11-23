package com.revivable.course.service.impl;

import com.revivable.course.dao.CourseDao;
import com.revivable.course.entity.Course;
import com.revivable.course.service.CourseService;
import com.revivable.service.CourseInfo;
import com.revivable.service.CourseInfosRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<Course> course = courseDao.findById(id);
        return course.isPresent() ?
                buildCourseInfo(course.orElse(Course.inValid())): CourseInfo.inValid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if(CollectionUtils.isEmpty(request.getIds()))
            return Collections.emptyList();
        List<Course> courses = courseDao.findAllById(request.getIds());
        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());//java8流编程
    }

    public CourseInfo buildCourseInfo(Course course){
        log.error("course size -> {}",course);
        return CourseInfo.builder().id(course.getId())
                                   .courseName(course.getCourseName())
                                   .courseType(course.getCourseType() == 0
                                           ? "free":"charge")
                                   .courseIcon(course.getCourseIcon())
                                   .courseIntro(course.getCourseIntro()).build();
    }
}
