package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
    
	
	@GetMapping("/surveys/{surveyId}/questions" )
	public List<Question> getQuestions(@PathVariable String surveyId) {

		return surveyService.retrieveQuestions(surveyId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionToSurvey(@PathVariable String surveyId, 
			@RequestBody Question question) {
     
		if(question == null)
		{
			return ResponseEntity.noContent().build();
		}
		else {
			
			surveyService.addQuestion(surveyId, question);
			URI newQuetion = ServletUriComponentsBuilder.
					fromCurrentRequest().path("/{id}").
					buildAndExpand(question.getId()).toUri();
			
			return ResponseEntity.created(newQuetion).build();
		}
 	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question getQuestion(@PathVariable String surveyId,
			@PathVariable String questionId/* , @RequestParam String name */) {
		//System.out.println(name);
		return surveyService.retrieveQuestion(surveyId, questionId);
	}

}
