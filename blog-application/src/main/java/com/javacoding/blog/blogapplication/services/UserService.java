package com.javacoding.blog.blogapplication.services;

import com.javacoding.blog.blogapplication.payloads.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Long userId);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
