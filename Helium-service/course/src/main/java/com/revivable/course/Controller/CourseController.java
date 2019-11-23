package com.revivable.course.Controller;

import com.alibaba.fastjson.JSON;
import com.revivable.course.service.CourseService;
import com.revivable.service.CourseInfo;
import com.revivable.service.CourseInfosRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * localhost:7001/course/get/course/1
     * localhost:9000/revivable/course/get/course/1
     */
    @GetMapping("/get/course/{id}")
    public CourseInfo getCourseInfo(@PathVariable Long id){
        log.info("get course -> {}",id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request){
        log.info("get courses ->{}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
