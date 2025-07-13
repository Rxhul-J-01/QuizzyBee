package com.project.quiz_Service.Entity;

public class quiz_DTO {

	private String category;
	private String title;
	private int numQ;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumQ() {
		return numQ;
	}
	public void setNumQ(int numQ) {
		this.numQ = numQ;
	}
	public quiz_DTO(String category, String title, int numQ) {
		super();
		this.category = category;
		this.title = title;
		this.numQ = numQ;
	}
	public quiz_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "quiz_DTO [category=" + category + ", title=" + title + ", numQ=" + numQ + "]";
	}
	
	
}
