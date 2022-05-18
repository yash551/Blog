package com.blog.blog_app_api.services;

import com.blog.blog_app_api.payloads.CategoryDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    // create
    public CategoryDto createCategory(CategoryDto categoryDto);

    // update
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // delete
    public void deleteCategory(Integer categoryId);

    // get
    public CategoryDto getCategory(Integer categoryId);

    // get all
    public List<CategoryDto> getAllCategories();
}
