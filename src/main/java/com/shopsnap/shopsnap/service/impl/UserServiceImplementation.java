package com.shopsnap.shopsnap.service.impl;

import com.shopsnap.shopsnap.exception.ResourceNotFoundException;
import com.shopsnap.shopsnap.model.User;
import com.shopsnap.shopsnap.payload.UserDto;
import com.shopsnap.shopsnap.repository.UserRepository;
import com.shopsnap.shopsnap.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserDto userDto){
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    public UserDto updateUser(UserDto userDto, String email){
        User user = this.userRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("User "," id ",email));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setMobileNo(userDto.getMobileNo());
        user.setAddress(userDto.getAddress());
        User userSaved = this.userRepository.save(user);
        return this.userToDto(userSaved);
    }

    public void deleteUser(String email){
        User user = this.userRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException(" User "," id ",email));
        this.userRepository.delete(user);
    }

    public UserDto getUserByEmail(String email){
        User user = this.userRepository.findById(email).orElseThrow(()-> new ResourceNotFoundException(" User ", " id ",email));
        return this.userToDto(user);
    }

    public List<UserDto> getAllUsers(){
        List<User> userList = this.userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    public UserDto userToDto(User user){
        return this.modelMapper.map(user, UserDto.class);
    }

    public User dtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }
}
