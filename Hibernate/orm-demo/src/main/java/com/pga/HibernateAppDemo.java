package com.pga;

import org.hibernate.*;

public class HibernateAppDemo {
	public static void main(String[] args) throws HibernateException, Exception {
		Transaction tx = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		tx = session.beginTransaction();
		session.persist(new Student(10, "Hibernate-Demo", 90)); // insert into student values(10 ..)
		tx.commit();
	} 
}
