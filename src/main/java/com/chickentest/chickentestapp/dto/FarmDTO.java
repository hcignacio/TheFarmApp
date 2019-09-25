package com.chickentest.chickentestapp.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.chickentest.chickentestapp.model.Chicken;

public class FarmDTO {
	
	private long id;
	
	private String name;
	
	private Date creationDate = new Date();
	
	private List<Chicken> chickens = new LinkedList<Chicken>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Chicken> getChickens() {
		return chickens;
	}

	public void setChickens(List<Chicken> chickens) {
		this.chickens = chickens;
	}
}
