package com.ga.Service;

import java.util.List;

import com.ga.entity.Song;

public class SongServiceStub implements SongService{

	@Override
	public Song createSong(Song newSong) {
		Song song = new Song();
		song.setTitle("DayDreaming");
		return song;
	}

	@Override
	public List<Song> songList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
