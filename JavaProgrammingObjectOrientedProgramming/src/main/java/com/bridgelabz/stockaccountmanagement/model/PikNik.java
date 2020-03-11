package com.bridgelabz.stockaccountmanagement.model;

public class PikNik {
	
	private String stockName;
	private int numberOfShares;
	private double sharePrices;
	private double totalStockValue;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public double getSharePrices() {
		return sharePrices;
	}

	public void setSharePrices(double sharePrices) {
		this.sharePrices = sharePrices;
	}

	public double getTotalStockValue() {
		return totalStockValue;
	}

	public void setTotalStockValue(double totalStockValue) {
		this.totalStockValue = totalStockValue;
	}
	@Override
	public String toString() {
		return "PikNik [stockName=" + stockName + ", numberOfShares=" + numberOfShares + ", sharePrices=" + sharePrices
				+ ", totalStockValue=" + totalStockValue + "]";
	}
}
