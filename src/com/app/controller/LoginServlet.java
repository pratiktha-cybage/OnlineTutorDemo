package com.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = request.getParameter("roleType");
		String result;
		if(role.equals("admin")) {
			 result = validateAdmin(request,response);
		}
		else if(role.equals("student")) {
			result = validateStudent(request,response);
		}
		else {
			result = validateTutor(request,response);
		}
		doGet(request, response);
	}
	
	private String validateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
		
		
	}
	
	private String validateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
		
		
	}

	private String validateTutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	
	
	}
	
	public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
