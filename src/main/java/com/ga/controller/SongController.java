package com.ga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga.Service.SongService;
import com.ga.entity.Song;

@RestController
@RequestMapping("/song")
public class SongController {


	@PostMapping
	public Song createSong(@RequestBody Song song) {
		return songService.createSong(song);
	}

	@GetMapping("/list")
	public Iterable<Song> listSong() {
		return songService.songList();
	}
	
	private SongService songService;
	public List songList;
	
	@Autowired
	public void setSongService(SongService songService) {
		this.songService=songService;
	}

}
