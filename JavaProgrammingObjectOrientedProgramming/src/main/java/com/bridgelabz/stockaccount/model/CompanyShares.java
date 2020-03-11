package com.bridgelabz.stockaccount.model;

public class CompanyShares {
	
	private String companySymbol;
	private String companyName;
	private int companyShares;
	private int companySharePrices;
	private int companyTotalSharePriceValue;
	
	public String getCompanySymbol() {
		return companySymbol;
	}
	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyShares() {
		return companyShares;
	}
	public void setCompanyShares(int companyShares) {
		this.companyShares = companyShares;
	}
	public int getCompanySharePrices() {
		return companySharePrices;
	}
	public void setCompanySharePrices(int companySharePrices) {
		this.companySharePrices = companySharePrices;
	}
	public int getCompanyTotalSharePriceValue() {
		return companyTotalSharePriceValue;
	}
	public void setCompanyTotalSharePriceValue(int companyTotalSharePriceValue) {
		this.companyTotalSharePriceValue = companyTotalSharePriceValue;
	}
	@Override
	public String toString() {
		return "CompanyShares [companySymbol=" + companySymbol + ", companyName=" + companyName + ", companyShares="
				+ companyShares + ", companySharePrices=" + companySharePrices + ", companyTotalSharePriceValue="
				+ companyTotalSharePriceValue + "]";
	}
}
