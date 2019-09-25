package com.chickentest.chickentestapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Egg {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private long id;
	
	private Date creationDate = new Date();
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chickenId")
	private Chicken chicken;
	
	public Egg() {};

	public Egg(Chicken chicken) {
		this.chicken = chicken;
	};
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCreationDate() {
		return this.creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	} 
	
	@JsonIgnore
	public Chicken getChicken() {
		return this.chicken;
	}
	
	public void setChicken(Chicken chicken) {
		this.chicken = chicken;
	}
}