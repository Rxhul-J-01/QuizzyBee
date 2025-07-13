package com.Project.Question_Service.Service;

import java.nio.channels.WritePendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Question_Service.Dao.Question_Dao;
import com.Project.Question_Service.Entity.questions;
import com.Project.Question_Service.Entity.questionsWrapper;
import com.Project.Question_Service.Entity.response;

import jakarta.transaction.Transactional;

@Service
public class Question_Service {
	
	@Autowired
	Question_Dao dao;

	public questions createQuestion(questions ques) {
		
		dao.save(ques);
		
		return ques;
	}

	public List<questions> getAllQuestions() {
	
		return dao.findAll();
	}

	public List<questions> getQuestionsByCategory(String category) {
		
		
		return dao.findByCategory(category);
	}

	public Optional<questions> byid(int id) {
		
		return dao.findById(id);
	}
	
	@Transactional
	public void  deleteById(int id) {
		
	    dao.deleteById(id);
	}

	//create Quiz
	public List<Integer> createQuiz(String category) {
		
		
		return dao.createQuiz(category);
	}

	//getQuestions
	public List<questionsWrapper> getQuestionsForQuiz(List<Integer> ids) {
		
		List<questions> questions = new ArrayList<>();
		List<questionsWrapper> wrappers = new ArrayList<>();
		for(Integer id : ids) {
			questions.add(dao.findById(id).get());
		}
		
		for(questions q : questions) {
			questionsWrapper wrapper = new questionsWrapper();
			wrapper.setId(q.getId());
			wrapper.setQuestionTitle(q.getQuestion_title());
			wrapper.setOption1(q.getOption1());
			wrapper.setOption2(q.getOption2());
			wrapper.setOption3(q.getOption3());
			
			wrappers.add(wrapper);
		}
		
		return wrappers;
	} 
	
	//getScore
	public int getScore(List<response> responses) {
		
		int right = 0;
		
		for(response r : responses) {
			questions q = dao.findById(r.getId()).get();
			if(r.getResponse().equals(q.getRight_answer())) {
				right++;
			}
		}
		
		return right;
	}
	
}
