package com.bridgelabz.spring.test;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import com.bridgelabz.spring.dao.RegisterDAO;
import com.bridgelabz.spring.dao.RegisterDAOImpl;
import com.bridgelabz.spring.dto.RegisterDTO;

public class TestRegisterService{
	private static Logger logger = Logger.getLogger(TestRegisterService.class);
	RegisterDAO dao = new RegisterDAOImpl();
	
	public int validateAndSave(RegisterDTO dto) {
		
		int valid = 0;
		try {
			logger.info("save invoked....");

			if (Objects.nonNull(dto)) {
				logger.info("starting validation for " + dto);
				String Username = dto.getUserName();

				if (Username != null && !Username.isEmpty() && Username.length() >= 5) {
					logger.info("Username is valid");
					valid = 1;
				} else {
					logger.info("Username is invalid");
					if (Username == null) {
						logger.info("Username is null");
					}
					if (Username != null && Username.length() < 5) {
						logger.info("name length is less than 5");
					}
					valid = 0;
				}

				String Email = dto.getEmail();

				if (valid == 1 && Email != null && !Email.isEmpty() && Email.length() >= 10) {
					logger.info("Email is valid");
					valid = 1;
				} else {
					logger.info("Email is invalid");
					valid = 0;
				}

				String Password = dto.getPassword();

				if (valid == 1 && Password != null && !Password.isEmpty() && Password.length() >= 6) {
					logger.info("Password is valid");
					valid = 1;
				} else {

					logger.info("Password is invalid");
					valid = 0;

				}

				String ConfirmPassword = dto.getConfirmPassword();
				if (valid == 1 && ConfirmPassword != null && !ConfirmPassword.isEmpty() && ConfirmPassword.length() >= 6) {
					logger.info("ConfirmPassword is valid");
					valid = 1;
				} else {
					logger.info("ConfirmPassword is invalid becuase its not same");
					valid = 0;
				}
			}
//check pwd and confirm pwd
			if (valid == 1) {
				logger.info("Data is valid ,will convert  to entity");

				RegisterDTO regEntity = new RegisterDTO();
				BeanUtils.copyProperties(dto, regEntity);

				// System.out.println("entity is ready \t " + regEntity);
				// dao.save(regEntity);

				RegisterDTO regEntity1 = dao.fetchByEmail(dto.getEmail());
				RegisterDTO regEntity2 = dao.fetchByEmail(dto.getUserName());
				if (regEntity2 == null && regEntity1 == null) {
					logger.info("Entity is ready \t" + regEntity);
					dao.save(regEntity);
					logger.info("Entity is saved");
				} else {
					logger.info("DATA NOT VALID ,NOT SAVED IN DATABASE");
				}
				return valid;
			}
		} catch (NumberFormatException e) {
			logger.info("INFO:" + e.getMessage());
		}
		return valid;
	}	
}
