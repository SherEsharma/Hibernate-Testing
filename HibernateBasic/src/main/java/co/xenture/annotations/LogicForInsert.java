package co.xenture.annotations;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.xenture.HibernateBasic.Product;

public class LogicForInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("co/xenture/annotations/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		UserRegistration user= new UserRegistration();
		//user.setUserId(3);
		user.setUserName("pradeep");
		user.setUserPassword("12345");
		
		session.persist(user);
		tx.commit();
		
		
		//here is sql
		/*String sql = "insert into user_registration (userId, userName, userPassword) values (?,?,?); ";
		Query query= session.createQuery(sql);
		
		
		SQLQuery query =session.createSQLQuery(sql);
		query.setParameter(0, 1);
		query.setParameter(1, "shubham");
		query.setParameter(2, "password");
		int res=query.executeUpdate();
		System.out.println(res + "  Data insert");
		*/
		System.out.println("Done");
		
	}
}
