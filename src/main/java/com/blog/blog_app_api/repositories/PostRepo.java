package com.blog.blog_app_api.repositories;

import java.util.List;

import com.blog.blog_app_api.entities.Category;
import com.blog.blog_app_api.entities.Post;
import com.blog.blog_app_api.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
