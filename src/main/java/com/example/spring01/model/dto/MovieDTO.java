package com.example.spring01.model.dto;

public class MovieDTO {
	
	private int id;
	private String name;
	private String information;
	private String image;
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MovieDTO() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", name=" + name + ", information=" + information + ", image=" + image
				+ ", content=" + content + "]";
	}
	
	
}
