package com.revivable.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "course_name",nullable = false)
    private String courseName;

    @Basic
    @Column(name = "course_Type",nullable = false)
    private Integer courseType;

    @Basic
    @Column(name = "course_icon",nullable = false)
    private String courseIcon;

    @Basic
    @Column(name = "course_intro",nullable = false)
    private String courseIntro;

    @Basic
    @Column(name = "create_time",nullable = false)
    @CreatedDate
    private Date createTime;

    @Basic
    @Column(name="update_time",nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public Course(String courseName, Integer courseType, String courseIcon, String courseIntro) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    public static Course inValid(){
        Course course = new Course("",0,"","");
        return course;
    }
}
