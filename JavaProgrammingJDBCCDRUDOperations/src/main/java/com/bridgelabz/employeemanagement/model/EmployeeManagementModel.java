package com.bridgelabz.employeemanagement.model;

public class EmployeeManagementModel {
	private int EmpID;
	private String EmpFirstName;
	private String EmpLastName;
	private String EmpEmail;
	private long EmpMobileNumber;
	
	
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public String getEmpFirstName() {
		return EmpFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		EmpFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return EmpLastName;
	}
	public void setEmpLastName(String empLastName) {
		EmpLastName = empLastName;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public long getEmpMobileNumber() {
		return EmpMobileNumber;
	}
	public void setEmpMobileNumber(long empMobileNumber) {
		EmpMobileNumber = empMobileNumber;
	}
	@Override
	public String toString() {
		return "EmployeeManagementModel [EmpID=" + EmpID + ", EmpFirstName=" + EmpFirstName + ", EmpLastName="
				+ EmpLastName + ", EmpEmail=" + EmpEmail + ", EmpMobileNumber=" + EmpMobileNumber + "]";
	}
}