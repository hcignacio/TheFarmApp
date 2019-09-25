package com.chickentest.chickentestapp.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chickentest.chickentestapp.model.Egg;
import com.chickentest.chickentestapp.repository.EggRepository;
import com.chickentest.chickentestapp.service.EggService;

@Service
public class EggServiceImpl implements EggService{
	
	@Autowired
	private EggRepository eggRepository;

    @RequestMapping(path = "/eggs", method = RequestMethod.GET)
    public List<Object> getData(){
    	return eggRepository
    			.findAll()
    			.stream()
    			.map(egg -> getEggData(egg))
    			.collect(Collectors.toList());
    }
    
    public Egg getEggData(Egg egg){
    	Egg currentEgg = eggRepository.findById(egg.getId()).get();
   
    	return currentEgg;
    }  
	
}
