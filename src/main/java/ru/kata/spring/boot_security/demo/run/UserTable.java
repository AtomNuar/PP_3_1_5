package ru.kata.spring.boot_security.demo.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserTable implements ApplicationRunner {

    private final UserServiceImpl userServiceIml;
    private final Set<Role> roles;
    private final Set<Role> userRoles;

    @Autowired
    public UserTable(UserServiceImpl userServiceIml, Set<Role> roles) {
        this.userServiceIml = userServiceIml;
        this.roles = roles;
        this.userRoles = new HashSet<>();
    }

    @Override
    public void run(ApplicationArguments args) {

        Role roleUser = new Role("ROLE_USER");

        userRoles.add(roleUser);

        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        roles.add(adminRole);
        roles.add(userRole);

        User user = new User(1L, "user", "userov", (byte) 20,
                "{noop}user", userRoles);
        User admin = new User(2L, "admin", "adminov", (byte) 35,
                "{noop}admin", roles);

        userServiceIml.saveUser(user);
        userServiceIml.saveUser(admin);

        System.out.println("В таблицу успешно добавлены пользователь и администратор");
    }
}
