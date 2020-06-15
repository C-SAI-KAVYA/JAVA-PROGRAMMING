package com.bridgelabz.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.sprinboot.exceptions.AlreadyExsistingUserException;
import com.bridgelabz.sprinboot.exceptions.InvalidUserCredentialsException;
import com.bridgelabz.sprinboot.exceptions.UserAuthenticationException;
import com.bridgelabz.sprinboot.exceptions.UserNotFoundException;
import com.bridgelabz.sprinboot.exceptions.VerifyingUserException;
import com.bridgelabz.springboot.entity.LoginEntity;
import com.bridgelabz.springboot.entity.RegisterEntity;
import com.bridgelabz.springboot.entity.UpdatePasswordEntity;
import com.bridgelabz.springboot.model.Mail;
import com.bridgelabz.springboot.model.User;
import com.bridgelabz.springboot.repository.UserRepositoryImpl;
import com.bridgelabz.springboot.utils.DateLibrary;
import com.bridgelabz.springboot.utils.JWTTokenLibrary;
import com.bridgelabz.springboot.utils.RabbitMQSender;

@Service
@Transactional
public class UserServiceProvider implements UserService{
	
	@Autowired
	private UserRepositoryImpl userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bpe;
	
	@Autowired
	private JWTTokenLibrary jwt;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@Autowired
	private DateLibrary currentDateTime;
	
	private String verifyingLink;
	
	private final String SUBJECT = "Verifying fundoo notes for testing RabbitMQ Mail sending Mechanism";
	
	@Override
	public boolean register(RegisterEntity entity) {
		User user = userRepo.fetchUser(entity.getEmailId());
		
		Optional.ofNullable(user).ifPresent(user1 ->{
			throw new AlreadyExsistingUserException("User Already Exsists");
		});
		
		User user1 = new User();
		BeanUtils.copyProperties(entity, user1);
		user.setPassword(bpe.encode(entity.getPassword()));
		user.setCreatedDateTime(currentDateTime.presentDate());
		user.setUpdatedDateTime(currentDateTime.presentDate());
		userRepo.addUser(user1);
		verifyingLink = "http://localhost:8282/user1/verification" + jwt.newToken(user.getUserId());
		mail.setRecepient(entity.getEmailId());
		mail.setSentDate(currentDateTime.getdate());
		mail.setSubject(SUBJECT);
		mail.setContent("Please Click on the below link to verify \n "+ verifyingLink);
		rabbitMQSender.sendMail(mail);
		return true;
	}
	
	@Override
	public User login(LoginEntity entity) {
		User retrievedUser = userRepo.fetchUser(entity.getEmailId());
		Optional.ofNullable(retrievedUser).orElseThrow(() -> new UserNotFoundException("User Not Found"));
		
		Optional.of(retrievedUser)
			.filter(user -> !bpe.matches(entity.getPassword(), user.getPassword()))
			.ifPresent(user -> {
				throw new InvalidUserCredentialsException("Please check with the user credentials");
			});
		
		Optional.of(retrievedUser)
			.filter(user -> bpe.matches(entity.getPassword(), user.getPassword()))
			.ifPresent(user -> {
				throw new InvalidUserCredentialsException("Check with the user credentials");
			});
		Optional.of(retrievedUser)
			.filter(userA -> bpe.matches(entity.getPassword(), retrievedUser.getPassword()))
			.filter(userA -> !retrievedUser.isVerified()).filter(userA -> !retrievedUser.isVerified()).ifPresent(user -> {
				verifyingLink = "http://localhost:8282/user/verification/" + jwt.newToken(user.getUserId());
				
				mail.setRecepient(entity.getEmailId());
				mail.setSentDate(currentDateTime.getdate());
				mail.setSubject(SUBJECT);
				mail.setContent("Click on the below link to verify "+verifyingLink);
				rabbitMQSender.sendMail(mail);
				throw new VerifyingUserException("Verifying the login credentials");
			});
		return Optional.of(retrievedUser)
				.filter(userA -> bpe.matches(entity.getPassword(), retrievedUser.getPassword()))
				.filter(userA -> retrievedUser.isVerified()).get();
	}
	
	@Override
	public boolean isUserVerified(String token) {
		Long userVerificationId = jwt.tokenDecoder(token);
		Optional.of(userVerificationId).filter(id -> id <= 0).ifPresent(id -> {
			throw new UserAuthenticationException("Unauthorised User please try with valid credentials");
		});
		return userRepo.verifyUser(userVerificationId);	
	}
	
	@Override
	public boolean doesUserExsists(String emailId) {
		User user = userRepo.fetchUser(emailId);
		Optional.ofNullable(user).orElseThrow(() -> new UserNotFoundException("User Not Found please enter registered email ID"));
		Optional.of(user).filter(userA -> userA.isVerified()).ifPresent(userA -> {
			String passwordResetLink = "http://localhost:8080/user/resetpassword/" + jwt.newToken(user.getUserId());
			mail.setRecepient(userA.getEmailId());
			mail.setSentDate(currentDateTime.getdate());
			mail.setSubject("reset password link from springboot using rabbit mq and JWT");
			mail.setContent("please click on the belo link to reset your password "+passwordResetLink);
			rabbitMQSender.sendMail(mail);
		});
		
		Optional.of(user).filter(userA -> !userA.isVerified()).ifPresent(userA -> {
			verifyingLink = "http://localhost:8282/user/verification/" + jwt.newToken(user.getUserId());
			mail.setRecepient(userA.getEmailId());
			mail.setSentDate(currentDateTime.getdate());
			mail.setSubject("SUBJECT");
			mail.setContent(verifyingLink);
			rabbitMQSender.sendMail(mail);
			});
		return true;
	}
	
	@Override
	public boolean updatePassword(UpdatePasswordEntity entity, String token) {
		Long userId = jwt.tokenDecoder(token);
		Optional.of(userId).filter(id -> id <= 0).ifPresent(id -> {
			throw new UserAuthenticationException("UnAuthorised User Please Check With the User Credentials");
		});
		String newPassword = bpe.encode(entity.getPassword());
		return userRepo.updatePassword(userId, newPassword);
	}
	
	@Override
	public List<User> fetchUsers(){
		return userRepo.getUsers();
	}
}
