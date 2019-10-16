package com.ga.Service;

import com.ga.entity.User;



public interface UserService {

    public User signup(User user);
    public Long login(User user);


}