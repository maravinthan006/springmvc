package com.niit.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.Product;  
  
@SuppressWarnings("deprecation")
@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

@Override
public void addProduct(Product product) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(product);
			trans.commit();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}

@SuppressWarnings("rawtypes")
@Transactional
public List<Product> plist() {
	Session session=sessionFactory.openSession();
	Query query = session.createQuery("from Product");
	@SuppressWarnings("unchecked")
	List <Product> plist=(List<Product>)query.list();
	System.out.println("List Product DAO Passed");
	session.close();
	return plist;
}

@Override
public boolean deleteProduct(String id) {
	Session session = sessionFactory.openSession();
	session.beginTransaction();	
	System.out.println("Delete Product DAO Passed");
	Product product = new Product();
	product.setId(id);
	session.delete(product);
	session.getTransaction().commit();
	session.close();
	return true;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
@Override
public Product getProductById(String id) {
	Session session=sessionFactory.openSession();
	System.out.println("GetProductById DAO Passed");
	String hql="from Product where id=" + "'"+ id +"'";
	Query query=session.createQuery(hql);
	List<Product> plist= (List<Product>)query.list();	
	
	return plist.get(0);
}

@SuppressWarnings({ "unchecked" })
public List<Product> getProductListbycategory(String category_id) {
	System.out.println("inside get product list by category "+category_id);
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	Criteria cr = session.createCriteria(Product.class);
	cr.add(Restrictions.like("category_id", category_id));
	List<Product> list = cr.list();
    System.out.println("end pf product list by category");
	return list;

}


}
