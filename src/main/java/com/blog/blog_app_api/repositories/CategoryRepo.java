package com.blog.blog_app_api.repositories;

import com.blog.blog_app_api.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
