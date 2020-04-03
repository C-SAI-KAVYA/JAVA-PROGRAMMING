package com.bridgelabz.spring.service;
import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.spring.dto.ForgotDTO;

public interface ForgotService {
	
	public boolean validateForgotPassword(HttpServletRequest request, ForgotDTO dto);
	public boolean resetPassword(HttpServletRequest request, ForgotDTO dto);

}
