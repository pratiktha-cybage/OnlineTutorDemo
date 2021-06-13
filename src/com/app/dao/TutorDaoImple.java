package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.dto.Tutors;
import com.app.hibernateUtility.HibernateUtil;

public class TutorDaoImple implements TutorDao{
	SessionFactory hbSession = HibernateUtil.getSessionInstance();;
	
	@Override
	public boolean regTutor(Tutors tutor) {
		
		// TODO Auto-generated method stub
				boolean response = true;
				System.out.println("1");
				Session session  = hbSession.openSession();
				System.out.println("2");
				Transaction tx2 = session.beginTransaction();
				System.out.println("3");
				
				try {
					session.save(tutor);
					System.out.println("Tutor Data Added");
					tx2.commit();
					System.out.println("*****");
				
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
