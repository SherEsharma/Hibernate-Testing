package co.xenture.HibernateBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CompositeKeyLogic {
	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure("co/xenture/HibernateBasic/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User user= new User();
		user.setUserid(2);
		user.setUsername("pradeep");
		user.setUseremail("s.sharma@xenture.co");
		user.setPassword("12345");
		session.save(user);
		tx.commit();
		System.out.println("Done");
	}
}
