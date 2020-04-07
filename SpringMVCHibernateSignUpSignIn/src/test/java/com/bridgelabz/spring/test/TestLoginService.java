package com.bridgelabz.spring.test;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.bridgelabz.spring.dao.ForgotDAOImpl;
import com.bridgelabz.spring.dao.LoginDAO;
import com.bridgelabz.spring.dto.LoginDTO;
import com.bridgelabz.spring.dto.RegisterDTO;

public class TestLoginService {
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);
	
	LoginDAO dao;
	
	public boolean validateLogin(LoginDTO dto) {
		boolean valid = false;
		try {
			logger.info("invoked login....");			
			  if (Objects.nonNull(dto)) { 
			  logger.info("starting validation for " + dto);
			   String Email = dto.getEmail(); 
			   if (Email != null && !Email.isEmpty() && Email.length() >= 10) { 
				   logger.info("Email is valid"); 
				   valid = true; 
				   } else
			  { 
				  logger.info("Email is invalid"); 
				  valid = false;
				} 
			  }
			  String Password = dto.getPassword();
			  if (valid && Password != null &&  !Password.isEmpty() && Password.length() >= 6) { 
			  logger.info("Password is valid"); 
			  valid = true; 			  } else {
			  logger.info("Password is invalid"); 
			  valid = false; 
			  }  
			  if (valid)
			  
			 logger.info("Data is valid ,will convert  to entity");

		
			RegisterDTO regEntity1 = dao.fetchByEmailAndPassword(dto.getEmail(), dto.getPassword());

			if (regEntity1 != null) {
				logger.info("Entity is ready \t" + regEntity1);
				// dao.save(regEntity);
				// System.out.println("Entity is saved");
				dao.fetchByEmailAndPassword(dto.getEmail(), dto.getPassword());
			logger.info("user details exists");
				return true;
			} else {
				logger.info("user not exist");
			}
			 return false;
			  
		} catch(NumberFormatException e) {
			logger.info("INFO:" + e.getMessage());
			}
		return valid;
	}
}
