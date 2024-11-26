package com.JUnitTestCase;

import java.util.HashSet;
import java.util.Set;

public class EmployeeService {
    
	private Set<String> registeredEmails = new HashSet<>();
    private Set<String> registeredPhones = new HashSet<>();
 
    public boolean registerEmployee(Employee employee) {
        if (!isValidEmail(employee.getEmail()) || !isValidPhone(employee.getPhone())) {
            throw new IllegalArgumentException("Invalid email or phone format");
        }
        if (isDuplicate(employee)) {
            throw new IllegalArgumentException("Employee with this email or phone already exists");
        }
        
        // Simulate saving employee
        registeredEmails.add(employee.getEmail());
        registeredPhones.add(employee.getPhone());
        return true;
    }
 
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
 
    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
 
    private boolean isDuplicate(Employee employee) {
        return registeredEmails.contains(employee.getEmail()) || registeredPhones.contains(employee.getPhone());
    }
		

}
