package com.plotnik.winecellar.management.model;

public class Address {
	String name;
	String addressline1;
	String addressline2;
	String street;
	String city;
	String state;
	String zipCode;
	public String getAddressline1() {
		return addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public String getCity() {
		return city;
	}
	public String getName() {
		return name;
	}
	public String getState() {
		return state;
	}
	public String getStreet() {
		return street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
