package com.plotnik.winecellar.management.services;

import java.time.Year;

public class SearchCriteria {
	
   private String id = null;
   private String name = null;
   private Year year = null;
   private String category = null;

   public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
