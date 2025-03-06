package com.shopsnap.shopsnap.service;

import com.shopsnap.shopsnap.payload.UserDto;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, String email);
    void deleteUser(String email);
    List<UserDto> getAllUsers();
    UserDto getUserByEmail(String email);
}
