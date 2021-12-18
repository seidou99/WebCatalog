package com.cafebabe;

import com.cafebabe.entity.User;
import com.cafebabe.security.ERole;
import com.cafebabe.security.RegistrationRequest;
import com.cafebabe.security.Role;
import com.cafebabe.security.RoleRepository;
import com.cafebabe.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@TestComponent
public class RolesTest {

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected UserServiceImpl userService;

    @Test
    public void testCreate() {
        ERole[] roles = ERole.values();
        for (ERole role : roles) {
            if (!roleRepository.findByName(role.getName()).isPresent()) {
                roleRepository.save(new Role(role.getName()));
            }
        }
    }

    @Test
    public void createDefaultAdmin() {
        String email = "test@test.com", password = "password", name = "AdminName", surname = "AdminSurname";
        if (!userService.findByEmail(email).isPresent()) {
            userService.create(new RegistrationRequest(email, password, name, surname));
        }
        User user = userService.findByEmail(email).get();
        Optional<Role> userRoleOptional = roleRepository.findByName(ERole.USER.getName());
        Optional<Role> appAdminRoleOptional = roleRepository.findByName(ERole.APP_ADMIN.getName());
        if (!userRoleOptional.isPresent() || !appAdminRoleOptional.isPresent()) {
            Assertions.fail("user or admin role doesn't exist");
        }
        user.setRoles(Arrays.asList(userRoleOptional.get(), appAdminRoleOptional.get()));
        userService.save(user);
    }

    @Test
    public void createShopAdmin() {
        String email = "shop_admin@test.com", password = "password", name = "ShopAdminName", surname = "ShopAdminSurname";
        if (!userService.findByEmail(email).isPresent()) {
            userService.create(new RegistrationRequest(email, password, name, surname));
        }
        User user = userService.findByEmail(email).get();
        Optional<Role> userRoleOptional = roleRepository.findByName(ERole.USER.getName());
        Optional<Role> shopAdminOptional = roleRepository.findByName(ERole.SHOP_ADMIN.getName());
        if (!userRoleOptional.isPresent() || !shopAdminOptional.isPresent()) {
            Assertions.fail("user or shop_admin role doesn't exist");
        }
        user.setRoles(Arrays.asList(userRoleOptional.get(), shopAdminOptional.get()));
        userService.save(user);
    }
}
