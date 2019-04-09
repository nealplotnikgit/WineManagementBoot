package com.plotnik.winecellar.management.services;

import java.util.ArrayList;

import com.plotnik.winecellar.management.model.Wine;

public interface WineDao {

	Wine getWineDetail(String id) throws WineDataException;

	ArrayList<Wine> getWineList(SearchCriteria searchCriteria) throws WineDataException;

}