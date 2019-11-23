package com.revivable.user.dao;

import com.revivable.user.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseDao extends JpaRepository<UserCourse,Long> {

    List<UserCourse> findAllByUserId(Long userId);
}
