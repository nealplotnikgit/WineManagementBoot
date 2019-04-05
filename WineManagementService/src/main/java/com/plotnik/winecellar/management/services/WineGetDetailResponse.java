package com.plotnik.winecellar.management.services;

import com.plotnik.winecellar.management.model.Wine;

public class WineGetDetailResponse extends BaseWineResponse {

	
	private Wine wine;

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}
	
	
}
