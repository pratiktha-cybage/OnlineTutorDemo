package com.app.service;

import com.app.dao.StudentDaoImple;
import com.app.dto.Students;

public class StudentServiceImple implements StudentService {
	StudentDaoImple studentDao= new StudentDaoImple();
	
	public boolean saveStudent(Students student) {
		return studentDao.RegStudent(student);
	}
	
}
