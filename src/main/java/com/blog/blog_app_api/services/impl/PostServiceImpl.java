package com.blog.blog_app_api.services.impl;

import java.util.Date;
import java.util.List;

import com.blog.blog_app_api.entities.Category;
import com.blog.blog_app_api.entities.Post;
import com.blog.blog_app_api.entities.User;
import com.blog.blog_app_api.exceptions.ResourceNotFoundException;
import com.blog.blog_app_api.payloads.PostDto;
import com.blog.blog_app_api.repositories.CategoryRepo;
import com.blog.blog_app_api.repositories.PostRepo;
import com.blog.blog_app_api.repositories.UserRepo;

import com.blog.blog_app_api.services.PostService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo UserRepo;

    @Autowired
    private CategoryRepo CategoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.UserRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        Category category = this.CategoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post createdPost = this.postRepo.save(post);

        return this.modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletePost(Integer postId) {
        // TODO Auto-generated method stub

    }

    @Override
    public Post getPostById(Integer postId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

}
