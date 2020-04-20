package com.nemezis.users.controllers;

import com.nemezis.users.entity.User;
import com.nemezis.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Главный контроллер
 */
@RestController
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAlUsersl();
    }

    @PutMapping("/users")
    public void save(@RequestBody User user) {
        userService.save(user);
    }
}