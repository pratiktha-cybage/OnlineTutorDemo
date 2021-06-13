package com.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.service.AdminServiceImple;



@WebServlet("/AccountActivate")
public class AccountActivate extends HttpServlet {
	AdminServiceImple adminService;
	
	
	
	public AccountActivate() {
		
		adminService = new AdminServiceImple();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("key1");
		String hash = request.getParameter("key2");
		int result = adminService.ActivateUser(email, hash);
		if(result == 0) {
			System.out.println("not updated");
		}
		else {
			System.out.println("updated status ");
		}
		
	}

}