package ru.kata.spring.boot_security.demo.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DefaultUser {
    @Bean
    CommandLineRunner addDefault(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Set<Role> roles1 = new HashSet<>();
            roles1.add(roleRepository.findById(1L).orElse(null));
            roles1.add(roleRepository.findById(2L).orElse(null));
            Set<Role> roles2 = new HashSet<>();
            roles2.add(roleRepository.findById(2L).orElse(null));
            userRepository.save(new User("Roman", "Shatilov",
                    "admin@mail.ru", passwordEncoder.encode("admin"), roles2));
            userRepository.save(new User("Kristina", "Shatilova",
                    "user@mail.ru", passwordEncoder.encode("user"), roles1));

        };
    }
}