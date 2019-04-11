package com.plotnik.winecellar.management.services;

import java.util.ArrayList;

import com.plotnik.winecellar.management.model.Wine;

public interface WineDao {

	ArrayList<Wine> getWineList(long upc, String category, String name, String year) throws WineDataException;
	
	Wine getWineDetail(long UPC) throws WineDataException;

}