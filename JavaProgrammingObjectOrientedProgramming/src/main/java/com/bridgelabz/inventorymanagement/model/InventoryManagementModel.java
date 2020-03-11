package com.bridgelabz.inventorymanagement.model;

import java.util.List;

public class InventoryManagementModel {
	
	private List<WheatsModel> wheatsList;
	private List<PulseModel> pulsesList;
	private List<RiceModel> riceList;
	private double totalStockValue;
	public List<WheatsModel> getWheatsList() {
		return wheatsList;
	}
	public void setWheatsList(List<WheatsModel> wheatsList) {
		this.wheatsList = wheatsList;
	}
	public List<PulseModel> getPulsesList() {
		return pulsesList;
	}
	public void setPulsesList(List<PulseModel> pulsesList) {
		this.pulsesList = pulsesList;
	}
	public List<RiceModel> getRiceList() {
		return riceList;
	}
	public void setRiceList(List<RiceModel> riceList) {
		this.riceList = riceList;
	}
	public double getTotalStockValue() {
		return totalStockValue;
	}
	public void setTotalStockValue(double totalStockValue) {
		this.totalStockValue = totalStockValue;
	}
	@Override
	public String toString() {
		return "InventoryDetailsModel [wheatsList=" + wheatsList + ", pulsesList=" + pulsesList + ", riceList="
				+ riceList + ", totalStockValue=" + totalStockValue + "]";
	}

}
