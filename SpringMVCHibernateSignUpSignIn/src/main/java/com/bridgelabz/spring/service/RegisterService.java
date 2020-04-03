package com.bridgelabz.spring.service;

import com.bridgelabz.spring.dto.RegisterDTO;

public interface RegisterService {

	public boolean validateAndSave(RegisterDTO dto);

}
