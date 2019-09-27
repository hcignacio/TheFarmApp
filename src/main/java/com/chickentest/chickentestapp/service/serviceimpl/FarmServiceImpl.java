package com.chickentest.chickentestapp.service.serviceimpl;
 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.dto.FarmDTO;
import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.ChickenRepository;
import com.chickentest.chickentestapp.repository.EggRepository;
import com.chickentest.chickentestapp.repository.FarmRepository;
import com.chickentest.chickentestapp.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService{
	
	@Autowired
    private FarmRepository farmRepository;

	@Autowired
    private ChickenRepository chickenRepository;

	@Autowired
    private EggRepository eggRepository;
	   
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
    	farmDTO.setEggsAmount(currentFarm.getEggsAmountTotal());
    	
    	return farmDTO;
    }

	@Override
	public FarmDTO add(FarmDTO farmDTO) {
		Farm farmToAdd = new Farm();
    	FarmDTO farmToAddDTO = new FarmDTO();
    	
        // Map FARM
        farmToAdd.setName(farmDTO.getName());
        farmToAdd.setCreationDate(farmDTO.getCreationDate());
        farmRepository.save(farmToAdd);
    	
    	// Map FARM-DTO
    	farmToAddDTO.setId(farmToAdd.getId());
    	farmToAddDTO.setCreationDate(farmDTO.getCreationDate());
    	farmToAddDTO.setName(farmDTO.getName());
		
		return farmToAddDTO;
	}
 
	@Override
	public FarmDTO delete(FarmDTO farmDTO) {
        Farm currentFarm = farmRepository.findById(farmDTO.getId()).get();
       
        currentFarm.getChickens().forEach(chicken -> eggRepository.deleteAll(chicken.getEggs()));
        chickenRepository.deleteAll(currentFarm.getChickens());
        farmRepository.delete(currentFarm);
        
		return farmDTO;
	}

	@Override
	public FarmDTO edit(long farm_id, FarmDTO farmDTO) {
		Farm farmToEdit = farmRepository.findById(farm_id).get();
    	FarmDTO farmToEditDTO = new FarmDTO();
        //Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
        
        // Map FARM
    	farmToEdit.setName(farmDTO.getName());
    	farmRepository.save(farmToEdit);
    	
    	// Map FARM
    	// currentFarm.addChicken(chickenAdded);
    	//farmRepository.save(currentFarm);
    	
    	// Map FARM-DTO
    	farmToEditDTO.setName(farmDTO.getName());
    	
		
		return farmToEditDTO;
	}
}
