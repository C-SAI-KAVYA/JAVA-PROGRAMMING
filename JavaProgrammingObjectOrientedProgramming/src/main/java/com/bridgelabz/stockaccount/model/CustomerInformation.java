package com.bridgelabz.stockaccount.model;

public class CustomerInformation {
	
	private int customerID;
	private String customerName;
	private int customerShares;
	private int customerBalance;
	

	public int getCustomerSymbol() {
		return customerID;
	}
	public void setCustomerSymbol(int customerSymbol) {
		this.customerID = customerSymbol;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerShares() {
		return customerShares;
	}
	public void setCustomerShares(int d) {
		this.customerShares = d;
	}
	public int getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}
	@Override
	public String toString() {
		return "CustomerInformation [customerID=" + customerID + ", customerName=" + customerName + ", customerShares="
				+ customerShares + ", customerBalance=" + customerBalance + "]";
	}
	
	
}
