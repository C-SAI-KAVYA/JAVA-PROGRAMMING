package com.bridgelabz.stockaccountmanagement.model;

import java.util.List;

public class StockAccountManagementModel {

	private List<DairyMilk> dairyMilk;
	private List<MilkyBar> milkyBar;
	private List<KitKat> kitKat;
	private List<PikNik> pikNik;
	private double totalValueOfAllStocks;

	public List<DairyMilk> getDairyMilk() {
		return dairyMilk;
	}

	public void setDairyMilk(List<DairyMilk> dairyMilk) {
		this.dairyMilk = dairyMilk;
	}

	public List<MilkyBar> getMilkyBar() {
		return milkyBar;
	}

	public void setMilkyBar(List<MilkyBar> milkyBar) {
		this.milkyBar = milkyBar;
	}

	public List<KitKat> getKitKat() {
		return kitKat;
	}

	public void setkitKat(List<KitKat> kitKat) {
		this.kitKat = kitKat;
	}

	public List<PikNik> getPikNik() {
		return pikNik;
	}

	public void setpikNik(List<PikNik> pikNik) {
		this.pikNik = pikNik;
	}

	public double getTotalValueOfAllStocks() {
		return totalValueOfAllStocks;
	}

	public void setTotalValueOfAllStocks(double totalValueOfAllStocks) {
		this.totalValueOfAllStocks = totalValueOfAllStocks;
	}

	@Override
	public String toString() {
		return "StockAccountManagementModel [dairyMilk=" + dairyMilk + ", milkyBar=" + milkyBar + ", kitKat=" + kitKat
				+ ", pikNik=" + pikNik + ", totalValueOfAllStocks=" + totalValueOfAllStocks + "]";
	}

}
