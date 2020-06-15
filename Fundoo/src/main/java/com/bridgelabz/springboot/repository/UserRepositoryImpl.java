package com.bridgelabz.springboot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.bridgelabz.springboot.model.User;
import com.bridgelabz.springboot.utils.DateLibrary;


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private DateLibrary date;

	@Override
	public User addUser(User user) {
		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = em.unwrap(Session.class);
		List<User> user = session.createQuery("FROM users").getResultList();
		return user;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User fetchUser(Long id) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("FROM users where userId=:id");
		query.setParameter("id", id);
		return (User)query.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User fetchUser(String emailId) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("FROM users where emailId=:emailId");
		query.setParameter("emailId", emailId);
		return (User) query.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean verifyUser(Long userId) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("UPDATE users set isVerified=:verified"+" WHERE userId=:userId");
		query.setParameter("verified", true);
		query.setParameter("id", userId);
		if(query.executeUpdate() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean updatePassword(Long userId, String newPassword) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("UPDATE users set password=:password, updatedDateTime=:updatedDate where userId=:id");
		query.setParameter("password", newPassword);
		query.setParameter("updatedDate", date.presentDate());
		query.setParameter("id", userId);
		
		if(query.executeUpdate() > 0)
			return true;
		return false;
	}
	
}
