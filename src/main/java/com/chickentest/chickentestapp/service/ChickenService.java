package com.chickentest.chickentestapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Chicken;

@Service
public interface ChickenService {
	
	public List<Object> getData();
	
	public Chicken getChickenData(Chicken chicken);

}
