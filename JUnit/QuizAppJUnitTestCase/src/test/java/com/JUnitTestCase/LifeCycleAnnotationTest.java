package com.JUnitTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //class instance will be created at once. (Now without static, BeforeAll and afterAll should run)

public class LifeCycleAnnotationTest {
	
LifeCycleAnnotation m;  //reference variable of 	LifeCycleAnnotation
	
	@BeforeAll                    //Note : BrforeAll and AfterAll methods we need to make them static as they can run before an instance created.
	static void beforeAllinit() { //you can run a static method before instance created
		System.out.println("Inside BeforeAllinit method - run before all methods ");
		
	}
	
	@AfterAll
	static void afterAllOver() {
		System.out.println("Inside AfetrAllOver method - run at last");
	}
	
	
	@BeforeEach          //we want init method to run before each method
	void init() {
		
	m = new LifeCycleAnnotation();
		
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleanup now...!");
	}
	
	@Test
	void testsquare() {
		
		//LifeCycleAnnotation m = new LifeCycleAnnotation(); //As we need to take an instance from init method that's why @BeforeEach annotation mentioned
		int expected = 25;
		int actual = m.square(5);
		assertEquals(expected, actual, "Pass");	
		
	}
	
	@Test
	void testscube() {
		int expected = 125;
		int actual = m.cube(5);
		assertEquals(expected, actual, "Pass");
		
	}
	
	@Nested
	class PositiveNumbers{
		
		@Test
		void testPositiveNo() {
			assertEquals(2, m.positive(2, 2), "Should return positive number");
		}
		
		@Test
		void testNegativeNo() {
			//assertEquals(-2, m.positive(-2, -2), "Should return negative number");
			int expected = -2;
			int actual = m.positive(-2, -2);
			assertEquals(expected, actual, ()-> "should return a -ve value" + expected + "but returned a +ve value");
			//Here this lambda fuction will execute only when the assertion fails.
		}
		
		
	}

}
