package com.bridgelabz.spring.service;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.spring.dao.ForgotDAO;
import com.bridgelabz.spring.dao.ForgotDAOImpl;
import com.bridgelabz.spring.dto.ForgotDTO;
@Service
public class ForgotServiceImpl implements ForgotService {
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);


	@Autowired
	private ForgotDAO dao;

	public ForgotServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public boolean validateForgotPassword(HttpServletRequest request, ForgotDTO dto) {
		dto.setEmail(request.getParameter("email"));
		dto.setPassword(request.getParameter("password"));
		boolean valid = false;
		try {
			logger.info(" invoked validateForgot....");

			if (Objects.nonNull(dto)) {
				logger.info("starting validation for " + dto);

				String Email = dto.getEmail();

				if (Email != null && Email.contains("@") && Email.length() >= 10) {
					logger.info("Email is valid");
					valid = true;
					String Password = dto.getPassword();

					if (valid && Password != null && !Password.isEmpty() && Password.length() >= 6) {
						logger.info("Password is valid");
						valid = true;

						String ConfirmPassword = dto.getConfirmPassword();
						if (valid && ConfirmPassword != null && !ConfirmPassword.isEmpty()
								&& ConfirmPassword.length() >= 6) {
							logger.info("ConfirmPassword is valid");
							valid = true;
						} else {
							logger.info("ConfirmPassword is invalid becuase its not same");
							valid = false;
						}
					} else {

						logger.info("Password is invalid");
						valid = false;
					}
				} else {
					logger.info("Email is invalid");
					valid = false;
				}
			}
			return valid;
		} catch(NumberFormatException e) {
			logger.info("INFO:" + e.getMessage());
			}
		return valid;
	}

	public boolean resetPassword(HttpServletRequest request, ForgotDTO dto) {
		dto.setEmail(request.getParameter("email"));
		dto.setPassword(request.getParameter("password"));
		
		boolean regEntity1 = dao.resetByEmail(request, dto.getEmail(), dto.getPassword());
		if (regEntity1 == true) {
			logger.info("Email Exist" + regEntity1);
		} else {
			logger.info("Email doesnt exist");
		}
		return regEntity1;
	}
}