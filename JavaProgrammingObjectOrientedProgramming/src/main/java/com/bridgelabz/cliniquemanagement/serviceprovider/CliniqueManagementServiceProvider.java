package com.bridgelabz.cliniquemanagement.serviceprovider;

import java.util.List;

import com.bridgelabz.cliniquemanagement.model.Appointment;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;

public interface CliniqueManagementServiceProvider {
	
	public void readDoctorInfoFromJSONFile();
	public void readPatientInfoFromJSONFile();
	public void readAppointmentInfoFromJSONFile();
	public void showDoctorList(List<Doctor> doctorsList, int index);
	public void showPatientList(List<Patient> patientList, int index);
	public Doctor getDoctor();
	public void addDoctor(Doctor doctor);
	public Patient getPatient();
	public void addPatient(Patient patient);
	public void searchDoctorByID();
	public void searchDoctorByName();
	public String getDoctorNameBySpecialization();
	public boolean searchDoctorBySpecialization();
	public boolean searchDoctorByAvailibility(String str, double time);
	public boolean searchPatientByID(int iD);
	public int getPatientIndexByID(int iD);
	public void searchPatientByName();
	public void searchPatientByMobile();
	public void addAppointment();
	public void checkAppointmentFacilities();
	public void save();
	public void showAllRecords();
	public Appointment getAppointment(int index, int patientID);
	public void saveAppointment(Appointment appointment);
}
