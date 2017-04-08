package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDAO;
import com.niit.model.Category;
import com.niit.model.Order;
import com.niit.model.Product;
import com.niit.model.Register;

@Repository("cartDAO")
public class OrderDAOImpl implements OrderDAO {
	
	  @Autowired
	  SessionFactory sessionFactory;

	    //-------------------------------------------------------add product----------------------------------------------------------------------------------------------
	  public boolean add(Product product, Register user, int quantity, int total) {
		  System.out.println("inside add product in OrderDAOImpl");
		  Session session = sessionFactory.openSession();
			session.beginTransaction();
			Order order= new Order();
		    order.setUser(user);
		    order.setProduct(product);
		    order.setQuantity(quantity);
		    order.setTotal(total);	
			session.saveOrUpdate(order);
			session.getTransaction().commit();
			session.close();
			System.out.println("leaving add product in OrderDAOImpl");
			return true;
		}

	    //-------------------------------------------------------get OrderListby name----------------------------------------------------------------------------------------------
	    @SuppressWarnings({ "deprecation", "unchecked" })
	    public List<Order> getOrderListbyname(String username) {
	    	System.out.println("inside getOrderListbyname in OrderDAOImpl");
	    	Session session = sessionFactory.openSession();
	    	session.beginTransaction();

		Criteria cr = session.createCriteria(Order.class);     //The Criteria API provides the org.hibernate.criterion.Projections class which can be used to get average, maximum or minimum of the property values. 
		cr.add(Restrictions.like("user.username", username));		//Restrictions provide certain conditions for query
		List<Order> list = cr.list();
		System.out.println("leaving getOrderListbyname in OrderDAOimpl");
		return list;

	    }
	    
	    //-------------------------------------------------------remove order----------------------------------------------------------------------------------------------
	    public Boolean remove(int orderId){
	    	System.out.println("inside remove order in OrderDAOImpl");
	    	Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			Order order= new Order();
			order.setOrderid(orderId);
			session.delete(order);
			session.getTransaction().commit();
			session.close();
			System.out.println("leaving removeorder in OrderDAOImpl");
			return true;

	    }
	
	    //-------------------------------------------------------remove complete cart by cartId----------------------------------------------------------------------------------------------
	    public void removeorderbycartid(String username){
	    	System.out.println("inside remove orderbycartid in OrderDAOImpl");
	    	Session session = sessionFactory.openSession();
			session.beginTransaction();
	
	    	@SuppressWarnings("rawtypes")
			Query q = session.createQuery("delete Order where username = username");
	    	q.executeUpdate();
	    	session.getTransaction().commit();
			session.close();
			System.out.println("leaving remove orderbyId in OrderDAOImpl");
	    }
	    
	    
	    @Transactional
	    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
		public boolean addingproduct(String username, String productId, int quantity) {
	    	System.out.println("inside getByName in categoryDAOImpl");
	    	Session session = sessionFactory.openSession();
			session.beginTransaction();
	
	    	String hql = "from Order where username =" + "'" + username + "'"+" and productId =" + "'" + productId+"'";
		Query<Order> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Order> list = (List<Order>) query.list();
		if (list != null && !list.isEmpty()) {
			
			
			
			
			quantity=query.uniqueResult().getQuantity()+quantity;
			int total=quantity*query.uniqueResult().getProduct().getPrice();
			int orderId=query.uniqueResult().getOrderid();
			Query query1 = session.createQuery("update Order set quantity = :quantity " +
    				" where orderid = :orderid");
		query1.setParameter("quantity", quantity);
		
query1.setParameter("orderid", orderId);
 query1.executeUpdate();
	Query query2 = session.createQuery("update Order set total = :total " +
			" where orderid = :orderid");
query2.setParameter("total", total);

query2.setParameter("orderid", orderId);
query2.executeUpdate();
		
 session.getTransaction().commit();
				session.close();
			
			return true;
		}
			else{
		   
			session.getTransaction().commit();
			session.close();
		   return false;
		}	}

	    

@Transactional
@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
public boolean updatequantity(String username, String productId, int quantity) {


System.out.println("inside getByName in categoryDAOImpl");
Session session = sessionFactory.openSession();
session.beginTransaction();

String hql = "from Order where username =" + "'" + username + "'"+" and productId =" + "'" + productId+"'";
Query<Order> query = sessionFactory.getCurrentSession().createQuery(hql);


int total=quantity*query.uniqueResult().getProduct().getPrice();
System.out.println("total"+total);
int orderId=query.uniqueResult().getOrderid();
Query query1 = session.createQuery("update Order set quantity = :quantity " +
		" where orderid = :orderid");
query1.setParameter("quantity", quantity);

query1.setParameter("orderid", orderId);
query1.executeUpdate();
Query query2 = session.createQuery("update Order set total = :total " +
" where orderid = :orderid");
query2.setParameter("total", total);

query2.setParameter("orderid", orderId);
query2.executeUpdate();

session.getTransaction().commit();
	session.close();
return true;
}}
