package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.app.dao.StudentDao;
import com.app.dao.StudentDaoImple;
import com.app.dto.SendEmail;
import com.app.dto.Students;
import com.app.dto.Tutors;
import com.app.service.StudentServiceImple;
import com.app.service.TutorServiceImple;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentServiceImple studentServiceImple;
    private TutorServiceImple tutorServiceImple;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		studentServiceImple = new StudentServiceImple();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("studentReg")) {
			System.out.println("in register");
			registerStudent(request,response);
		}
		else if(action.equals("tutorReg")																																																																																																																																																																																																																																																																																																																																																																																																																																																								) {
			registerTutor(request,response);
		}
		
		System.out.println("end");
	}
	
	private void registerStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Students student = new Students();
		String userMail = request.getParameter("studentMail");
		String hashPwd = hashPassword(request.getParameter("studentPwd"));
		student.setStudentName(request.getParameter("studentName"));
		student.setStudentMail(userMail);
		student.setStudentPwd(hashPwd);
		student.setStatus("pending");
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		
		
		student.setJoinedAt(sqlTime+"");
		System.out.println("in register");
		boolean isReg = studentServiceImple.saveStudent(student);
		if(isReg) {
			SendEmail se = new SendEmail(userMail,hashPwd);
			se.sendMail();
			RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
	        dispatcher.forward(request, response);
		}
	}
	
	private void registerTutor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Tutors tutor = new Tutors();
		tutor.setTutorName(request.getParameter("tutorName"));
		tutor.setTutorEmail(request.getParameter("tutorMail"));
		tutor.setTutorPwd(hashPassword(request.getParameter("tutorPwd")));
		tutor.setTutorEducation(request.getParameter("tutorEducation"));
		tutor.setTutorProfesion(request.getParameter("tutorProfession"));
		tutor.setTutorDesc(request.getParameter("tutorDesc"));
		tutor.setStatus("0");
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		
		
		tutor.setJoinedAt(sqlTime+"");
		System.out.println("in register Tutor");
		boolean isReg = tutorServiceImple.savetutor(tutor);
		if(isReg) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
	        dispatcher.forward(request, response);
		}
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	

}
