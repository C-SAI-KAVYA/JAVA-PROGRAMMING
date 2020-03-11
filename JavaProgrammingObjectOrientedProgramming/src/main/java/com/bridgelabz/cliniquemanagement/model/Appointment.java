package com.bridgelabz.cliniquemanagement.model;

public class Appointment {
	private int appID;
	private int doctorID;
	private String doctorName;
	private String doctorStatus;
	private int assignedPatientID;
	private String assignedPatientName;
	private String assignedPatientMobileNumber;
	

	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorStatus() {
		return doctorStatus;
	}
	public void setDoctorStatus(String doctorStatus) {
		this.doctorStatus = doctorStatus;
	}
	public int getAssignedPatientID() {
		return assignedPatientID;
	}
	public void setAssignedPatientID(int assignedPatientID) {
		this.assignedPatientID = assignedPatientID;
	}
	public String getAssignedPatientName() {
		return assignedPatientName;
	}
	public void setAssignedPatientName(String assignedPatientName) {
		this.assignedPatientName = assignedPatientName;
	}
	public String getAssignedPatientMobileNumber() {
		return assignedPatientMobileNumber;
	}
	public void setAssignedPatientMobileNumber(String assignedPatientMobileNumber) {
		this.assignedPatientMobileNumber = assignedPatientMobileNumber;
	}
	@Override
	public String toString() {
		return "Appointment [appID=" + appID + ", doctorID=" + doctorID + ", doctorName=" + doctorName
				+ ", doctorStatus=" + doctorStatus + ", assignedPatientID=" + assignedPatientID
				+ ", assignedPatientName=" + assignedPatientName + ", assignedPatientMobileNumber="
				+ assignedPatientMobileNumber + "]";
	}
	
}
