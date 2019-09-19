package com.chickentest.chickentestapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.repository.ChickenRepository;

@Service
public class ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    public List<Object> getData(){
    	return chickenRepository
    			.findAll()
    			.stream()
    			.map(chicken -> getChickenData(chicken))
    			.collect(Collectors.toList());
    }
    
    public Chicken getChickenData(Chicken chicken){
    	Chicken currentChicken = chickenRepository.findById(chicken.getId()).get();
    	return currentChicken;
    }
	
}
