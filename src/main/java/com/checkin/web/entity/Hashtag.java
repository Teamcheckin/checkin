package com.checkin.web.entity;

public class Hashtag {
	
	private Integer id;
	private String name;
	
public Hashtag() {
	// TODO Auto-generated constructor stub
}
	public Hashtag(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", name=" + name + "]";
	}

	
}
