package com.app.dto;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tutors")
public class Tutors {
		
	@Id
	@Column(name="tutor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tutorId;
	
	@Column(name = "tutor_name", nullable = false)
    private String tutorName;
 
    @Column(name = "tutor_email", nullable = false)
    private String tutorEmail;
    
    @Column(name = "tutor_pwd", nullable = false)
    private String tutorPwd;
    
    @Column(name = "tutor_education", nullable = false)
    private String tutorEducation;
    
    @Column(name = "tutor_profession", nullable = false)
    private String tutorProfesion;
    
    @Column(name = "tutor_desc", nullable = false)
    private String tutorDesc;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "joined_at", nullable = false)
    private String joinedAt;
    
    @OneToMany(mappedBy = "tutors")
    private Set<StudentTutorMapping> StudentTutorMap = new HashSet<StudentTutorMapping>();
    
    @OneToMany(mappedBy = "tutor")
    private Set<TrainingMaterial> trainingMaterials = new HashSet<TrainingMaterial>();
    
    @OneToMany(mappedBy = "tutors")
    private Set<Category> categories = new HashSet<Category>();
    
	public int getTutorId() {
		return tutorId;
	}


	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}


	public String getTutorName() {
		return tutorName;
	}


	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}


	public String getTutorEmail() {
		return tutorEmail;
	}


	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}


	public String getTutorPwd() {
		return tutorPwd;
	}


	public void setTutorPwd(String tutorPwd) {
		this.tutorPwd = tutorPwd;
	}


	public String getTutorEducation() {
		return tutorEducation;
	}


	public void setTutorEducation(String tutorEducation) {
		this.tutorEducation = tutorEducation;
	}


	public String getTutorProfesion() {
		return tutorProfesion;
	}


	public void setTutorProfesion(String tutorProfesion) {
		this.tutorProfesion = tutorProfesion;
	}


	public String getTutorDesc() {
		return tutorDesc;
	}


	public void setTutorDesc(String tutorDesc) {
		this.tutorDesc = tutorDesc;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getJoinedAt() {
		return joinedAt;
	}


	public void setJoinedAt(String joinedAt) {
		this.joinedAt = joinedAt;
	}


	@Override
	public String toString() {
		return "Tutors [tutorId=" + tutorId + ", tutorName=" + tutorName + ", tutorEmail=" + tutorEmail + ", tutorPwd="
				+ tutorPwd + ", tutorEducation=" + tutorEducation + ", tutorProfesion=" + tutorProfesion
				+ ", tutorDesc=" + tutorDesc + ", status=" + status + ", joinedAt=" + joinedAt + "]";
	}
	 
	
	
	
}
