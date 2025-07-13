package com.Project.Question_Service.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Project.Question_Service.Entity.questions;


public interface Question_Dao extends JpaRepository<questions, Integer>{@Override
default long count() {
	// TODO Auto-generated method stub
	return 0;
}

//@Query(value = "SELECT * FROM questions q WHERE q.category = :category/", nativeQuery = true)
List<questions> findByCategory(String category);

@Query(value = "Select q.id from questions q where q.category = :category ORDER BY RAND() LIMIT 5")
List<Integer> createQuiz(String category);

}
