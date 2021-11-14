package com.cafebabe.controller;

import com.cafebabe.entity.User;
import com.cafebabe.security.RegistrationRequest;
import com.cafebabe.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    protected UserServiceImpl userService;

    @PostMapping("api/users")
    public User create(@RequestBody RegistrationRequest registrationRequest) {
        return userService.create(registrationRequest);
    }
}
