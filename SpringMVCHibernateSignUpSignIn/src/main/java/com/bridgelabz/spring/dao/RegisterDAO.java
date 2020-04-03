package com.bridgelabz.spring.dao;

import java.io.Serializable;

import com.bridgelabz.spring.dto.RegisterDTO;

public interface RegisterDAO {

	public Serializable save(RegisterDTO entity);

	public RegisterDTO fetchByEmail(String email);

}
