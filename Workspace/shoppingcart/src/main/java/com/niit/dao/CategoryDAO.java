package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO {
	
	public void addCategory(Category category);

	public List<Category> list();
	
	public void saveOrUpdate(Category category);
	
	public boolean deleteCategory(String id);

	public Category getCategoryById(String id);
	
	
	
}
