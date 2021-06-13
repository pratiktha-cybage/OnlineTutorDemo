package com.app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="training_material")
public class TrainingMaterial {
	
	@Id
	@Column(name="material_id",nullable = false)
	private int materialId;
	
	@Column(name="material_title",nullable = false)
	private String materialTitle;
	
	@Column(name="material_og_name",nullable = false)
	private String materialOgName;
	
	@Column(name="content_name",nullable = false)
	private String contentName;
	
	@Column(name="content_type",nullable = false)
	private String contentType;
	
	@Column(name="created_at",nullable = false)
	private String createdAt;
	
	@Column(name="modified_at",nullable = false)
	private String modifiedAt;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name ="tutor_id")
	private Tutors tutor;

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialTitle() {
		return materialTitle;
	}

	public void setMaterialTitle(String materialTitle) {
		this.materialTitle = materialTitle;
	}

	public String getMaterialOgName() {
		return materialOgName;
	}

	public void setMaterialOgName(String materialOgName) {
		this.materialOgName = materialOgName;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Tutors getTutor() {
		return tutor;
	}

	public void setTutor(Tutors tutor) {
		this.tutor = tutor;
	}

	
	@Override
	public String toString() {
		return "TrainingMaterial [materialId=" + materialId + ", materialTitle=" + materialTitle + ", materialOgName="
				+ materialOgName + ", contentName=" + contentName + ", contentType=" + contentType + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + ", categoryId=" + category + ", tutor=" + tutor + "]";
	}
	
	
	
}
