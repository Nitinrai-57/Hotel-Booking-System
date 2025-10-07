package com.userservice.controllers;

import com.userservice.dtos.AuthResponse;
import com.userservice.dtos.LoginRequest;
import com.userservice.dtos.RegisterRequest;
import com.userservice.dtos.UpdateUserRequest;
import com.userservice.entities.User;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    UserService userService;




    @PostMapping("/register")
    public ResponseEntity<User>register(@RequestBody RegisterRequest registerRequest){

        return new ResponseEntity<>( userService.register(registerRequest),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest)
    {
        return new ResponseEntity<AuthResponse>(userService.login(loginRequest),HttpStatus.OK);
    }

//    @GetMapping("/me")
//    public ResponseEntity<UserResponse> me(Auth)

    @GetMapping("userId/{id}")
    public User get(@PathVariable Long id)
    {
        return userService.getById(id);
    }

    @GetMapping("username/{username}")
    public User get(@PathVariable String username)
    {

    return userService.getByName(username);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody UpdateUserRequest req){
        return userService.updateUser(id,req);
    }
    @GetMapping("/me")
    public User me(Authentication authentication){

        return userService.getByName(authentication.getName());
    }


    @GetMapping
    ResponseEntity<List<User>> getAllUser(){
     return  new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody User user)
    {
        System.out.println("DEBUG");
        return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.OK);
    }

    public static UserResponse toDto(User u)
    {
        return new UserResponse(u.getId(),u.getUsername(),u.getEmail(),u.getFirstName(),u.getPhoneNumber(),
        u.getLastName(),u.getRole().name(),u.getStatus().name()
                );
    }
}
