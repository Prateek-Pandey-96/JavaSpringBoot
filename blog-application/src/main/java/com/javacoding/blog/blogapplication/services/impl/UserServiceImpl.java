package com.javacoding.blog.blogapplication.services.impl;

import com.javacoding.blog.blogapplication.entities.User;
import com.javacoding.blog.blogapplication.payloads.UserDto;
import com.javacoding.blog.blogapplication.repositories.UserRepository;
import com.javacoding.blog.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.javacoding.blog.blogapplication.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        User updatedUser = userRepository.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        userRepository.delete(user);
    }

    private User dtoToUser(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

    private UserDto userToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }
}
