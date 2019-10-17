package com.ga.controller;


import java.util.List;

import com.ga.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga.entity.User;
import com.ga.Service.UserService;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/login")
    public Integer login(@RequestBody User user) {
        return userService.login(user);
    }


    @PutMapping("/{username}/song/{songId}")
    public User addSong(@PathVariable String username, @PathVariable int songId) {
        return userService.addSong(username, songId);
    }

    @GetMapping("/{user_id}")
    public List<Song> getSongs(@PathVariable int user_id)
    {
        return userService.getSongs(user_id);
    }

    @DeleteMapping("/{username}/{songid}")
    public User deleteSong(@PathVariable String username, @PathVariable int songid){
        return userService.deleteSong(username,songid);
    }
}