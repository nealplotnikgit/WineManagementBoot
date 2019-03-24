package com.plotnik.winecellar.management.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.plotnik.winecellar.management.model.Wine;
@Service
public class GetWineDetailService {

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
}
