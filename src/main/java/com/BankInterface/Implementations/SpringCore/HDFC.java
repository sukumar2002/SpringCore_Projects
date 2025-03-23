package com.BankInterface.Implementations.SpringCore;

import org.springframework.stereotype.Component;

import com.BankInterface.SpringCore.Bank;
@Component
public class HDFC implements Bank{

	 private double amount;
	 
	public HDFC() {
		this.amount=0.0;
	}
    
    @Override
    public synchronized double getAmount() {
        return amount;
    }
    
    @Override
    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }
	 @Override
	    public synchronized String deposit(double amount) {
	        this.amount += amount;
	        return "Deposited " + amount + " to HDFC account. Current Balance: " + this.amount;
	    }
	    
	    @Override
	    public synchronized String withdraw(double amount) {
	        if (this.amount >= amount) {
	            this.amount -= amount;
	            return "Withdrawn " + amount + " from HDFC account. Current Balance: " + this.amount;
	        }
	        return "Insufficient balance in HDFC account.";
	    }
	 @Override
	    public String toString() {
	        return "HDFC Account Balance: " + this.amount;
	    }
}
