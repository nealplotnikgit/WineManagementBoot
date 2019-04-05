package com.plotnik.winecellar.management.services;

public abstract class BaseWineResponse {

	
	private WineError error;

	public WineError getError() {
		return error;
	}

	public void setError(WineError error) {
		this.error = error;
	}
	
	
}
