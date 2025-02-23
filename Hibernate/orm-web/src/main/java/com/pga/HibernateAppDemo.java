package com.pga;

import org.hibernate.*;

import jakarta.persistence.TypedQuery;

import java.util.*;
public class HibernateAppDemo {
	public static void main(String[] args) throws HibernateException, Exception {
		Transaction tx = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
//		tx = session.beginTransaction();
//		session.persist(new Student(10, "Hibernate-Demo", 90)); // insert into student values(10 ..)
//		tx.commit();
		tx = session.beginTransaction();
        Student s = (Student)session.get(Student.class, 10); 
        session.delete(s);
        tx.commit();
		TypedQuery<Student> tq = session.createQuery("FROM com.pga.Student");
		List<Student> students = tq.getResultList();
		System.out.println(students);
	}
}
