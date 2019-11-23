package com.revivable.user.vo;

import com.revivable.service.CourseInfo;
import com.revivable.service.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

//用户课程信息对象定义
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public static UserCourseInfo inValid(){
        return new UserCourseInfo(UserInfo.inValid(), Collections.emptyList());
    }
}
