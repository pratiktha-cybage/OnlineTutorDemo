package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.dto.Students;
import com.app.hibernateUtility.HibernateUtil;

public class StudentDaoImple implements StudentDao {
	 SessionFactory hbSession = HibernateUtil.getSessionInstance();
	 
	@Override
	public boolean RegStudent(Students student) {
		// TODO Auto-generated method stub
		boolean response = true;
		Session session  = hbSession.openSession();
		Transaction tx2 = session.beginTransaction();
		
		try {
			session.save(student);
			tx2.commit();
		
		}
		catch(Exception e) {
			tx2.rollback();
			response = false;
			e.printStackTrace();
		}
		finally {
			hbSession.close();
		}
		
		return response;
	}

}
