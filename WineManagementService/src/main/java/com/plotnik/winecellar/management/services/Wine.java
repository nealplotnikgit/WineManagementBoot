package com.plotnik.winecellar.management.services;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

	@Entity
	public class Wine {
	    @Id
	    @GeneratedValue
	    private long id;
	    private long Upc;
	    private String name;
		private float price;
		private float cost;
		private String vintageYear;
		private String vintner;
		private String category;
	   
		public long getId() {
	        return id;
	    }
	    public void setId(long id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
		public long getUpc() {
			return Upc;
		}
		public void setUpc(long uPC) {
			Upc = uPC;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getCost() {
			return cost;
		}
		public void setCost(float cost) {
			this.cost = cost;
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
