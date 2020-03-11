package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class AppointmentModel {
	
	private List<Appointment> appointmentsList;
	
	public List<Appointment> getAppointmentsList() {
		return appointmentsList;
	}
	public void setAppointmentsList(List<Appointment> appointmentsList) {
		this.appointmentsList = appointmentsList;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentsList=" + appointmentsList + "]";
	}
	
}
