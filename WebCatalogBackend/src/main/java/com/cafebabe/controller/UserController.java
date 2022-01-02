package com.cafebabe.controller;

import com.cafebabe.entity.User;
import com.cafebabe.security.ERole;
import com.cafebabe.security.RegistrationRequest;
import com.cafebabe.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    protected UserServiceImpl userService;

    @PostMapping("api/users")
    public User create(@RequestBody RegistrationRequest registrationRequest) {
        return userService.create(registrationRequest);
    }

    @GetMapping("api/users")
    public List<User> findUsers(@RequestParam(required = false) String name, @RequestParam(required = false) String surname, @RequestParam(required = false) String email, @RequestParam UserSearchType searchType, ERole role) {
        List<User> result = null;
        if (UserSearchType.EMAIL.equals(searchType)) {
            result = userService.findByEmailAndRole(email, role);
        } else {
            result = userService.findByNameAndSurnameAndRole(name, surname, role);
        }
        return result;
    }

    @GetMapping("api/users/{id}")
    public User findById(@PathVariable BigInteger id) {
        return userService.findById(id);
    }

    enum UserSearchType {
        NAME_AND_SURNAME, EMAIL
    }
}
