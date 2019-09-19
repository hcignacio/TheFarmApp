package com.chickentest.chickentestapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.FarmRepository;

@Service
public class FarmService{
	
	@Autowired
    private FarmRepository farmRepository;
	   
    public List<Object> getData(){
    	return farmRepository
    			.findAll()
    			.stream()
    			.map(farm -> getFarmData(farm))
    			.collect(Collectors.toList());
    }
    
    public Farm getFarmData(Farm farm){
    	Farm currentFarm = farmRepository.findById(farm.getId()).get();;
    	return currentFarm;
    }

}
