package com.bridgelabz.spring.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.spring.dto.LoginDTO;
import com.bridgelabz.spring.service.LoginService;

@Controller
@RequestMapping
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService service;

	public LoginController() {
		logger.info(this.getClass().getSimpleName() + " obj created!");

	}

	@SuppressWarnings("unused")
	@RequestMapping("/login.do")
	public String onLogin(HttpServletRequest request, LoginDTO dto, ModelMap map) {
		logger.info("info message -->  inside getMessage()....");
		logger.warn("warn message -->  inside getMessage()....");
		logger.error("error message -->  inside getMessage()....");
		try {
			logger.info("Invoked onLogin method");
			logger.info(dto);

			boolean check = this.service.validateLogin(request, dto);

			if (check) {
				ModelMap email = map.addAttribute("email", dto.getEmail());
				ModelMap password = map.addAttribute("password", dto.getPassword());
				return "success";
				
			} else {
				ModelMap failure = map.addAttribute("failureMessage", "Login unsuccessfull");
				return "login";
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Info:" + e.getMessage());
			return null;
		}
	}
}