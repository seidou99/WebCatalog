package com.cafebabe.security;

import java.util.Arrays;

import static com.cafebabe.security.Role.*;

public enum ERole {

    USER(USER_ROLE_NAME), APP_ADMIN(APP_ADMIN_ROLE_NAME), SHOP_ADMIN(SHOP_ADMIN_ROLE_NAME);

    private final String name;

    ERole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ERole getRoleByName(String name) {
        return Arrays.stream(values()).filter(v -> v.name.equals(name)).findFirst().get();
    }
}
