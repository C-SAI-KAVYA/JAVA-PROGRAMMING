package com.bridgelabz.springboot.service;

import java.util.List;

import com.bridgelabz.springboot.entity.LoginEntity;
import com.bridgelabz.springboot.entity.RegisterEntity;
import com.bridgelabz.springboot.entity.UpdatePasswordEntity;
import com.bridgelabz.springboot.model.User;

public interface UserService {
	public boolean register(RegisterEntity entity);
	public User login(LoginEntity entity);
	public boolean isUserVerified(String token);
	public boolean doesUserExsists(String emailID);
	public boolean updatePassword(UpdatePasswordEntity entity, String token);
	public List<User> fetchUsers();
}
