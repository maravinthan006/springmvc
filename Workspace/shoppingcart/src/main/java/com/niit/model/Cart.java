package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Cart")
@Component
public class Cart {

	@Id
	private String orderid;
	
	@Column
	private String product_id;  
	
	@Column
	private String user_name;  
	
	@ManyToOne
	@JoinColumn(name = "product_id", updatable = false, insertable = false, nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "user_name", updatable = false, insertable = false, nullable = false)
	private Register username;
	
	@Column
	private String quantity;
	
	@Column
	private String total;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Register getUsername() {
		return username;
	}

	public void setUsername(Register username) {
		this.username = username;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Object getCartItems() {
		// TODO Auto-generated method stub
		return null;
	}


}
