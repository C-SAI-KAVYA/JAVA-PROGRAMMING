package com.bridgelabz.stockaccount.model;

import java.util.List;

public class TransactionModel {
	
	
	private List<Transaction> transactionInformation;
	
	
	public List<Transaction> getTransactionInformation() {
		return transactionInformation;
	}
	public void setTransactionInformation(List<Transaction> transactionInformation) {
		this.transactionInformation = transactionInformation;
	}
	@Override
	public String toString() {
		return "TransactionModel [transactionInformation=" + transactionInformation + "]";
	}
	

}
