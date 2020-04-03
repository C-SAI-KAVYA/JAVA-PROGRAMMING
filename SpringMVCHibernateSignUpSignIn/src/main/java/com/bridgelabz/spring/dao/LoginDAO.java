package com.bridgelabz.spring.dao;

import com.bridgelabz.spring.dto.RegisterDTO;

public interface LoginDAO {

	public RegisterDTO fetchByEmailAndPassword(String mail,String pwd);
}