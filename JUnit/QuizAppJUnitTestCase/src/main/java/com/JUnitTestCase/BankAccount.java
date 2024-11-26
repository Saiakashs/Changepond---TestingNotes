package com.JUnitTestCase;

public class BankAccount {
	private double balance;
	private double deposit;
	private double withdraw;
 
   
	public BankAccount(double balance, double deposit, double withdraw) {
		super();                 //refer parent class constructor
		this.balance = balance;  //this will hold the current value
		this.deposit = deposit;
		this.withdraw = withdraw;
	}
 
	//getter and setter methods
	public double getBalance() {
		return balance;
	}
 
 
	public void setBalance(double balance) {
		this.balance = balance;
	}
 
 
	public double getDeposit() {
		return deposit;
	}
 
 
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
 
 
	public double getWithdraw() {
		return withdraw;
	}
 
 
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
 
 
	public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
 
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance"); //Exceptional handling
        }
        balance -= amount;
    }
 
    //toString - display the result
	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", deposit=" + deposit + ", withdraw=" + withdraw + "]";
	}
	
    

}
