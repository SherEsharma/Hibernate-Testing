package co.xenture.HibernateBasic;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateLogic {
public static void main(String[] args) {
	Configuration cfg= new Configuration().configure("co/xenture/HibernateBasic/hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session session= factory.openSession();
	Object object = session.get(Product.class, new Integer(5));
	Product p = (Product) object;
	
	System.out.println("Data loading   "+p.getProName());
	
	Transaction tx =session.beginTransaction();
/*	p.setProName("Mouse");
	session.update(p);
	tx.commit();
	System.out.println("After updating Data");
	System.out.println("Data loading   "+p.getProName());*/
	
	Query query=session.createQuery("update Product p set p.proName=? where p.productId=:id");
	query.setParameter(0, "shubham");
	query.setParameter("id", 5);
	int result=query.executeUpdate();
	System.out.println("Updated the data");
	session.close();
	factory.close();
}
}
