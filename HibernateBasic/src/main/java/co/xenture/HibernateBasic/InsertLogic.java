package co.xenture.HibernateBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertLogic {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("co/xenture/HibernateBasic/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.getCurrentSession();
		Product p = new Product();
		//p.setProductId(3);
		p.setProName("Company");
		p.setPrice(1234.33);
		Transaction tx =session.beginTransaction();
		session.save(p);
		//session.persist(p);
		tx.commit();
		
		System.out.println("Done");
	}

}
