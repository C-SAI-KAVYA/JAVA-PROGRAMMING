package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class DoctorModel {
	
	private List<Doctor> doctors;
	
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Doctor [doctors=" + doctors + "]";
	}
	
}
