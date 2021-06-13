package com.app.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "Students")
public class Students implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
 
    @Column(name = "student_name", nullable = false)
    private String studentName;
 
    @Column(name = "student_email", nullable = false)
    private String studentMail;
    
    @Column(name = "student_pwd", nullable = false)
    private String studentPwd;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "joined_at", nullable = false)
    private String joinedAt;
 
    @OneToMany(mappedBy = "students")
    private Set<StudentTutorMapping> StudentTutorMap = new HashSet<StudentTutorMapping>();
    
    
  
   
	public Set<StudentTutorMapping> getStudentTutorMap() {
		return StudentTutorMap;
	}



	public void setStudentTutorMap(Set<StudentTutorMapping> studentTutorMap) {
		StudentTutorMap = studentTutorMap;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getStudentMail() {
		return studentMail;
	}



	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}



	public String getStudentPwd() {
		return studentPwd;
	}



	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Students))
            return false;
        Students other = (Students) obj;
        if (studentId != other.studentId)
            return false;
        return true;
    }
	
	 @Override
		public String toString() {
			return "Student [id=" + studentId + ", userName=" + studentName + ", userEmail=" + studentMail + ", userPwd=" + studentPwd
					+ ", userRole=" + ", status=" + status + ", joinedAt=" + joinedAt + "]";
		}
    
}