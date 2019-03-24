package com.plotnik.winecellar.management.services;

public class WineException extends Exception {

	public WineException(String s, WineDataException w) {
		super(s,w);
	}

	public WineException(String s) {
		super(s);
	}

}
