package com.plotnik.winecellar.management.services;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plotnik.winecellar.management.model.Wine;
@Service
public class WineService {
	private final WineDao wineDao;
	
	@Autowired
	public WineService(WineDao wineDao) {
		this.wineDao = wineDao;
	}
	
	public Wine getWineDetail(String id) throws WineDataException {
		Wine wine = wineDao.getWineDetail(id);
		return wine;
	}

	public ArrayList<Wine> getWineList(SearchCriteria searchCriteria) throws WineDataException {
		ArrayList<Wine> wineList = wineDao.getWineList(searchCriteria);
		return wineList;
	}
}
