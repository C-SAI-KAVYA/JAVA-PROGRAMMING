package com.bridgelabz.inventorymanagement.model;

public class RiceModel {

	private String productName;
	private double productWeight;
	private int pricePerKg;
	private double totalPriceOfWeight;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(double productWeight) {
		this.productWeight = productWeight;
	}
	public int getPricePerKg() {
		return pricePerKg;
	}
	public void setPricePerKg(int pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	
	public double getTotalPriceOfWeight() {
		return totalPriceOfWeight;
	}
	public void setTotalPriceOfWeight(double totalPriceOfWeight) {
		this.totalPriceOfWeight = totalPriceOfWeight;
	}
	@Override
	public String toString() {
		return "RiceModel [productName=" + productName + ", productWeight=" + productWeight + ", pricePerKg="
				+ pricePerKg + ", totalPriceOfWeight=" + totalPriceOfWeight + "]";
	}
	
}
