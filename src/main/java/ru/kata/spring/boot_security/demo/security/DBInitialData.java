package ru.kata.spring.boot_security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DBInitialData {

    private UserService userService;
    @Autowired
    public DBInitialData(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void setData() {
        userService.setInitData();
    }
}
