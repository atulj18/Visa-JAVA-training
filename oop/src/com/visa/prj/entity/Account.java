package com.visa.prj.entity;
/**
 * This is a class to represent account business data.
 * It allows to credit and debit account
 * @author AJ
 *
 */

public class Account {
	private double balance; //instance variable
	
	private static int count; //class variable as static
	
	public Account() {
		count++;
	}
	
	/**
	 * method to credit amount into account
	 * 
	 * @param amt amount to be credited
	 */
	public void deposit(double amt) {  //instance method
		this.balance += amt;
	}
	
	/**
	 * method returns the current balance in account
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	public static int getCount() { //class method as static
		return count; //this.count not used because class variable
	}
}
