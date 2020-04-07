package com.bridgelabz.spring.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bridgelabz.spring.dto.LoginDTO;
import com.bridgelabz.spring.dto.RegisterDTO;
import com.bridgelabz.spring.service.LoginService;
import com.bridgelabz.spring.service.RegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "spring.xml" })
public class RegisterAndLoginTest {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private LoginService loginService;

	@Test
	public void testValidateAndSave() {
		RegisterDTO register = new RegisterDTO();
		register.setEmail("kavya@gmail");
		register.setPassword("cherry143");
		register.setConfirmPassword("cherry143");
		register.setUserName("kavya");
		register.setPhnNum(7975736535l);
		System.out.println("---------registerred successfully---------");

		boolean result = registerService.validateAndSave(register);
		Assert.assertTrue(result);
	}

	@Test
	public void testValidateUser() {
		LoginDTO login = new LoginDTO();
		login.setEmail("kavya@gmail");
		login.setPassword("cherry143");
		System.out.println("---------Login successfull----------");
		Assert.assertTrue(loginService.validateLogin(login));
		System.out.println("Validation done successfully..");
	}
	
	@Test
	public void testRegisterMockito() {
		//Mock created
		TestRegisterService test = Mockito.mock(TestRegisterService.class);
		RegisterDTO dto = new RegisterDTO();
		dto.setUserName("abcd");
		dto.setEmail("abcd@gmail.com");
		dto.setPassword("7975736535");
		dto.setConfirmPassword("7975736535");
		dto.setPhnNum(7975736535l);
		
		Mockito.when(test.validateAndSave(dto)).thenReturn(0);
		Assert.assertEquals(test.validateAndSave(dto), 0);
		//defining return value
	}
	
	@Test
	public void testLoginMockito() {
		//Mock created
		TestLoginService test = Mockito.mock(TestLoginService.class);
		LoginDTO dto = new LoginDTO();
		dto.setEmail("kavya@gmail.com");
		dto.setPassword("cherry143");
		//defining return value
		Mockito.when(test.validateLogin(dto)).thenReturn(true);
		Assert.assertEquals(test.validateLogin(dto), true);
	}
	
	
}