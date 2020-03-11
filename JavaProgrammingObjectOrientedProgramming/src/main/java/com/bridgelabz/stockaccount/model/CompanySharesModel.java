package com.bridgelabz.stockaccount.model;

import java.util.List;

public class CompanySharesModel {
	
	private List<CompanyShares> companySharesInformation; 
	
	public List<CompanyShares> getCompanySharesInformation() {
		return companySharesInformation;
	}
	public void setCompanySharesInformation(List<CompanyShares> companyInformation) {
		this.companySharesInformation = companyInformation;
	}
	@Override
	public String toString() {
		return "CompanySharesModel [companySharesInformation=" + companySharesInformation + "]";
	}
	
}
