package com.JUnitTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRegistrationServiceTest {

	private StudentRegistrationService registrationService;
	
	@BeforeEach
	public void setup() {
		registrationService = new StudentRegistrationService();
	}
	
	//Test Valid Name
	@Test
	public void testValidName() {
		assertTrue(registrationService.isValidName("John Due"),"Name should be valid");
		assertTrue(registrationService.isValidName("Alice"),"Name should be valid");
	}
	
	//Test InValid Name
	@Test	
	public void testInValidName() {
		assertFalse(registrationService.isValidName(""),"Empty Name should be invalid");
		assertFalse(registrationService.isValidName("J"),"Name shorter than 2 characters should be invalid");
		assertFalse(registrationService.isValidName("1234"),"Name with numbers should be invalid");
		assertFalse(registrationService.isValidName(null),"Null Name should be invalid");
	}
		
	//Test Valid Email
	@Test
	public void testValidEmail() {
		assertTrue(registrationService.isValidEmail("test@example.com"),"Email should be valid");
		assertTrue(registrationService.isValidEmail("user.name@domain.co"),"Email should be valid");
	}
	

	
	//Test InValid Email
	@Test	
	public void testInValidEmail() {
		assertFalse(registrationService.isValidEmail("invalid-email"),"Email without '@' or '.' should be invalid");
		assertFalse(registrationService.isValidEmail("user@domain"),"Email without top-level domain should be invalid");
		assertFalse(registrationService.isValidEmail(""),"Empty Email should be invalid");
		assertFalse(registrationService.isValidEmail(null),"Null Emailk should be invalid");
	}
	
	//Test Valid Password
	@Test
	public void testValidPassword() {
		assertTrue(registrationService.isValidPassword("password123"),"Password shorter than 8 characters should be valid");
		assertTrue(registrationService.isValidPassword("Admin@1234"),"Password with special characters should be valid");
	}
	
	//Test InValid Password
		@Test	
	public void testInValidPassword() {
		assertFalse(registrationService.isValidPassword("pass"),"Password shorter than 8 characters should be invalid");
		assertFalse(registrationService.isValidPassword(""),"Empty Password should be invalid");
		assertFalse(registrationService.isValidPassword(null),"Null password should be invalid");
	}
		
	
	//Test Successful Registration
		@Test	
		public void testSuccessfullRegistration() {
			String result = registrationService.registerStudent("John Doe","johndoe@example.com","SecurePass123");
			assertEquals("Registration successful",result,"Registration should be successful with valid data");
			
		}
	
		//Test Registration with Invalid Name
		@Test	
		public void testRegistrationInvalidname() {
			String result = registrationService.registerStudent("J","johndoe@example.com","SecurePass123");
			assertEquals("Invalid name",result,"Registration should be fail if name is invalid");
			
		}
		
	
		//Test Registration with InValid Email
		@Test	
		public void testRegistrationInvalidEmail() {
			String result = registrationService.registerStudent("John Doe","invalid-email","SecurePass123");
			assertEquals("Invalid email format",result,"Registration should be fail if email is invalid");
			
		}
		
		
		
		//Test Registration with Invalid Password
		@Test	
		public void testRegistrationInvalidpassword() {
			String result = registrationService.registerStudent("John Doe","johndoe@example.com","short");
			assertEquals("Password must be at least 8 characters long",result,"Registration should be fail if password is invalid");
			
		}
	
	
	
	
	
			
}
