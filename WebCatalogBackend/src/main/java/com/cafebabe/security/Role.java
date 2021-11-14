package com.cafebabe.security;

import com.cafebabe.entity.BaseDataObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseDataObject {
    public static final String USER_ROLE_NAME = "USER", APP_ADMIN_ROLE_NAME = "APP_ADMIN", SHOP_ADMIN_ROLE_NAME = "SHOP_ADMIN";

    @Column(nullable = false, unique = true)
    protected String name;

    public ERole getRoleEnum() {
        return ERole.getRoleByName(name);
    }

    public Role(String name) {
        this.name = name;
    }
}
