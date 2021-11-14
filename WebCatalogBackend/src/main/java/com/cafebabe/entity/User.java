package com.cafebabe.entity;

import com.cafebabe.entity.BaseDataObject;
import com.cafebabe.security.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseDataObject {

    @Column(unique = true, nullable = false)
    protected String email;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String surname;

    @Column(nullable = false)
    protected String passwordHash;

    @ManyToMany
    List<Role> roles = new ArrayList<>();

    public User(String email, String name, String surname, String passwordHash, List<Role> roles) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }
}
