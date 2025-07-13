package com.Project.Question_Service.Controller;

import java.lang.invoke.CallSite;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.ServiceConfigurationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.resource.ResourceHandlerUtils;

import com.Project.Question_Service.Service.Question_Service;
import com.Project.Question_Service.Entity.questions;
import com.Project.Question_Service.Entity.questionsWrapper;
import com.Project.Question_Service.Entity.response;

import aj.org.objectweb.asm.commons.SerialVersionUIDAdder;

@Controller
@RequestMapping("Question")
public class Ques_Controller {
	
	
	@Autowired
	Question_Service service;
	
	@GetMapping("AllQuestions")
	public ResponseEntity<List<questions>> getAllQuestions(){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAllQuestions());
	}
	
	@GetMapping("Category/{category}")
	public ResponseEntity<List<questions>> getQuestionsByCategory(@PathVariable String category){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getQuestionsByCategory(category));
	}
	
	@PostMapping("add")
	public ResponseEntity<questions> addQuestion(@RequestBody questions ques){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createQuestion(ques));
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<questions> byid(@PathVariable int id) {
	    
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.byid(id).get());
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQues(@PathVariable int id){
	    service.deleteById(id);
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}
	
	
	//generate
	
	@PostMapping("createQuiz/{category}")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@PathVariable String category){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.createQuiz(category));
	}
	
	//getQuestions (By id)
	@PostMapping("getQuestions")
	public ResponseEntity<List<questionsWrapper>> getQuestions(@RequestBody List<Integer> list){
		
		
	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getQuestionsForQuiz(list));
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<response> responses){ 
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getScore(responses));
	}
}
