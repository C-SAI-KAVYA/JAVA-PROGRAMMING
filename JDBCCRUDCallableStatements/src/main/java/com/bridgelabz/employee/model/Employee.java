package com.bridgelabz.employee.model;

public class Employee {
	private long iD;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNumber;
	
	
	public long getEmpID() {
		return iD;
	}
	public void setID(long empID) {
		empID = empID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String empFirstName) {
		firstName = empFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setEmpLastName(String empLastName) {
		lastName = empLastName;
	}
	public String getEmpEmail() {
		return email;
	}
	public void setEmpEmail(String empEmail) {
		email = empEmail;
	}
	public long getEmpMobileNumber() {
		return mobileNumber;
	}
	public void setEmpMobileNumber(long empMobileNumber) {
		mobileNumber = empMobileNumber;
	}
	@Override
	public String toString() {
		return "EmployeeManagementModel [EmpID=" + iD + ", EmpFirstName=" + firstName + ", EmpLastName="
				+ lastName + ", EmpEmail=" + email + ", EmpMobileNumber=" + mobileNumber + "]";
	}
}
