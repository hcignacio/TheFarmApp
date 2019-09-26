package com.chickentest.chickentestapp.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.chickentest.chickentestapp.repository.ChickenRepository;
//import java.util.LinkedList;
//import java.util.List;

//import com.chickentest.chickentestapp.model.Egg;
//import com.chickentest.chickentestapp.model.Farm;

public class ChickenDTO {
	
	@Autowired
	ChickenRepository chickenRepository;

	private long id;
	
	private Date joinDate = new Date();

	private boolean inFarm = true;
	
	// private List<Egg> eggs = new LinkedList<Egg>();
	
	// private Farm farm;
	
	private long farmId;
	
	private String name;
	
	private int eggsAmount;
	
	public ChickenDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public boolean getInFarm() {
		return inFarm;
	}

	public void setInFarm(boolean inFarm) {
		this.inFarm = inFarm;
	}

	/*
	public List<Egg> getEggs() {
		return eggs;
	}

	public void setEggs(List<Egg> eggs) {
		this.eggs = eggs;
	}
	*/

	/*
	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	*/
	
	public long getFarmId() {
		return farmId;
	}

	public void setFarmId(long farmId) {
		this.farmId = farmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEggsAmount() {
		// REPOSITORY
		
		return eggsAmount;
	}

	public void setEggsAmount(int eggsAmount) {
		this.eggsAmount = eggsAmount;
	}	
}
