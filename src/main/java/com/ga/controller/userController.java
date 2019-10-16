package com.ga.controller;

import com.ga.Service.UserService;
import com.ga.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userservice;


    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userservice.signup(user);
    }

    @PostMapping("/login")
    public Long login(@RequestBody User user) {
        return userservice.login(user);
    }





}
