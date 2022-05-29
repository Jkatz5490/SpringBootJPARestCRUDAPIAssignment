package com.blit.SpringBootJPARestCRUDAPIAssignment.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUTORIAL")
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int tutorialId;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PUBLISHEDSTATUS")
	private String publishedStatus;
	
	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublishedStatus() {
		return publishedStatus;
	}
	public void setPublishedStatus(String publishedStatus) {
		this.publishedStatus = publishedStatus;
	}
	@Override
	public String toString() {
		return "tutorialId=" + getTutorialId() + ", title=" + getTitle() + ", description=" + getDescription()
				+ ", publishedStatus=" + getPublishedStatus() + "]";
	}
	
	
	
	
}
