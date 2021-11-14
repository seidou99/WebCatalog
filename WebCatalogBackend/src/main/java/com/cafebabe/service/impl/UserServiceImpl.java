package com.cafebabe.service.impl;

import com.cafebabe.entity.User;
import com.cafebabe.repository.UserRepository;
import com.cafebabe.security.ERole;
import com.cafebabe.security.RegistrationRequest;
import com.cafebabe.security.Role;
import com.cafebabe.security.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected RoleRepository roleRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User create(RegistrationRequest registrationRequest) {
        Role role = roleRepository.findByName(ERole.USER.getName()).get();
        User user = new User(registrationRequest.getEmail(), registrationRequest.getName(), registrationRequest.getSurname(), passwordEncoder.encode(registrationRequest.getPassword()), Collections.singletonList(role));
        return save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteById(BigInteger id) {
        userRepository.deleteById(id);
    }
}
