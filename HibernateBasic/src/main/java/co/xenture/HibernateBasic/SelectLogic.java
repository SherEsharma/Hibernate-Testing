package co.xenture.HibernateBasic;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class SelectLogic {
	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure("co/xenture/HibernateBasic/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		// this code for normal selection operation
		/*Object object =session.get(Product.class, new Integer(1));
		Product p =(Product)object;
		
		System.out.println("Loading Object Name"+p.getProName());*/
	
		
		
		// this code for sql selection operation
	/*	Query query =session.createQuery("select p.productId,p.proName from Product p");
		List list=query.list();
		
		System.out.println("Number of record in db  "+list.size());
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
		
			 
			Object o[] = (Object[])iterator.next();
			System.out.println(o[1]);
		}*/
		
		
		// this code for select using criteria
		
		/*Criteria criteria =session.createCriteria(Product.class);
		
		List list= criteria.list();
		System.out.println("Number of record in db  "+list.size());
		Iterator it =list.iterator();
		while(it.hasNext()){
			Object o = it.next();
			Product p = (Product)o;
			
			System.out.println(p.getProName());
		}*/
		
		//Criteria with some Condition
		
		Criteria criteria =session.createCriteria(Product.class);
		Criterion cn = Restrictions.eq("price",new Double(5500));
		criteria.add(cn);
		List list= criteria.list();
		System.out.println("list "+list.size());
		Iterator it =list.iterator();
		while(it.hasNext()){
			Object object= it.next();
			Product p = (Product) object;
			System.out.println(p.getProName());
		}
	}
}
