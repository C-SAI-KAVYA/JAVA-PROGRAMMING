package com.bridgelabz.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.spring.dto.LoginDTO;

public interface LoginService {

	public boolean validateLogin(HttpServletRequest request, LoginDTO dto);
}
