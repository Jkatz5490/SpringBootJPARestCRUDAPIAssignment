package com.blit.SpringBootJPARestCRUDAPIAssignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.blit.SpringBootJPARestCRUDAPIAssignment.entity.Tutorial;
import com.blit.SpringBootJPARestCRUDAPIAssignment.repo.TutorialRepository;

@Service // defined as a bean to be injected
public class TutorialServiceImpl2 implements TutorialService {

	@Autowired
	TutorialRepository tutorialRepo;

	@Override
	public Tutorial addTutorial(Tutorial tutorial) {
		System.out.println("ServiceImpl2");
		return tutorialRepo.save(tutorial);
	}

	@Override
	public Tutorial getTutorialById(int tutorialId) {
		Tutorial tutorial = tutorialRepo.getById(tutorialId);
		return tutorial;
	}

	@Override
	public void updateTutorial(Tutorial tutorial) {
		Tutorial tutorialDB = tutorialRepo.findById(tutorial.getTutorialId()).orElseThrow();
		tutorialRepo.save(tutorial);
	}

	@Override
	public void deleteTutorialById(int tutorialId) {
		tutorialRepo.deleteById(tutorialId);

	}

	@Override
	public List<Tutorial> getAllTutorials() {
		return tutorialRepo.findAll();
	}

	@Override
	public List<Tutorial> deleteAllTutorials() {
		tutorialRepo.deleteAll();
		return null;
	}

	@Override
	public List<Tutorial> getAllPublishedTutorials() {

		List<Tutorial> allTuts = tutorialRepo.findAll();
		List<Tutorial> publishedTutorials = new ArrayList<>();
		for (Tutorial x : allTuts) {
			if (x.getPublishedStatus() != null) {
				publishedTutorials.add(x);
			}
		}
		return publishedTutorials;
	}

	@Override
	public List<Tutorial> getAllPublishedTutorialsTitleContains(String title) {
		List<Tutorial> listOfTut = tutorialRepo.findAll();

		List<Tutorial> listwithTitle = new ArrayList<>();

		for (int i = 0; i < listOfTut.size(); i++) {
			Tutorial tut = listOfTut.get(i);

			if (tut.getTitle().contains(title)) {
				listwithTitle.add(tut);
			}
		}
		return listwithTitle;
	}
}