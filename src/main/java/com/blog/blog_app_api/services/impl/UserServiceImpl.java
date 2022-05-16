package com.blog.blog_app_api.services.impl;

import java.util.List;
import java.util.function.*;

import com.blog.blog_app_api.entitties.User;
import com.blog.blog_app_api.payloads.UserDto;
import com.blog.blog_app_api.repositories.UserRepo;
import com.blog.blog_app_api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.usertoDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.getById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public UserDto getUserById(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        // TODO Auto-generated method stub

    }

    private User dtoToUser(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return user;
    }

    private UserDto usertoDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());

        return userDto;
    }
}
