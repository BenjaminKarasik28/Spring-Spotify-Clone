package com.ga.dao;


import com.ga.entity.Song;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ga.entity.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public User signup(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
		return user;
		
	}

	public User login(User user) {
		User savedUser = null;

		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();

			savedUser = (User) session.createQuery("FROM User u WHERE u.username = '" +
					user.getUsername() + "' AND u.password = '" +
					user.getPassword() + "'").getSingleResult();
		} finally {
			session.close();
		}

		return savedUser;
	}
	@Override
	public User getUserByUsername(String username) {
		User user = null;

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			user = (User)session.createQuery("FROM User u WHERE u.username = '" +
					username + "'").uniqueResult();
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public User addSong(String username, int songId) {
		Song song = null;
		User user = null;

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			user = (User)session.createQuery("FROM User u WHERE u.username = '" +
					username + "'").uniqueResult();
			song = session.get(Song.class, songId);

			user.addSong(song);

			session.update(user);

			session.getTransaction().commit();
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public User deleteSong(String username, int songid) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		Song song = null;
		try{
			session.beginTransaction();
			user = (User)session.createQuery("FROM User u WHERE u.username = '" +
					username + "'").uniqueResult();
			song = session.get(Song.class, songid);
			user.getSongs().remove(song);
			session.update(user);
			session.getTransaction().commit();

		}finally {
			session.close();
		}
		return user;	}

	@Override
	public List<Song> getSongs(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		User savedUser = null;
		List<Song> songsByUser = null;
		try{
			session.beginTransaction();
			savedUser = session.get(User.class,user_id);
			songsByUser= savedUser.getSongs();
			Hibernate.initialize(songsByUser);
		}finally {
			session.close();
		}
		return songsByUser;
	}
}

	

