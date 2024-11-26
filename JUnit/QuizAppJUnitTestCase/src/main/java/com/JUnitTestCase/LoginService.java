package com.JUnitTestCase;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
	private Map<String, String> userDatabase = new HashMap<>(); // Stores email-password pairs
	 
    public LoginService() {
        // Sample user data
        userDatabase.put("user@example.com", "password123");
    }
 
    // Method to validate login
    public boolean login(String email, String password) {
        if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
            return true;
        }
        return false;
    }
 
    // Method to handle forgotten password
    public String forgotPassword(String email) {
        if (userDatabase.containsKey(email)) {
            return "Password reset link sent to " + email;
        } else {
            return "Email not found";
        }
    }

}
