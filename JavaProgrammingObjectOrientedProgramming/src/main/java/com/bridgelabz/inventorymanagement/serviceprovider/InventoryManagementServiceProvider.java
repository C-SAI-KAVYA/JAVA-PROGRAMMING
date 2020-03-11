package com.bridgelabz.inventorymanagement.serviceprovider;

import java.io.FileNotFoundException;
import java.util.List;

import com.bridgelabz.inventorydetails.model.InventoryDetailsModel;
import com.bridgelabz.inventorymanagement.model.InventoryManagementModel;
import com.bridgelabz.inventorymanagement.model.PulseModel;
import com.bridgelabz.inventorymanagement.model.RiceModel;
import com.bridgelabz.inventorymanagement.model.WheatsModel;

public interface InventoryManagementServiceProvider {
	public InventoryDetailsModel readInventoryDetailsInfoFromJSONFile();
	public RiceModel addRice();
	public WheatsModel addWheat();
	public PulseModel addPulses();
	public void saveRiceDetails(String fileName, List<RiceModel> riceModel)throws FileNotFoundException;
	public void savePulseDetails(String fileName, PulseModel pulseModel)throws FileNotFoundException;
	public void saveWheatDetails(String fileName, WheatsModel wheatModel)throws FileNotFoundException; 
	public void saveInventoryDetails(String fileName, InventoryManagementModel inventoryManagemetModel) throws FileNotFoundException;
	
}
