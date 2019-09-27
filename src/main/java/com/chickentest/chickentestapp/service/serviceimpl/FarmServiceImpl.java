package com.chickentest.chickentestapp.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.dto.FarmDTO;
import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.FarmRepository;
import com.chickentest.chickentestapp.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService{
	
	@Autowired
    private FarmRepository farmRepository;
	   
    public List<Object> getFarms(){
    	return farmRepository
    			.findAll()
    			.stream()
    			.map(farm -> getFarmData(farm))
    			.collect(Collectors.toList());
    }
    
    public FarmDTO getFarmData(Farm farm){
    	Farm currentFarm = farmRepository.findById(farm.getId()).get();
    	FarmDTO farmDTO = new FarmDTO();
    	
    	farmDTO.setId(currentFarm.getId());
    	farmDTO.setCreationDate(currentFarm.getCreationDate());
    	farmDTO.setName(currentFarm.getName());
    	farmDTO.setChickens(currentFarm.getChickens());
    	farmDTO.setChickensAmount(currentFarm.getChickensAmount());
    	farmDTO.setEggsAmountTotal(currentFarm.getEggsAmountTotal());
    	
    	return farmDTO;
    }
}
