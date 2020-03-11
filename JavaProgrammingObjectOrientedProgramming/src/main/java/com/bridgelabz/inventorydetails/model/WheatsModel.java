package com.bridgelabz.inventorydetails.model;

public class WheatsModel {
	
	private String productName;
	private double productWeight;
	private int pricePerKg;
	
	
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
	@Override
	public String toString() {
		return "WheatsModel [productName=" + productName + ", productWeight=" + productWeight + ", pricePerKg="
				+ pricePerKg + "]";
	}
}
