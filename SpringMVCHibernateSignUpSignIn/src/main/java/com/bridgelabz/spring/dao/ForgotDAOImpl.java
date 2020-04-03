package com.bridgelabz.spring.dao;


import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForgotDAOImpl implements ForgotDAO {
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public ForgotDAOImpl() {
		logger.info(this.getClass().getSimpleName() + " obj created!");
	}

	public boolean resetByEmail(HttpServletRequest request, String email, String pwd) {
		logger.info("Invoked fetchByName() ....");
		Session session = null;
		logger.info("Invoking save method");
		logger.info("info message -->  inside getMessage()....");
		logger.warn("warn message -->  inside getMessage()....");
		logger.error("error message -->  inside getMessage()....");
		
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			// session.getTransaction();
			logger.info("fetching...");
			String hql = "UPDATE RegisterDTO re SET re.password = '"+pwd+"' WHERE re.email = '"+email+"'";
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			tx.commit();
			if (Objects.nonNull(result)) {
				logger.info("Entity found" + result);
				return true;
			} else {
				logger.info("Entity not found");
				return false;
			}

		}catch(NumberFormatException e) {
			logger.info("INFO:" + e.getMessage());	
			logger.info("INFO:" + e.getMessage());
			return false;
		} finally {
			session.close();
		}
	}
}

/*
 * public RegisterEntity updatePasswordByEmail(String pwd, String mail) {
 * Session session = factory.openSession(); try {
 * System.out.println("invoke program...");
 * 
 * Query query = session.getNamedQuery("updatePasswordByEmail");
 * 
 * query.setParameter("password", pwd); query.setParameter("email", mail);
 * 
 * Object result = query.executeUpdate(); if (Objects.nonNull(result)) {
 * System.out.println("Entity found");
 * 
 * } else { System.out.println("Entity not found"); }
 * 
 * } catch (HibernateException he) { he.printStackTrace(); } finally { if
 * (Objects.nonNull(session)) session.close(); } return null; } }
 */
