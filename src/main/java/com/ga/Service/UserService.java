package com.ga.Service;

import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {

    public String signup(User user);
    public String login(User user);


}