package com.plotnik.winecellar.management.services;

import org.springframework.dao.DataAccessException;

public class WineDataException extends Exception {

	public WineDataException(String string, Exception d) {
		super(string,d);
	}

	public WineDataException(String string) {
		super(string);
	}

}
