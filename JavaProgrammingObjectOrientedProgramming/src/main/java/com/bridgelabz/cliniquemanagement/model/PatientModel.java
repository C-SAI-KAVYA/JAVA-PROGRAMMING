package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class PatientModel {
	
	private List<Patient> patientsList;
	
	public List<Patient> getPatientsList() {
		return patientsList;
	}
	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}
	@Override
	public String toString() {
		return "PatientModel [patientsList=" + patientsList + "]";
	}
	
}
