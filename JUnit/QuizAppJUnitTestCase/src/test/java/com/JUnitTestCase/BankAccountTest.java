package com.JUnitTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

	private BankAccount account;
	 
    @BeforeEach
    void setup() {
        // Initialize BankAccount with balance=100, deposit=0, and withdraw=0
        account = new BankAccount(100.0, 0.0, 0.0);
        System.out.println("Setting up a new BankAccount instance with initial balance: " + account.getBalance());
    }
 
    @Test
    @DisplayName("Test initial balance")
    void testInitialBalance() {
        System.out.println("Running test: Test initial balance");
        assertEquals(100.0, account.getBalance(), "Initial balance should be 100");
        System.out.println("Initial balance test passed!");
    }
 
    @Test
    @DisplayName("Test deposit functionality")
    void testDeposit() {
        System.out.println("Running test: Test deposit functionality");
        account.setDeposit(50.0); // Set deposit value
        account.deposit(account.getDeposit()); // Perform deposit
        System.out.println("Deposited 50. New balance: " + account.getBalance());
        assertEquals(150.0, account.getBalance(), "Balance should be 150 after depositing 50");
    }
 
    @Test
    @DisplayName("Test deposit with zero amount")
    void testZeroDeposit() {
        System.out.println("Running test: Test deposit with zero amount");
        account.setDeposit(0.0);
        account.deposit(account.getDeposit());
        System.out.println("Tried depositing 0. Balance remains: " + account.getBalance());
        assertEquals(100.0, account.getBalance(), "Balance should remain 100 after depositing 0");
    }
 
    @Test
    @DisplayName("Test deposit with negative amount")
    void testNegativeDeposit() {
        System.out.println("Running test: Test deposit with negative amount");
        account.setDeposit(-20.0);
        account.deposit(account.getDeposit());
        System.out.println("Tried depositing -20. Balance remains: " + account.getBalance());
        assertEquals(100.0, account.getBalance(), "Balance should remain 100 after depositing a negative amount");
    }
 
    @Test
    @DisplayName("Test withdrawal with sufficient balance")
    void testWithdraw() {
        System.out.println("Running test: Test withdrawal with sufficient balance");
        account.setWithdraw(30.0); // Set withdrawal amount
        account.withdraw(account.getWithdraw()); // Perform withdrawal
        System.out.println("Withdrew 30. New balance: " + account.getBalance());
        assertEquals(70.0, account.getBalance(), "Balance should be 70 after withdrawing 30");
    }
 
    @Test
    @DisplayName("Test withdrawal exceeding balance")
    void testExceedingWithdraw() {
        System.out.println("Running test: Test withdrawal exceeding balance");
        account.setWithdraw(150.0); // Set withdrawal amount greater than balance
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(account.getWithdraw()));
        System.out.println("Attempted to withdraw 150. Caught exception: " + exception.getMessage());
        assertEquals("Insufficient balance", exception.getMessage());
    }
 
    @Test
    @DisplayName("Test withdrawal with zero amount")
    void testZeroWithdraw() {
        System.out.println("Running test: Test withdrawal with zero amount");
        account.setWithdraw(0.0);
        account.withdraw(account.getWithdraw());
        System.out.println("Tried withdrawing 0. Balance remains: " + account.getBalance());
        assertEquals(100.0, account.getBalance(), "Balance should remain 100 after withdrawing 0");
    }
 
    @Test
    @DisplayName("Test withdrawal with negative amount")
    void testNegativeWithdraw() {
        System.out.println("Running test: Test withdrawal with negative amount");
        account.setWithdraw(-10.0);
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(account.getWithdraw()));
        System.out.println("Attempted to withdraw -10. Caught exception: " + exception.getMessage());
        assertEquals("Insufficient balance", exception.getMessage(),
            "Negative withdrawals should throw IllegalArgumentException");
    }
 
    @Test
    @DisplayName("Test toString method")
    void testToString() {
        System.out.println("Running test: Test toString method");
        String expected = "BankAccount [balance=100.0, deposit=0.0, withdraw=0.0]";
        System.out.println("toString() result: " + account.toString());
        assertEquals(expected, account.toString(), "toString output does not match expected format");
    }
	
}
