package com.ga.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ga.Service.SongServiceStub;
import com.ga.entity.Song;

public class SongControllerTest {
	
	private SongController songController;
	private Song song;
	private List<Song> songList;
	
	@Before
	public void initSongController() {
		songController = new SongController();
		songController.setSongService(new SongServiceStub());
	}

	@Test
	public void createSong_SongSong_Success() {
		Song song = new Song();
		song.setTitle("DayDreaming");
		Song newSong = songController.createSong(song);
		assertNotNull(newSong);
		assertEquals(newSong.getTitle(), song.getTitle());	
	}
	
	@Before 
	public void getSongList() {
		songList = new ArrayList();
		song.setId(1L);
		song.setLength(465);
		song.setTitle("DayDreaming");
		
		songList.add(song);
	}
	
	@Test
	public void getSongList_SongList_Success() {
		
	}
	
}
