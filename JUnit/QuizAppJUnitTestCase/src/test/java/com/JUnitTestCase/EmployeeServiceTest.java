package com.JUnitTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {

	private EmployeeService employeeService;
	
	@BeforeEach
	public void setup() {
		employeeService = new EmployeeService();
	}
	
	//Test registering a valid employee
	@Test
	void testRegisterValidEmployee() {
		Employee employee = new Employee("John","Doe","john.doe@example.com","1234567890","Manager");
		assertTrue(employeeService.registerEmployee(employee),"Employee shoule be registered successfully");
	}
	
	//Test registering a employee with an invalid email format
	@Test
	void testRegisterValidEmployeewithInvalidEmail() {
		Employee employee = new Employee("Jane","Doe","invalid-email","1234567890","Developer");
		Exception exception=assertThrows(IllegalArgumentException.class,
				() -> {employeeService.registerEmployee(employee);
				});
		assertEquals("Invalid email or phone format",exception.getMessage());
	}
	
	//Test registering a employee with an invalid phone format
	@Test
	void testRegisterValidEmployeewithInvalidPhone() {
		Employee employee = new Employee("Alice","Smith","alice.smith@example.com","12345","Designer");
		Exception exception=assertThrows(IllegalArgumentException.class,
				() -> {employeeService.registerEmployee(employee);
				});
		assertEquals("Invalid email or phone format",exception.getMessage());
	}

	//Test registering a employee with a duplicate email
	@Test
	void testRegisterDuplicateEmail() {
		Employee firstEmployee = new Employee("John","Doe","john.duplicate@example.com","1234567890","Manager");
		Employee duplicateEmployee = new Employee("Jane","Smith","john.duplicate@example.com","0987654321","Developer");
		employeeService.registerEmployee(firstEmployee);
		
		Exception exception=assertThrows(IllegalArgumentException.class,
				() -> {employeeService.registerEmployee(duplicateEmployee);
				});
		assertEquals("Employee with this email or phone already exists",exception.getMessage());
	}
	
	//Test registering a employee with a duplicate phone number
	@Test
	void testRegisterDuplicatePhone() {
		Employee firstEmployee = new Employee("John","Doe","john.duplicate@example.com","1234567890","Manager");
		Employee duplicateEmployee = new Employee("Jane","Smith","john.duplicate@example.com","1234567890","Developer");
		employeeService.registerEmployee(firstEmployee);
		
		Exception exception=assertThrows(IllegalArgumentException.class,
				() -> {employeeService.registerEmployee(duplicateEmployee);
				});
		assertEquals("Employee with this email or phone already exists",exception.getMessage());
	}
	

}
