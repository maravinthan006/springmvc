package com.niit.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Register;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addRegister(Register register) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.save(register);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Register> validate(Register register) {
		     List<Register> listRegister=null;
			 System.out.println("inside DAO"+register);
			try
			{
				Session session=sessionFactory.openSession();
					
				@SuppressWarnings("unused")
				Transaction trans=session.beginTransaction();
				
				
				Query<Register> qry = session.createQuery("from Register where username='"+register.getUsername()+"' and password='"+register.getPassword()+"'");
				
				 listRegister = qry.getResultList();
				
				System.out.println(listRegister.size());
			}
			
			catch(Exception ex)
			{
				System.out.println("Error="+ex);
			}
			return listRegister;
		}


}
