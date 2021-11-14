package com.cafebabe.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    protected String email;
    protected String password;
    protected String name;
    protected String surname;

    public RegistrationRequest(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
