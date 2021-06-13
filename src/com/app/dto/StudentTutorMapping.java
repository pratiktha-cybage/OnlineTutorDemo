package com.app.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentTutorMapping {
	
	@Id
	@GeneratedValue
	@Column(name="student_tutor_id")
	private int studentTutorId;
	
	 @ManyToOne
	 @JoinColumn(name="student_id")
	 private Students students;
	 
	 @ManyToOne
	 @JoinColumn(name = "tutorials_id")
	 private Tutors tutors;
	 
	 @Column(name="stu_tut_status")
	 private int stuTutStatus;
	 
	 @Column(name="stu_tut_created_at")
	 private String stuTutCreatedAt;

	public int getStudentTutorId() {
		return studentTutorId;
	}

	public void setStudentTutorId(int studentTutorId) {
		this.studentTutorId = studentTutorId;
	}

	public Students getStudent() {
		return students;
	}

	public void setStudent(Students student) {
		this.students = student;
	}

	public Tutors getTutors() {
		return tutors;
	}

	public void setTutors(Tutors tutors) {
		this.tutors = tutors;
	}

	public int getStuTutStatus() {
		return stuTutStatus;
	}

	public void setStuTutStatus(int stuTutStatus) {
		this.stuTutStatus = stuTutStatus;
	}

	public String getStuTutCreatedAt() {
		return stuTutCreatedAt;
	}

	public void setStuTutCreatedAt(String stuTutCreatedAt) {
		this.stuTutCreatedAt = stuTutCreatedAt;
	}
	 
	 
	
}
