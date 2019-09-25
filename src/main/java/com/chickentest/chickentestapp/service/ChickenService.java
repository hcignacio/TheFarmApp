package com.chickentest.chickentestapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.model.Chicken;

public interface ChickenService {
	
	public List<Object> getChickens();
	
	public ChickenDTO getChickenData(Chicken chicken);
	
	public ChickenDTO add(ChickenDTO chickenDTO);
	
	public ChickenDTO delete(ChickenDTO chickenDTO);
}