package com.bridgelabz.addressbook.model;



public class PersonAddress {
	
	private String localAddress;
	private String city;
	private String state;
	private int zip;

	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	
	@Override
	public String toString() {
		return "PersonAddress [localAddress=" + localAddress + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}
	
	
	
	

}
