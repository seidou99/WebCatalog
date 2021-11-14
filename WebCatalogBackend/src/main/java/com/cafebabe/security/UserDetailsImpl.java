package com.cafebabe.security;

import com.cafebabe.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    protected BigInteger id;

    protected String email;

    protected String name;

    protected String surname;

    @JsonIgnore
    protected String password;

    protected List<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(BigInteger id, String email, String password, List<? extends GrantedAuthority> authorities, String name, String surname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.name = name;
        this.surname = surname;
    }

    public UserDetailsImpl(User user) {
        this(user.getId(), user.getEmail(), user.getPasswordHash(), null, user.getName(), user.getSurname());
        authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name)).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public BigInteger getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return Objects.equals(id, that.id);
    }
}
