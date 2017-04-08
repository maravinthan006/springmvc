package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;


@SuppressWarnings("deprecation")
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	
      
@Override	
public void addCategory(Category category) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(category);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}


@SuppressWarnings("rawtypes")
@Transactional
   public List<Category> list() {
	Session session=sessionFactory.openSession();
	Query query = session.createQuery("from Category");
	@SuppressWarnings("unchecked")
	List <Category> list=(List<Category>)query.list();
	session.close();
	return list;
}
	@Override
	public void saveOrUpdate(Category category) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.update(category);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}
	
	@Override
	public boolean deleteCategory(String id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("Delete CategoryDAO Passed");
		Category category = new Category();
		category.setId(id);
		session.delete(category);
		session.getTransaction().commit();
		session.close();
		return true;
	}
					
	@SuppressWarnings({ "rawtypes","unchecked" })
	@Override
	public Category getCategoryById(String id) {
		Session session=sessionFactory.openSession();
		System.out.println("inside getbyid dao");
		String hql="from Category where id=" + "'"+ id +"'";
		 Query query=session.createQuery(hql);
		List<Category> list= (List<Category>)query.list();	
		 System.out.println("inside getbyid done");
		
		return list.get(0);
	}
}
