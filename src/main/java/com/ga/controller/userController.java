package com.ga.controller;


import java.util.List;


import com.ga.entity.JwtResponse;
import com.ga.Service.UserService;
import com.ga.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ga.entity.User;
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.signup(user)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
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