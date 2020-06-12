package com.maria.springjwtcatalog;

public class Product {
	private long id;
	private String name;
	private double price;
	private String category;
	private String createdDate;
	private String updatedDate;
	
	public Product(long id, String name, double price, String category, String createdDate, String updatedDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
}
