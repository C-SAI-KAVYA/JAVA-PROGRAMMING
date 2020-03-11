package com.bridgelabz.stockaccount.model;

import java.util.List;

public class CustomerInformationModel {
	
	private List<CustomerInformation> customerInformation;
	
	public List<CustomerInformation> getCustomerInformation() {
		return customerInformation;
	}
	public void setCustomerInformation(List<CustomerInformation> customerInformation) {
		this.customerInformation = customerInformation;
	}
	@Override
	public String toString() {
		return "CustomerInformationModel [customerInformation=" + customerInformation + "]";
	}	
}
