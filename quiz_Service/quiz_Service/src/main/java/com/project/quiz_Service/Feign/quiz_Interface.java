package com.project.quiz_Service.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.quiz_Service.Entity.questionsWrapper;
import com.project.quiz_Service.Entity.response;


@FeignClient("QUESTION-SERVICE")
public interface quiz_Interface {

	@PostMapping("Question/createQuiz/{category}")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@PathVariable String category);
	

	@PostMapping("Question/getQuestions")
	public ResponseEntity<List<questionsWrapper>> getQuestions(@RequestBody List<Integer> list);
	
	@PostMapping("Question/getScore")
	public ResponseEntity<Integer> getScore(List<response> responses);
}
