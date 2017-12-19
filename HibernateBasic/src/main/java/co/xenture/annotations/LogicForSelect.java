package co.xenture.annotations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.xenture.HibernateBasic.Product;

public class LogicForSelect {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("co/xenture/annotations/hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//Hql select 
		
	String hql = "from UserLogin where userName=:username and userPassword =:password";
		Query query = session.createQuery(hql);
		query.setString("username", "prem");
		query.setString("password", "12345");
		List list=query.list();
		Iterator it =list.iterator();
		System.out.println("size"+list.size());
		if(list.size()==0){
			System.out.println("User doesnot exits");
		}
		System.out.println("--------------------------------");
		
		while(it.hasNext()){
			
			Object object= it.next();
			UserLogin login = (UserLogin) object;
			System.out.println("Welcome "+login.getUserName());
		}

		
		//Critera Select
		
		/*Criteria crit= session.createCriteria(UserRegistration.class);
		
		List list=crit.list();
		Iterator it =list.iterator();
		System.out.println("size"+list.size());
		System.out.println("--------------------------------");
		while(it.hasNext()){
			
			Object object= it.next();
			UserRegistration regi = (UserRegistration) object;
			System.out.println(regi.getUserName());
		}*/
	
	}
}
