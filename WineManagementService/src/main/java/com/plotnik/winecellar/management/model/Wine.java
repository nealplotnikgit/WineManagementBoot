package com.plotnik.winecellar.management.model;

import java.sql.Date;
import java.time.LocalDate;

public class Wine {

	private long upc;  // 12 digit id
	private String name;
	private float price;
	private float cost;
	private String vintageYear;
	private String vintner;
	private String category;
	
	public Wine(){
	};
	
	public Wine(long UPC){
		this.upc = UPC;
	};
	public Wine(long UPC, float price, float cost){
		this(UPC);
		this.price = price;
		this.cost = cost;
		
	};
	public Wine(long UPC, String name, float price, float cost, String year, String vintner, String category){
		this(UPC);
		this.price = price;
		this.cost = cost;
		this.name = name;
		this.vintageYear = year;
		this.vintner = vintner;
		this.category = category;
		
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
	public long getUpc() {
		return upc;
	}
	public void setUpc(long uPC) {
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
