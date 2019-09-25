package com.chickentest.chickentestapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Farm;

public interface FarmService {
	
	public List<Object> getData();
	
	public Farm getFarmData(Farm farm);
}
