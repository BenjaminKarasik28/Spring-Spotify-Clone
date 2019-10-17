package com.ga.dao;

import com.ga.entity.Song;
import com.ga.entity.User;

import java.util.List;

public interface UserDao {
	public User signup(User user);
	public User login(User user);
	public User getUserByUsername(String username);
	public User addSong(String title, int songid);
	public User deleteSong(String username, int songid);
	public List<Song> getSongs(int user_id);
}
