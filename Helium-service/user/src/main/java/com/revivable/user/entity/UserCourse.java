package com.revivable.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_course")
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Basic
    @Column(name = "course_id",nullable = false)
    private Long courseId;

    @Basic
    @CreatedDate
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time",nullable = false)
    private Date updateTime;

}
