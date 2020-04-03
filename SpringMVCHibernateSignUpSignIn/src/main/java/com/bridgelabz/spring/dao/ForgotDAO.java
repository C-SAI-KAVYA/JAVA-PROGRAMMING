package com.bridgelabz.spring.dao;

import javax.servlet.http.HttpServletRequest;

public interface ForgotDAO {
	
	public boolean resetByEmail(HttpServletRequest request, String email,String pwd);
	//public RegisterEntity updatePasswordByEmail(String pwd, String mail);
}