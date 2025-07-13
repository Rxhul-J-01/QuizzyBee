package com.project.quiz_Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.quiz_Service.Entity.questionsWrapper;
import com.project.quiz_Service.Entity.quiz_DTO;
import com.project.quiz_Service.Entity.response;
import com.project.quiz_Service.Service.quiz_Service;

@Controller
@RequestMapping("quiz")
public class quiz_Controller {
	
	@Autowired
	quiz_Service service;
	
	@PostMapping("createQuiz")
	public ResponseEntity<String> createQuiz(@RequestBody quiz_DTO dto){
		
		service.createQuiz(dto.getCategory(),dto.getTitle(),dto.getNumQ());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success");
	}
	
	@GetMapping("getQuestions/{id}")
	public ResponseEntity<List<questionsWrapper>> getQuestions(@PathVariable int id){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getQuestions(id));
	}
	
	@PostMapping("submit")
	public ResponseEntity<Integer> getResult(@RequestBody List<response> response){
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getResult(response)).getBody();
	}
}
