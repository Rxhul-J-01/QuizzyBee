package com.Project.Question_Service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public class questions {
	
	@Id
    private int id;

    private String category;

    private String difficultylevel;

    private String option1;

    private String option2;

    private String option3;

    private String question_title;

    private String right_answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficultylevel() {
		return difficultylevel;
	}

	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getRight_answer() {
		return right_answer;
	}

	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}

	public questions(int id, String category, String difficultylevel, String option1, String option2, String option3,
			String question_title, String right_answer) {
		super();
		this.id = id;
		this.category = category;
		this.difficultylevel = difficultylevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.question_title = question_title;
		this.right_answer = right_answer;
	}

	public questions() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
