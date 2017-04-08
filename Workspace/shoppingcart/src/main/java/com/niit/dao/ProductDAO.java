package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {

        public void addProduct(Product product);
		
	    public List<Product> plist();
		
	    public boolean deleteProduct(String id);

		public Product getProductById(String id);
		
		public List<Product> getProductListbycategory(String string);
		
	   
}
