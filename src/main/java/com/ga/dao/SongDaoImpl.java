package com.ga.dao;

import com.ga.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongDaoImpl implements SongDao {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Song createSong(Song song) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(song);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return song;
    }

    @Override
    public List<Song> listSongs() {
        List<Song> songs = null;
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            songs = session.createQuery("FROM Song").getResultList();
        }finally {
            session.close();
        }
        return songs;
    }
}
