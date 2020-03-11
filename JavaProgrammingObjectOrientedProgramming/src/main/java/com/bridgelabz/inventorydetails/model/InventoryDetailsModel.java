package com.bridgelabz.inventorydetails.model;

import java.util.List;

public class InventoryDetailsModel {
	private List<WheatsModel> wheatsList;
	private List<PulseModel> pulsesList;
	private List<RiceModel> riceList;
	private int totalStockValue;
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
	public int getTotalStockValue() {
		return totalStockValue;
	}
	public void setTotalStockValue(int totalStockValue) {
		this.totalStockValue = totalStockValue;
	}
	@Override
	public String toString() {
		return "InventoryDetailsModel [wheatsList=" + wheatsList + ", pulsesList=" + pulsesList + ", riceList="
				+ riceList + ", totalStockValue=" + totalStockValue + "]";
	}
}
