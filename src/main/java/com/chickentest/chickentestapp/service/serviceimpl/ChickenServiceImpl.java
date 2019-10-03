package com.chickentest.chickentestapp.service.serviceimpl;
 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.dto.EggDTO;
import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.model.Egg;
import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.ChickenRepository;
import com.chickentest.chickentestapp.repository.EggRepository;
import com.chickentest.chickentestapp.repository.FarmRepository;
import com.chickentest.chickentestapp.service.ChickenService;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
    private ChickenRepository chickenRepository;
	
    @Autowired
    private FarmRepository farmRepository;
    
    @Autowired
    private EggRepository eggRepository;

    @Override
    public List<Object> getChickens(){
    	return chickenRepository
    			.findAll()
    			.stream()
    			.map(chicken -> getChickenData(chicken))
    			.collect(Collectors.toList());
    }
    
    @Override
    public ChickenDTO getChickenData(Chicken chicken){
    	Chicken currentChicken = chickenRepository.findById(chicken.getId()).get();
    	ChickenDTO chickenDTO = new ChickenDTO();
    	
    	chickenDTO.setId(currentChicken.getId());
    	chickenDTO.setFarmId(currentChicken.getFarm().getId());
    	chickenDTO.setJoinDate(currentChicken.getJoinDate());
    	chickenDTO.setName(currentChicken.getName());
    	chickenDTO.setEggsAmount(currentChicken.getEggsAmount());
    	
    	return chickenDTO;
    }
    
	@Override
	public ChickenDTO edit(long farm_id, long chicken_id, ChickenDTO chickenDTO) {
		
		Chicken chickenToEdit = chickenRepository.findById(chicken_id).get();
    	ChickenDTO chickenToEditDTO = new ChickenDTO();
        //Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
        
        // Map CHICKEN
    	chickenToEdit.setName(chickenDTO.getName());
    	chickenRepository.save(chickenToEdit);
    	
    	// Map FARM
    	// currentFarm.addChicken(chickenAdded);
    	//farmRepository.save(currentFarm);
    	
    	// Map CHICKEN-DTO
    	chickenToEditDTO.setName(chickenDTO.getName());
    	
		
		return chickenToEditDTO;
	}
    
	@Override
	public ChickenDTO add(ChickenDTO chickenDTO) {
    	Chicken chickenToAdd = new Chicken();
    	ChickenDTO chickenToAddDTO = new ChickenDTO();
        Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
    	
        // Map CHICKEN
        chickenToAdd.setFarm(currentFarm);
        chickenToAdd.setJoinDate(chickenDTO.getJoinDate());
        chickenToAdd.setName(chickenDTO.getName());
        chickenToAdd.setInFarm(chickenDTO.getInFarm());
    	chickenRepository.save(chickenToAdd);
    	
    	// Map FARM
    	currentFarm.addChicken(chickenToAdd);
    	farmRepository.save(currentFarm);
    	
    	// Map CHICKEN-DTO
    	chickenToAddDTO.setId(chickenToAdd.getId());
    	chickenToAddDTO.setJoinDate(chickenDTO.getJoinDate());
    	
    	String chickenName;
    	
    	if(chickenDTO.getName().equals("")) {
	    	int chickenNumber = currentFarm.getChickensAmount() + 1;
			chickenName = currentFarm.getName().concat("'s chicken n°") + chickenNumber;
    	}
    	else {
    		chickenName = chickenDTO.getName();
    	}
		
    	chickenToAdd.setName(chickenName);
    	
    	chickenToAddDTO.setName(chickenDTO.getName());
    	chickenToAddDTO.setFarmId(chickenDTO.getFarmId());
    	chickenToAddDTO.setInFarm(chickenDTO.getInFarm());
		
		return chickenToAddDTO;
		
	}
	
	@Override
	public ChickenDTO addById(long farmId) {
		Farm currentFarm = farmRepository.findById(farmId).get();
    	Chicken chickenToAdd = new Chicken();
		ChickenDTO chickenToAddDTO = new ChickenDTO();
		
		//currentFarm.addChicken(chickenToAdd);
		
        // Map CHICKEN
	
		int chickenNumber = currentFarm.getChickensAmount() + 1;
		String chickenName = currentFarm.getName().concat("'s chicken n°") + chickenNumber;
		
    	chickenToAdd.setName(chickenName);
		chickenToAdd.setFarm(currentFarm);
    	chickenRepository.save(chickenToAdd);
    	
    	// Map FARM
    	currentFarm.addChicken(chickenToAdd);
    	farmRepository.save(currentFarm);
    	
    	// Map CHICKEN-DTO
    	chickenToAddDTO.setId(chickenToAdd.getId());
    	chickenToAddDTO.setJoinDate(chickenToAdd.getJoinDate());
    	chickenToAddDTO.setFarmId(currentFarm.getId());
    	
		return chickenToAddDTO;
	}	

	@Override
	public ChickenDTO delete(ChickenDTO chickenDTO) {
        
        Chicken currentChicken = chickenRepository.findById(chickenDTO.getId()).get();
        Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
                
        currentChicken.setInFarm(false);
        currentFarm.deleteChicken(currentChicken);

        eggRepository.deleteAll(currentChicken.getEggs());
        chickenRepository.delete(currentChicken);
        farmRepository.save(currentFarm);
        
		return chickenDTO;
	}
}
