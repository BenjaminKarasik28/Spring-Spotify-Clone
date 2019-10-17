package com.ga.dao;

import com.ga.entity.Song;

import java.util.List;

public interface SongDao{

    public Song createSong(Song song);
    public List<Song> listSongs();
}
