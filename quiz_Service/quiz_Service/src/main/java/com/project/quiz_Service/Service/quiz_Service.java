package com.project.quiz_Service.Service;

import java.awt.PrintGraphics;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quiz_Service.Dao.quiz_Dao;
import com.project.quiz_Service.Entity.questionsWrapper;
import com.project.quiz_Service.Entity.quiz;
import com.project.quiz_Service.Entity.response;
import com.project.quiz_Service.Feign.quiz_Interface;

@Service
public class quiz_Service {
	
	@Autowired
	quiz_Dao dao;
	
	@Autowired
	quiz_Interface quiz_Interface;
	
	public quiz createQuiz(String category, String title, int numQ) {
			
		List<Integer> questions = quiz_Interface.getQuestionsForQuiz(category).getBody();
		
		quiz quiz = new quiz();
		
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		dao.save(quiz);
		
		return quiz;
	}
	
	public List<questionsWrapper> getQuestions(int id) {
		
		quiz q = dao.findById(id).get();
		
	
		List<questionsWrapper> questionsWrappers = quiz_Interface.getQuestions(q.getQuestions()).getBody();
				
		return questionsWrappers;
		
		
	}

	public ResponseEntity<Integer> getResult(List<response> response) {
		
		return quiz_Interface.getScore(response);
	}
	
}
