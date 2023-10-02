package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @RequestMapping("/admin")
    public String admin(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("allUsr", userList);
        return "all-user";
    }

    //"/addNewUsers"
    @RequestMapping("/addNewUsers")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    //"/saveUser"
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    //"/updateInfo"
    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("usrId") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    //"/deleteUser"
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usrId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}