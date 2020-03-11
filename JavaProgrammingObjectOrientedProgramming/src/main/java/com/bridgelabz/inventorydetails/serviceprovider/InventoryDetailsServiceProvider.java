package com.bridgelabz.inventorydetails.serviceprovider;

import java.io.FileNotFoundException;

import com.bridgelabz.inventorydetails.model.InventoryDetailsModel;

public interface InventoryDetailsServiceProvider {
	public InventoryDetailsModel readInventoryDetailsInfoFromJSONFile();
	public void saveInventoryDetails(String fileName, InventoryDetailsModel inventoryDetailsModel) throws FileNotFoundException;
}
