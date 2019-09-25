package com.chickentest.chickentestapp.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.ChickenRepository;
import com.chickentest.chickentestapp.repository.FarmRepository;
import com.chickentest.chickentestapp.service.ChickenService;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
    private ChickenRepository chickenRepository;
	
    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<Object> getData(){
    	return chickenRepository
    			.findAll()
    			.stream()
    			.map(chicken -> getChickenData(chicken))
    			.collect(Collectors.toList());
    }
    
    @Override
    public Chicken getChickenData(Chicken chicken){
    	Chicken currentChicken = chickenRepository.findById(chicken.getId()).get();
    	return currentChicken;
    }
    
	@Override
	public ChickenDTO add(ChickenDTO chickenDTO) {
    	Chicken chickenAdded = new Chicken();
    	ChickenDTO chickenDTOAdded = new ChickenDTO();
        Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
    	
        // Map CHICKEN
        chickenAdded.setFarm(currentFarm);
    	chickenAdded.setJoinDate(chickenDTO.getJoinDate());
    	chickenAdded.setName(chickenDTO.getName());
    	chickenAdded.setInFarm(chickenDTO.getInFarm());
    	chickenRepository.save(chickenAdded);
    	
    	// Map FARM
    	currentFarm.addChicken(chickenAdded);
    	farmRepository.save(currentFarm);
    	
    	// Map CHICKEN-DTO
    	chickenDTOAdded.setId(chickenAdded.getId());
    	chickenDTOAdded.setJoinDate(chickenDTO.getJoinDate());
    	chickenDTOAdded.setName(chickenDTO.getName());
    	chickenDTO.setFarmId(chickenDTO.getFarmId());
    	chickenDTOAdded.setInFarm(chickenDTO.getInFarm());
		
		return chickenDTOAdded;
		
	}

	@Override
	public ChickenDTO delete(ChickenDTO chickenDTO) {
		return chickenDTO;
	}


	
}
