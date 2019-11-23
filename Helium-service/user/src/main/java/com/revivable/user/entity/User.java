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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "username",nullable = false)
    private String username;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    @Basic
    @CreatedDate
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
