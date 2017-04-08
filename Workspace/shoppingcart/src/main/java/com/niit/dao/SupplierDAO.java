package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {
	public void addSupplier(Supplier supplier);

	public List<Supplier> slist();
	
	public void saveOrUpdate(Supplier supplier);
	
	public boolean deleteSupplier(String id);

	public Supplier getSupplierById(String id);


}
