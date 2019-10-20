package com.ga.Service;

import com.ga.entity.Song;
import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    public String signup(User user);
    public String login(User user);
    public User addSong(String username, int songId);
    public User deleteSong(String username, int songid);
    public List<Song> getSongs(int user_id);


}