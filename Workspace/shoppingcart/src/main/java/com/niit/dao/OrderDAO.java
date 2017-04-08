package com.niit.dao;

import java.util.List;

import com.niit.model.Order;
import com.niit.model.Product;
import com.niit.model.Register;

public interface OrderDAO {
	  public boolean add(Product product, Register user, int quantity,int total);	
	  public List<Order> getOrderListbyname(String username);
	  public Boolean remove(int orderId);
	  public void removeorderbycartid(String username);
      public boolean addingproduct(String username, String productId, int quantity);
	  public boolean updatequantity(String username, String productId, int quantity);

			
}
