package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@SuppressWarnings("deprecation")
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public void addSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(supplier);
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
	@Transactional
	public List<Supplier> slist() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from Supplier");
		@SuppressWarnings("unchecked")
		List<Supplier> slist=(List<Supplier>)query.list();
		session.close();
		return slist;
	}

	@Override
	public void saveOrUpdate(Supplier supplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteSupplier(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("Delete SupplierDAO Impl Passed");
		Supplier supplier = new Supplier();
		supplier.setId(id);
		session.delete(supplier);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Supplier getSupplierById(String id) {
		Session session=sessionFactory.openSession();
		System.out.println("Supplier By Id DAO Impl Passed");
		String hql="from Supplier where id=" + "'"+ id +"'";
		 @SuppressWarnings("rawtypes")
		Query query=session.createQuery(hql);
		List<Supplier> slist= (List<Supplier>)query.list();	
		 System.out.println("inside getbyid done");
		
		return slist.get(0);
	}
}


