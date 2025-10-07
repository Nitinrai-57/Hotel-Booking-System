package com.userservice.controllers;

import com.userservice.dtos.AuthResponse;
import com.userservice.dtos.RequestToken;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;

    @PostMapping("/refeshToken")
    public AuthResponse refersh(@RequestBody RequestToken req){
        return userService.refreshToken(req.getRefreshToken());
    }

    @DeleteMapping("/logout")
    public void sessionLogout(@RequestBody RequestToken req)
    {
         userService.logout(req.getRefreshToken());
    }

}
