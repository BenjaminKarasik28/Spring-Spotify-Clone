package com.ga.Service;

import java.util.List;

import com.ga.config.JwtUtil;
import com.ga.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ga.dao.UserDao;
import com.ga.entity.User;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String signup(User user) {
        if(userDao.signup(user) != null) {
            UserDetails userDetails = loadUserByUsername(user.getUsername());

            return jwtUtil.generateToken(userDetails);
        }

        return null;
    }


    @Override
    public String login(User user) {
        if(userDao.login(user) != null) {
            UserDetails userDetails = loadUserByUsername(user.getUsername());

            return jwtUtil.generateToken(userDetails);
        }

        return null;
    }


    @Override
    public User addSong(String username, int songId) {
        return userDao.addSong(username, songId);
    }

    @Override
    public User deleteSong(String username, int songid) {
        return userDao.deleteSong(username,songid);
    }

    @Override
    public List<Song> getSongs(int user_id) {
        return userDao.getSongs(user_id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}