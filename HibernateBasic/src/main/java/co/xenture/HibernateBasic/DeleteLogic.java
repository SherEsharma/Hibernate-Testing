package co.xenture.HibernateBasic;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteLogic {
	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure("co/xenture/HibernateBasic/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		//Basic Delete operation
		/*Transaction tx =session.beginTransaction();
		Object object = session.get(Product.class, new Integer(6));
		Product p =(Product) object;
		
		session.delete(p);
		tx.commit();*/
		
		// using HQL Operation
		
		Query query = session.createQuery("delete from Product p where p.productId=:productid");
		query.setParameter("productid",1);
		int result=query.executeUpdate();
		System.out.println("done"+"   "+result);
	}

}
