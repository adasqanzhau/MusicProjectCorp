package org.example.controller;

import org.example.service.UserService;
import org.springframework.ui.Model;
import org.example.service.MusicianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/mainpage/users")
    public String allUsers(Model model) {
        var users = userService.getAllUser();
        model.addAttribute("users", users);

        return "AllUsers.html";
    }
}
