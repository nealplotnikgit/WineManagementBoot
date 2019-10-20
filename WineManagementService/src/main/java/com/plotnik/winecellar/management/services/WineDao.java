package com.plotnik.winecellar.management.services;

import java.util.ArrayList;

import com.plotnik.winecellar.management.model.Wine;

public interface WineDao {

	ArrayList<Wine> getWineList(Long id,String year,String name,String category) throws WineDataException;
	
	Wine getWineDetail(long UPC) throws WineDataException;

}