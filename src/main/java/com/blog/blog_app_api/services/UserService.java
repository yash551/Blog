package com.blog.blog_app_api.services;

import java.util.List;

import com.blog.blog_app_api.entitties.User;
import com.blog.blog_app_api.payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
