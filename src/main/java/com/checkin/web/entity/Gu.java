package com.checkin.web.entity;

public class Gu {

	private Integer id;
	private String name;
	private String img;
	
	public Gu(Integer id, String name, String img) {
		
		this.id = id;
		this.name = name;
		this.img = img;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Gu [id=" + id + ", name=" + name + ", img=" + img + "]";
	}
	
	
	
	
}
