package com.app.service;

import com.app.dao.AdminDaoImple;

public class AdminServiceImple implements AdminService {
	AdminDaoImple adminDao;
	
	
	
	public AdminServiceImple() {
		
		adminDao =  new AdminDaoImple();
	}



	public int ActivateUser(String userEmail, String userPass) {
		// TODO Auto-generated method stub
		return adminDao.ActivateUser(userEmail, userPass) ;
	}

}
