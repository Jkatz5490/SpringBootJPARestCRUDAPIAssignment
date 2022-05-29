package com.blit.SpringBootJPARestCRUDAPIAssignment.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blit.SpringBootJPARestCRUDAPIAssignment.entity.Tutorial;
import com.blit.SpringBootJPARestCRUDAPIAssignment.exception.TutorialNotFoundException;
import com.blit.SpringBootJPARestCRUDAPIAssignment.service.TutorialService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/tutorial")
public class TutorialController {

	@Autowired
	@Qualifier("tutorialServiceImpl2")
	TutorialService tutorialService;

	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	public Tutorial addTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.addTutorial(tutorial);
	}

	@GetMapping("/getAllPublishedTutorials") /* get if publishedStatus = "published" (not working) */
	public List<Tutorial> getAllPublishedTutorial() {
		return tutorialService.getAllPublishedTutorials();
	}

	@GetMapping("/getAllPublishedTutorialsContains")
	public List<Tutorial> getAllPublishedTutorialsContains(@RequestParam("title") String title) {
		return tutorialService.getAllPublishedTutorialsTitleContains(title);

	}

	@GetMapping("/getAllTutorials")
	public List<Tutorial> getAllTutorial() {
		return tutorialService.getAllTutorials();
	}

	// delete all
	@DeleteMapping("/deleteAllTutorials")
	public List<Tutorial> deleteAllTutorial() {
		return tutorialService.deleteAllTutorials();
	}

	@GetMapping("/{id}")
	public Tutorial getTutorialById(@PathVariable("id") int tutorialId) throws TutorialNotFoundException {
		if(tutorialService.getTutorialById(tutorialId) != null)
			return tutorialService.getTutorialById(tutorialId);
		else
			throw new TutorialNotFoundException("tutorial not found with id " + tutorialId);
	}

	@PutMapping("/updateTutorial")
	public ResponseEntity<String> updateTutorial(@RequestBody Tutorial tutorial) {
		try {
			tutorialService.updateTutorial(tutorial);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTutorial(@PathVariable int id) {
		try {
			tutorialService.deleteTutorialById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	/* still need: get all which contain keyword */

}
