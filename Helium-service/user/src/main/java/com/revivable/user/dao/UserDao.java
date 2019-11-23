package com.revivable.user.dao;

import com.revivable.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
