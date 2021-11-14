package com.cafebabe.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {

    protected String jwt;
    protected BigInteger userId;
    protected String email;
    protected List<String> roles;
    protected String name;
    protected String surname;

    public JwtResponse(String jwt, BigInteger userId, String email, List<String> roles, String name, String surname) {
        this.jwt = jwt;
        this.userId = userId;
        this.email = email;
        this.roles = roles;
        this.name = name;
        this.surname = surname;
    }
}
