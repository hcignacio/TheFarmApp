package com.chickentest.chickentestapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Farm;

@Service
public interface FarmService {
	
	public List<Object> getData();
	
	public Farm getFarmData(Farm farm);

}
