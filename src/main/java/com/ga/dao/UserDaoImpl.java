package com.ga.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ga.entity.User;

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
	
	public User login(User user) { //can you do this without a new user
		User savedUser = null;
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			savedUser = (User)session.createQuery("FROM User u WHERE u.username = '" + 
				user.getUsername() + "' AND u.password = '" + 
				user.getPassword() + "'").getSingleResult();
		} finally {
			session.close();
		}
		
		return savedUser;
	}

	
}
