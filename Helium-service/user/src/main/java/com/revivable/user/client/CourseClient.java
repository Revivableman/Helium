package com.revivable.user.client;

import com.revivable.service.CourseInfo;
import com.revivable.service.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "course",fallback = CourseClientHystrix.class)
public interface CourseClient {

    @RequestMapping(value = "/course/get/course/{id}",method = RequestMethod.GET)
    CourseInfo getCourseInfo(@PathVariable Long id);

    @RequestMapping(value = "/course/get/courses",method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
