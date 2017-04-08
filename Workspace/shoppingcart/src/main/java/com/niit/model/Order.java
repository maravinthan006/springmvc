package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ORDER_TABLE")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderid;
	
	@ManyToOne
	@JoinColumn(name="username")
	private Register user;
		
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	 
	@Column
	private int quantity=1;
	
	@Column
	private int total;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Register getUser() {
		return user;
	}

	public void setUser(Register user) {
		this.user = user;
	}
	
}