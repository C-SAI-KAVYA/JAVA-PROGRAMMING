package com.bridgelabz.cliniquemanagement.model;

public class AvailibilityModel {
	
	private double inTime;
	private double outTime;
	private String date;
	
	
	public double getInTime() {
		return inTime;
	}
	public void setInTime(double inTime) {
		this.inTime = inTime;
	}
	public double getOutTime() {
		return outTime;
	}
	public void setOutTime(double outTime) {
		this.outTime = outTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AvailibilityModel [inTime=" + inTime + ", outTime=" + outTime + ", date=" + date + "]";
	}
	
	
}
