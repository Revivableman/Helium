package com.revivable.user.client;

import com.revivable.service.CourseInfo;
import com.revivable.service.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

//熔断降级策略
@Component
public class CourseClientHystrix implements CourseClient{
    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.inValid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
