package com.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class TakeOut {
	private int id;
	private int quantity;
	private Timestamp outdate;
	private String handler;
	private int productid;
	public TakeOut(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Timestamp getOutdate() {
		return outdate;
	}
	public void setOutdate(Timestamp outdate) {
		this.outdate = outdate;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public String toString() {
		return "TakeOut [id=" + id + ", quantity=" + quantity + ", outdate="
				+ outdate + ", handler=" + handler + ", productid=" + productid
				+ "]";
	}
	
	
}
