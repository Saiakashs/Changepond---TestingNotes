package com.JUnitTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {
	
	private LoginService loginService;
	 
    @BeforeEach
    public void setUp() {
        loginService = new LoginService();
    }
 
    // Test successful login with valid credentials
    @Test
    void testLoginSuccess() {
        String email = "user@example.com";
        String password = "password123";
        
        assertTrue(loginService.login(email, password), "Login should succeed with correct credentials");
    }
 
    // Test login with an invalid password
    @Test
    void testLoginInvalidPassword() {
        String email = "user@example.com";
        String password = "wrongpassword";
        
        assertFalse(loginService.login(email, password), "Login should fail with an incorrect password");
    }
 
    // Test login with an invalid email
    @Test
    void testLoginInvalidEmail() {
        String email = "invalid@example.com";
        String password = "password123";
        
        assertFalse(loginService.login(email, password), "Login should fail with an unregistered email");
    }
 
    // Test forgot password with a registered email
    @Test
    void testForgotPasswordSuccess() {
        String email = "user@example.com";
        
        String result = loginService.forgotPassword(email);
        assertEquals("Password reset link sent to user@example.com", result, "Forgot password should send reset link to registered email");
    }
 
    // Test forgot password with an unregistered email
    @Test
    void testForgotPasswordInvalidEmail() {
        String email = "unknown@example.com";
        
        String result = loginService.forgotPassword(email);
        assertEquals("Email not found", result, "Forgot password should return 'Email not found' for unregistered email");
    }

}
