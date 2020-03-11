package com.bridgelabz.cliniquemanagement.model;

public class Doctor {
	
	private int doctorID;
	private String doctorName;
	private String doctorSpecilization;
	private AvailibilityModel doctorAvailableStatus;
	private int noOfPatients;
	
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
	public String getDoctorSpecilization() {
		return doctorSpecilization;
	}
	public void setDoctorSpecilization(String doctorSpecilization) {
		this.doctorSpecilization = doctorSpecilization;
	}
	public AvailibilityModel getDoctorAvailableStatus() {
		return doctorAvailableStatus;
	}
	public void setDoctorAvailableStatus(AvailibilityModel doctorAvailableStatus) {
		this.doctorAvailableStatus = doctorAvailableStatus;
	}
	public int getNoOfPatients() {
		return noOfPatients;
	}
	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}
	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", doctorName=" + doctorName + ", doctorSpecilization="
				+ doctorSpecilization + ", doctorAvailableStatus=" + doctorAvailableStatus + ", noOfPatients="
				+ noOfPatients + "]";
	}
	
}
