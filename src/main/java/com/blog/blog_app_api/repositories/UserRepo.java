package com.blog.blog_app_api.repositories;

import com.blog.blog_app_api.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
