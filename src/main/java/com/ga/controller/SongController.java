package com.ga.controller;

import com.ga.Service.SongService;
import com.ga.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {

@Autowired
SongService songService;

@PostMapping
public Song createSong(@RequestBody Song song)
{
    return songService.createSong(song);
}

@GetMapping("/list")
    public Iterable<Song> listSong()
{
    return songService.songList();
}
}
