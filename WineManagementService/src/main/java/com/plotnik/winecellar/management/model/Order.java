package com.plotnik.winecellar.management.model;

import java.util.ArrayList;

public class Order {

	ArrayList<Wine> wineList;
	String account;
	String shipMethod;
	String paymentMethod;
	Address shippingaddress;
	public ArrayList<Wine> getWineList() {
		return wineList;
	}
	public void setWineList(ArrayList<Wine> wineList) {
		this.wineList = wineList;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getShipMethod() {
		return shipMethod;
	}
	public void setShipMethod(String shipMethod) {
		this.shipMethod = shipMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Address getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(Address shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
}
