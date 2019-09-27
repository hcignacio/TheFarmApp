package com.chickentest.chickentestapp.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Chicken {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private long id;
	
	private Date joinDate = new Date();

	private boolean inFarm = true;
	
	@OneToMany(mappedBy = "chicken", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private List<Egg> eggs = new LinkedList<Egg>();
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "farmId")
	private Farm farm;
	
	private String name;
	
	public Chicken() {};
	
	public Chicken(Farm farm) {
		this.farm = farm;
		this.inFarm = true;
	}

	public Chicken(Farm farm, List<Egg> eggs) {
		this.farm = farm;
		this.eggs = eggs;
		this.inFarm = true;
	}
	
	public Chicken(List<Egg> eggs, boolean inFarm) {
		this.eggs = eggs;
		this.inFarm = inFarm;
	}
	
	
	public Chicken(Farm farm, String name) {
		super();
		this.farm = farm;
		this.inFarm = true;
		this.name = name;
	}

	// id
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	// joinDate
	public Date getJoinDate() {
		return this.joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	} 
	
	// farm
	@JsonIgnore
	public Farm getFarm() {
		return this.farm;
	}
	
	public void setFarm(Farm farm) {
		this.farm = farm;
	} 
	
	
	// inFarm
	public boolean getInFarm(){
		return this.inFarm;
	}

	public void setInFarm(Boolean inFarm) {
		this.inFarm = inFarm;
	}

	// eggs
	public List<Egg> getEggs() {
		return this.eggs;
	}
	
	public void setEggs(List<Egg> eggs) {
		this.eggs = eggs;
	}
	
	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Other Methods
	public void addEggs(List<Egg> eggs) {
		this.eggs.addAll(eggs);
	}
	
	public void addEgg(Egg egg) {
		this.eggs.add(egg);
	}
	
	public int getEggsAmount() {
		return this.eggs.size();
	}
}
