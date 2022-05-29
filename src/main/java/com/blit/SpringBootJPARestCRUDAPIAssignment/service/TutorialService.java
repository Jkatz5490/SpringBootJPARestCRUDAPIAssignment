package com.blit.SpringBootJPARestCRUDAPIAssignment.service;

import java.util.List;

import com.blit.SpringBootJPARestCRUDAPIAssignment.entity.Tutorial;

public interface TutorialService {
	Tutorial addTutorial(Tutorial tutorial);
	Tutorial getTutorialById(int tutorialId);
	void updateTutorial(Tutorial tutorial);
	void deleteTutorialById(int tutorialId);
	List<Tutorial> deleteAllTutorials();
	List<Tutorial> getAllTutorials();
	List<Tutorial> getAllPublishedTutorials();
	List<Tutorial> getAllPublishedTutorialsTitleContains(String title);

}
