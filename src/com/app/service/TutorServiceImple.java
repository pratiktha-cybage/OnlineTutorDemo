package com.app.service;

import com.app.dao.TutorDaoImple;
import com.app.dto.Tutors;

public class TutorServiceImple implements TutorService {
	
	TutorDaoImple tutorDao;
	
	
	public TutorServiceImple() {
		
		tutorDao =  new TutorDaoImple();
	}


	@Override
	public boolean savetutor(Tutors tutor) {
		return tutorDao.regTutor(tutor);
	}
	
}
