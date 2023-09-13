package com.example.receipt.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;




@Embeddable
public class Product {

	@Column(name ="name",table="product")
	String pname;
	@Column(name ="per",table="product")
    String per;
	@Column(name ="quantity",table="product")
	String quantity;
	@Column(name ="price",table="product")
	 String price;

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
