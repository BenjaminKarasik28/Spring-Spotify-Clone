package com.ga.Service;

import com.ga.dao.SongDao;
import com.ga.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongDao songDao;


    @Override
    public Song createSong(Song song) {
        return songDao.createSong(song);
    }

    @Override
    public List<Song> songList() {
        return songDao.listSongs();
    }
}
