package com.chickentest.chickentestapp.service;

import java.util.List;

import com.chickentest.chickentestapp.dto.EggDTO;
import com.chickentest.chickentestapp.model.Egg;
 
public interface EggService {

	public List<Object> getData();
	
	public EggDTO getEggData(Egg egg);
	
	public EggDTO add(EggDTO eggDTO);
	
	public EggDTO addById(long chickenId);
}
 