package com.chickentest.chickentestapp.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Farm {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private long id;
	
	private String name;
	
	private Date creationDate = new Date();
	
	@OneToMany(mappedBy = "farm", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private List<Chicken> chickens = new LinkedList<Chicken>();
	
	public Farm() {};
	
	public Farm(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public long getId() {
		return this.id;
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
		return this.creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	} 
	
	public List<Chicken> getChickens() {
		return this.chickens;
	}
	
	public void setChickens(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public void addChicken(Chicken chicken) {
		this.chickens.add(chicken);
	}
	
	public void addChickens(List<Chicken> chickens) {
		this.chickens.addAll(chickens);
	}
	
	public int getChickensAmount() {
		return this.chickens.size();
	}
	
	
	/*
	public int getChickensAmount() {
		int chickensAmountInFarm = 0;
		for(Chicken chicken : this.chickens) {
			if (chicken.getInFarm()==true){
				chickensAmountInFarm++;
			}
		}
		return chickensAmountInFarm;
	}
	*/

	public int getEggsAmountTotal() {
		int eggsAmount = 0;
		for(Chicken chicken : this.chickens) {
			eggsAmount += chicken.getEggsAmount();
		}
		return eggsAmount;
	}

	public void deleteChicken(Chicken chicken){
		//Chicken chickenToDelete = this.chickens.get((int) chicken.getId());
		chickens.remove(chicken);
	}
}

