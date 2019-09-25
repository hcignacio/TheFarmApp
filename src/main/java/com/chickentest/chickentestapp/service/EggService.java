package com.chickentest.chickentestapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Egg;

public interface EggService {

	public List<Object> getData();
	
	public Egg getEggData(Egg egg);
}
