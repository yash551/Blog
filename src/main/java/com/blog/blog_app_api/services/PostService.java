package com.blog.blog_app_api.services;

import java.util.List;

import com.blog.blog_app_api.entities.Post;
import com.blog.blog_app_api.payloads.PostDto;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    Post updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get
    Post getPostById(Integer postId);

    // get all post
    List<Post> getAllPost();

    // get all post by category
    List<Post> getPostsByCategory(Integer categoryId);

    // get all post by user
    List<Post> getPostsByUser(Integer userId);

    // search posts by keyword
    List<Post> searchPosts(String keyword);
}
