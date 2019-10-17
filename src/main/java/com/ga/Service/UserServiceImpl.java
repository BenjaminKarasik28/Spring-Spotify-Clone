package com.ga.Service;

import java.util.List;


import com.ga.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ga.dao.UserDao;
import com.ga.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public User signup(User user) {
        return userDao.signup(user);
    }

    @Override
    public Integer login(User user) {
        return userDao.login(user).getUserId();
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