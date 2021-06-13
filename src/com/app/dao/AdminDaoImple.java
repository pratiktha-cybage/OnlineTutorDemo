package com.app.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.hibernateUtility.HibernateUtil;

public class AdminDaoImple implements AdminDao{
	SessionFactory hbSession = HibernateUtil.getSessionInstance();;
	
	public int ActivateUser(String userEmail, String userPass) {hbSession.openSession();
	
		Session session  = hbSession.openSession();
		Transaction tx2 = session.beginTransaction();
		int i=0;
		try {
			SQLQuery query = session.createSQLQuery("SELECT student_email,student_pwd,status FROM students WHERE student_email=:userMail AND student_pwd=:userPass AND status='0'");
			query.setParameter("userMail", userEmail);
			query.setParameter("userPass", userPass);
			List<Object []>rows =  query.list();
			if(rows.size()>0) {
				SQLQuery query2 = session.createSQLQuery("UPDATE students SET status='1' WHERE student_email=:userMail AND student_pwd=:userPass");
				query2.setParameter("userMail", userEmail);
				query2.setParameter("userPass", userPass);
				i =query2.executeUpdate();
				
			}
			tx2.commit();
			
		}
		catch(Exception e) {
			tx2.rollback();
			System.out.println("Account activation failed"+e);
		}
		finally {
			session.close();
		}
		return i;		
	}

}
