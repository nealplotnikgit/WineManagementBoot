package com.plotnik.winecellar.management.model;

import java.sql.Date;
import java.time.LocalDate;

public class Wine {

	private int upc;  // 12 digit id
	private String name;
	private float price;
	private float cost;
	private String vintageYear;
	private String vintner;
	private String category;
	
	public Wine(){
	};
	
	public Wine(int UPC){
		this.upc = UPC;
	};
	public Wine(int UPC, float price, float cost){
		this(UPC);
		this.price = price;
		this.cost = cost;
		
	};
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUpc() {
		return upc;
	}
	public void setUpc(int uPC) {
		upc = uPC;
	}
	public String getVintageYear() {
		return vintageYear;
	}
	public void setVintageYear(String vintageYear) {
		this.vintageYear = vintageYear;
	}
	public String getVintner() {
		return vintner;
	}
	public void setVintner(String vintner) {
		this.vintner = vintner;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
