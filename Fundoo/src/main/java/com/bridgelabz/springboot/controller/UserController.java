package com.bridgelabz.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springboot.entity.LoginEntity;
import com.bridgelabz.springboot.entity.RegisterEntity;
import com.bridgelabz.springboot.entity.UpdatePasswordEntity;
import com.bridgelabz.springboot.model.User;
import com.bridgelabz.springboot.response.Response;
import com.bridgelabz.springboot.service.UserService;
import com.bridgelabz.springboot.utils.JWTTokenLibrary;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTTokenLibrary jwt;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody RegisterEntity entity){
		boolean status = userService.register(entity);
		if(status)
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response("New User Added Successfully", 201));
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new Response("User Details Already Exsists", 208));
	}
	
	@GetMapping("/verification/{token}")
	public ResponseEntity<Response> verification(@PathVariable("token") String token){
		if(userService.isUserVerified(token))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("verification of user done successfully", 202));
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new Response("user verification failed", 406));	
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginEntity entity){
		User user = userService.login(entity);
		if(user != null) {
			String newToken = jwt.newToken(user.getUserId());
			return ResponseEntity.status(HttpStatus.OK).header("token", newToken).body(new Response("Login Successfull", 200));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Invalid Login may the user does not exsists ", 400));
	}
	
	@PostMapping("/resetpassword")
	public ResponseEntity<Response> resetPassword(@RequestParam("emailId") String emailId){
		boolean status = userService.doesUserExsists(emailId);
		if(status)
			return ResponseEntity.status(HttpStatus.FOUND).body(new Response("find the reset link in the mail", 302));
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Response("unauthorised user", 401));
	}
	
	@PutMapping("/resetpassword/{token}")
	public ResponseEntity<Response> updatePassword(@PathVariable("token") String token, @RequestBody UpdatePasswordEntity entity){
		if(userService.updatePassword(entity, token)) {
			return ResponseEntity.status(HttpStatus.OK).body(new Response("Successfully Resetted password", 200));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Failed to reset password", 400));
	}
	
	@GetMapping("/fetch/users")
	public ResponseEntity<Response> getUsers(){
		List<User> users = userService.fetchUsers();
		return ResponseEntity.status(HttpStatus.OK).body(new Response("All Users Fetched Successfullt", 200, users));
	}
	
}
