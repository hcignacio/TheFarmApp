package com.chickentest.chickentestapp.dto;
 
import java.util.Date;

import com.chickentest.chickentestapp.model.Chicken;

public class EggDTO {
	
	private long id;
	
	private Date creationDate = new Date();
	
	// private Chicken chicken;
	
	private long chickenId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getChickenId() {
		return chickenId;
	}

	public void setChickenId(long chickenId) {
		this.chickenId = chickenId;
	}

	/*
	public Chicken getChicken() {
		return chicken;
	}

	public void setChicken(Chicken chicken) {
		this.chicken = chicken;
	}
	*/
}
