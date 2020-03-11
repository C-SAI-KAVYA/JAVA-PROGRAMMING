package com.bridgelabz.stockaccount.model;

public class Transaction {
	private String transactionID;
	private String sharesBuyerName;
	private String sharesSellerName;
	private int transactionAmount;
	private String dateAndTimeOfTransaction;
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getSharesBuyerName() {
		return sharesBuyerName;
	}
	public void setSharesBuyerName(String sharesBuyerName) {
		this.sharesBuyerName = sharesBuyerName;
	}
	public String getSharesSellerName() {
		return sharesSellerName;
	}
	public void setSharesSellerName(String sharesSellerName) {
		this.sharesSellerName = sharesSellerName;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDateAndTimeOfTransaction() {
		return dateAndTimeOfTransaction;
	}
	public void setDateAndTimeOfTransaction(String dateAndTimeOfTransaction) {
		this.dateAndTimeOfTransaction = dateAndTimeOfTransaction;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", sharesBuyerName=" + sharesBuyerName
				+ ", sharesSellerName=" + sharesSellerName + ", transactionAmount=" + transactionAmount
				+ ", dateAndTimeOfTransaction=" + dateAndTimeOfTransaction + "]";
	}
	
	
}
