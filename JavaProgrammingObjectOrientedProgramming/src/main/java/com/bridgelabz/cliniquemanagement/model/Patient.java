package com.bridgelabz.cliniquemanagement.model;

public class Patient {

	private int patientID;
	private String patientName;
	private int patientAge;
	private String patientMobileNumber;
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}
	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}
	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMobileNumber=" + patientMobileNumber + "]";
	}
	
}
