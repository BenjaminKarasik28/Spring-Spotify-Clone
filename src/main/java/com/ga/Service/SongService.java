package com.ga.Service;

import com.ga.entity.Song;

import java.util.List;

public interface SongService {

    public Song createSong(Song song);
    public List<Song> songList();
}
