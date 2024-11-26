package com.JUnitTestCase;


public class StudentRegistrationService {
	public boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z\\s]+") && name.length() > 2;
    }
 
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
 
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8; // Example criteria
    }
 
    public String registerStudent(String name, String email, String password) {
        if (!isValidName(name)) {
            return "Invalid name";
        }
        if (!isValidEmail(email)) {
            return "Invalid email format";
        }
        if (!isValidPassword(password)) {
            return "Password must be at least 8 characters long";
        }
        // Simulate successful registration
        return "Registration successful";
    }
	
 
}
