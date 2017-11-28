package com.pojo;

public class Product {
	private int id;
	private String productname;
	private int quantity;
	
	public Product(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname
				+ ", quantity=" + quantity + "]";
	}
	
	
}
