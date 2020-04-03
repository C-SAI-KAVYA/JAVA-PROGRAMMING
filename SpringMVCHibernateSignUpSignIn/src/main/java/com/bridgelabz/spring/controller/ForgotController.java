package com.bridgelabz.spring.controller;

	import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.bridgelabz.spring.dto.ForgotDTO;
	import com.bridgelabz.spring.service.ForgotService;

	@Component
	@RequestMapping
	public class ForgotController {
		private static Logger logger = Logger.getLogger(ForgotController.class);

		@Autowired
		private ForgotService service;

		public ForgotController() {
			logger.info(this.getClass().getSimpleName() + " obj created!");
		}

		@SuppressWarnings("unused")
		@RequestMapping("/forgot.do")
		public String onForgot(HttpServletRequest request, ForgotDTO dto, ModelMap map) {
			logger.info("info message -->  inside getMessage()....");
			logger.warn("warn message -->  inside getMessage()....");
			logger.error("error message -->  inside getMessage()....");
			dto.setEmail(request.getParameter("email"));
			dto.setPassword(request.getParameter("password"));
			
			try {
				boolean valid = this.service.resetPassword(request, dto);
				if (valid) {
					ModelMap success = map.addAttribute("email", dto.getEmail());
					ModelMap success1 = map.addAttribute("password", dto.getPassword());
					ModelMap success2 = map.addAttribute("confirmPassword", dto.getConfirmPassword());
					return "succesfullreset";
				} else {
					ModelMap failure = map.addAttribute("failureMessage", "forgotPassword unsuccessfull");
					return "forgot";
				}
			} catch(NumberFormatException e) {
				logger.error("--Exception occured--", e);
				return null;
			}
		}
	}
