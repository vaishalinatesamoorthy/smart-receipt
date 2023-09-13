package com.example.receipt.model;



import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "receipt")
@SecondaryTable(name="product",pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))
public class Receipt {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="id")
	private long id;
	@Column(name="cid")
	private String cid;
	@NotEmpty
	@Size(min=3 , max=100)
	@Column(name="name")
    private String cname;
	@Column(name="emailId")
    @Email
    private String email;
    @NotEmpty
   @Column(name="address")
    private String address;
    @Column(name="totalamount")
    private float totalAmount;
    @Embedded
    private Product productdetails;
    public Product getProductdetails() {
		return productdetails;
	}
	public void setProductdetails(Product productdetails) {
		
		this.productdetails = productdetails;
	}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
} 
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public float getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(float totalAmount) {
	this.totalAmount = totalAmount;
}







}
