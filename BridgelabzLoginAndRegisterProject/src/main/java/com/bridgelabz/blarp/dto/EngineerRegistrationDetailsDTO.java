package com.bridgelabz.blarp.dto;

public class EngineerRegistrationDetailsDTO {
	private String engineerID;
	private String engineerFirstName;
	private String engineerLastName;
	private String engineerDOB;
	private String engineerEmailID;
	private String engineerAddress;
	private String engineerMobileNumber;
	private String engineerYOP;
	private String engineerBranch;
	private String engineerAggregate;
	private String accountUserName;
	private String accountUserPassword;
	private String accountChangedPassword;
	
	
	public String getEngineerID() {
		return engineerID;
	}
	public void setEngineerID(String engineerID) {
		this.engineerID = engineerID;
	}
	public String getEngineerFirstName() {
		return engineerFirstName;
	}
	public void setEngineerFirstName(String engineerFirstName) {
		this.engineerFirstName = engineerFirstName;
	}
	public String getEngineerLastName() {
		return engineerLastName;
	}
	public void setEngineerLastName(String engineerLastName) {
		this.engineerLastName = engineerLastName;
	}
	public String getEngineerDOB() {
		return engineerDOB;
	}
	public void setEngineerDOB(String engineerDOB) {
		this.engineerDOB = engineerDOB;
	}
	public String getEngineerEmailID() {
		return engineerEmailID;
	}
	public void setEngineerEmailID(String engineerEmailID) {
		this.engineerEmailID = engineerEmailID;
	}
	public String getEngineerAddress() {
		return engineerAddress;
	}
	public void setEngineerAddress(String engineerAddress) {
		this.engineerAddress = engineerAddress;
	}
	public String getEngineerMobileNumber() {
		return engineerMobileNumber;
	}
	public void setEngineerMobileNumber(String engineerMobileNumber) {
		this.engineerMobileNumber = engineerMobileNumber;
	}
	public String getEngineerYOP() {
		return engineerYOP;
	}
	public void setEngineerYOP(String engineerYOP) {
		this.engineerYOP = engineerYOP;
	}
	public String getEngineerBranch() {
		return engineerBranch;
	}
	public void setEngineerBranch(String engineerBranch) {
		this.engineerBranch = engineerBranch;
	}
	public String getEngineerAggregate() {
		return engineerAggregate;
	}
	public void setEngineerAggregate(String engineerAggregate) {
		this.engineerAggregate = engineerAggregate;
	}
	public String getAccountUserName() {
		return accountUserName;
	}
	public void setAccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
	}
	public String getAccountUserPassword() {
		return accountUserPassword;
	}
	public void setAccountUserPassword(String accountUserPassword) {
		this.accountUserPassword = accountUserPassword;
	}
	public String getAccountChangedPassword() {
		return accountChangedPassword;
	}
	public void setAccountChangedPassword(String accountChangedPassword) {
		this.accountChangedPassword = accountChangedPassword;
	}
	@Override
	public String toString() {
		return "EngineerRegistrationDetailsDTO [engineerID=" + engineerID + ", engineerFirstName=" + engineerFirstName
				+ ", engineerLastName=" + engineerLastName + ", engineerDOB=" + engineerDOB + ", engineerEmailID="
				+ engineerEmailID + ", engineerAddress=" + engineerAddress + ", engineerMobileNumber="
				+ engineerMobileNumber + ", engineerYOP=" + engineerYOP + ", engineerBranch=" + engineerBranch
				+ ", engineerAggregate=" + engineerAggregate + ", AccountUserName=" + accountUserName
				+ ", AccountUserPassword=" + accountUserPassword + ", AccountChangedPassword=" + accountChangedPassword
				+ "]";
	}
	
}
