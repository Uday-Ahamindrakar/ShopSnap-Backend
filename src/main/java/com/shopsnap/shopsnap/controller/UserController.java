package com.shopsnap.shopsnap.controller;

import com.shopsnap.shopsnap.payload.UserDto;
import com.shopsnap.shopsnap.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("email") String emailValue){
        UserDto updatedUser = this.userService.updateUser(userDto, emailValue);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable("email") String emailValue){
        this.userService.deleteUser(emailValue);
        return ResponseEntity.ok(Map.of("message","User Deleted Successfully"));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String email){
        return ResponseEntity.ok(this.userService.getUserByEmail(email));
    }
}
