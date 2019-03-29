package com.plotnik.winecellar.management.services;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.plotnik.winecellar.management.model.Wine;

@Service
public class WineDao {

	public WineDao() {
	}
	
	public Wine getWineDetail(String id) throws WineDataException {
		Wine wine = new Wine(Integer.parseInt(id));
		wine.setCost(100.00f);
		wine.setPrice(110.00f);
		wine.setName("Le Bongo-Incredible 2");
		wine.setVintner("Apache");
		wine.setVintageYear(new Integer(LocalDate.now().getYear()).toString());
		wine.setCategory("Red");
		return wine;
	}
	
	public ArrayList<Wine> getWineList(SearchCriteria searchCriteria) throws WineDataException {
		ArrayList<Wine> wineList = new ArrayList<Wine>();
		Wine wine = new Wine(Integer.parseInt(searchCriteria.getId()));
	    wine.setCost(100.00f);
	    wine.setPrice(110.00f);
	    wine.setName(searchCriteria.getName());
	    wine.setVintner("Apache");
	    wine.setVintageYear(Year.now().toString());
	    wine.setCategory(searchCriteria.getCategory());
	    wineList.add(wine);
	    return wineList;
	}
}
